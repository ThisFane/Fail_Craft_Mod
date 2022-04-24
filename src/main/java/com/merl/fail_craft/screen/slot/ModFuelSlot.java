package com.merl.fail_craft.screen.slot;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;


public class ModFuelSlot extends SlotItemHandler {
    private AbstractFurnaceBlockEntity menu;

    public ModFuelSlot(IItemHandler itemHandler, int index, int x, int y) {
        super(itemHandler, index, x, y);
    }
    @Override
    public boolean mayPlace(ItemStack stack) {
        return AbstractFurnaceBlockEntity.isFuel(stack) || isBucket(stack);
    }
    public int getMaxStackSize(ItemStack stack) {
        return isBucket(stack) ? 1 : super.getMaxStackSize(stack);
    }

    public static boolean isBucket(ItemStack stack) {
        return stack.is(Items.BUCKET);
    }
}