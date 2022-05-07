package com.merl.fail_craft.block.entity;


import com.merl.fail_craft.recipe.ExtractorRecipes;
import com.merl.fail_craft.screen.ExtractorMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.util.Optional;
import java.util.Random;


public class ExtractorBlockEntity extends BlockEntity implements MenuProvider {


    private final ItemStackHandler itemHandler = new ItemStackHandler(8){
        @Override
        protected void onContentsChanged(int slot){
            setChanged();
        }
    };
    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();



    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 72;
    private float extractorEnergy = 0;
    private static float maxEnergy = 100000;





    public ExtractorBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
        super(ModBlockEntities.EXTRACTOR_BLOCK_ENTITY.get(), pWorldPosition, pBlockState);
        this.data = new ContainerData() {
            public int get(int index) {
                switch (index){
                    case 0: return ExtractorBlockEntity.this.progress;
                    case 1: return ExtractorBlockEntity.this.maxProgress;
                    case 2: return Math.round(ExtractorBlockEntity.this.extractorEnergy);
                    default: return 0;
                }
            }
            public void set(int index, int value){
                switch (index){
                    case 0:  ExtractorBlockEntity.this.progress = value; break;
                    case 1:  ExtractorBlockEntity.this.maxProgress = value; break;
                    case 2:  ExtractorBlockEntity.this.extractorEnergy = value; break;
                }
            }
            public int getCount(){return 3;}
        };
    }


    @Override
    public Component getDisplayName() {
        return new TextComponent(" ");

    }




    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory, Player pPlayer) {
        return new ExtractorMenu(pContainerId, pInventory, this, this.data);
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @javax.annotation.Nullable Direction side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return lazyItemHandler.cast();
        }

        return super.getCapability(cap, side);
    }


    @Override
    public void onLoad( ) {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }



    @Override
    public void invalidateCaps()  {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }


   @Override
   protected void saveAdditional(@NotNull CompoundTag tag) {
       tag.put("inventory", itemHandler.serializeNBT());
       tag.putInt("extractor.progress", progress);
       tag.putFloat("extractor.extractorEnergy", extractorEnergy);
       super.saveAdditional(tag);
   }


   @Override
   public void load(CompoundTag nbt) {
       super.load(nbt);
       itemHandler.deserializeNBT(nbt.getCompound("inventory"));
       progress = nbt.getInt("extractor.progress");
       extractorEnergy = nbt.getFloat("extractor.extractorEnergy");
   }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    public static boolean hasNotMaxEnergy(ExtractorBlockEntity pBlockEntity){
        if(pBlockEntity.extractorEnergy + ForgeHooks.getBurnTime(pBlockEntity.itemHandler.getStackInSlot(0), RecipeType.SMELTING) <= maxEnergy){
            return true;
        }else
            return false;
    }

    public static void tick(Level pLevel, BlockPos pPos, BlockState pState, ExtractorBlockEntity pBlockEntity) {
        if(pBlockEntity.itemHandler.getStackInSlot(0).getItem() != Items.AIR && hasNotMaxEnergy(pBlockEntity)){
            pBlockEntity.extractorEnergy = pBlockEntity.extractorEnergy + ForgeHooks.getBurnTime(pBlockEntity.itemHandler.getStackInSlot(0), RecipeType.SMELTING);
            pBlockEntity.itemHandler.extractItem(0, 1, false);
        }

        if(hasRecipe(pBlockEntity)) {
            pBlockEntity.progress++;
            setChanged(pLevel, pPos, pState);
            if(pBlockEntity.progress > pBlockEntity.maxProgress) {
                craftItem(pBlockEntity);
            }
        } else {
            pBlockEntity.resetProgress();
            setChanged(pLevel, pPos, pState);
        }
    }



    private static boolean hasRecipe(ExtractorBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        Optional<ExtractorRecipes> match = level.getRecipeManager()
                .getRecipeFor(ExtractorRecipes.Type.INSTANCE, inventory, level);


        return match.isPresent() && canInsertAmountIntoOutputSlot(inventory) && canInsertItemIntoOutputSlot(inventory, match.get().getResultItem()) && entity.extractorEnergy >= 100;
    }


    public static int itemChance(){
        return new Random().nextInt(0,2);
    }


    private static void craftItem(ExtractorBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        entity.extractorEnergy = entity.extractorEnergy -100;

        Optional<ExtractorRecipes> match = level.getRecipeManager()
                .getRecipeFor(ExtractorRecipes.Type.INSTANCE, inventory, level);

        if(match.isPresent()) {

            entity.itemHandler.extractItem(0,1, false);
            entity.itemHandler.extractItem(1,1, false);

            entity.itemHandler.setStackInSlot(2, new ItemStack(match.get().getResultItem().getItem(),
                    entity.itemHandler.getStackInSlot(3).getCount() + itemChance()));
            entity.itemHandler.setStackInSlot(3, new ItemStack(match.get().getResultItem().getItem(),
                    entity.itemHandler.getStackInSlot(3).getCount() + itemChance()));
            entity.itemHandler.setStackInSlot(4, new ItemStack(match.get().getResultItem().getItem(),
                    entity.itemHandler.getStackInSlot(4).getCount() + itemChance()));
            entity.itemHandler.setStackInSlot(5, new ItemStack(match.get().getResultItem().getItem(),
                    entity.itemHandler.getStackInSlot(5).getCount() + itemChance()));
            entity.itemHandler.setStackInSlot(6, new ItemStack(match.get().getResultItem().getItem(),
                    entity.itemHandler.getStackInSlot(6).getCount() + itemChance()));
            entity.itemHandler.setStackInSlot(7, new ItemStack(match.get().getResultItem().getItem(),
                    entity.itemHandler.getStackInSlot(7).getCount() + itemChance()));

            System.out.println(itemChance());
            entity.resetProgress();
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleContainer inventory, ItemStack output) {
        return inventory.getItem(3).getItem() == output.getItem() || inventory.getItem(3).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleContainer inventory) {
        return inventory.getItem(3).getMaxStackSize() > inventory.getItem(3).getCount();
    }
}


