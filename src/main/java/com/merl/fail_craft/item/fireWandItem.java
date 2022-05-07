package com.merl.fail_craft.item;


import net.minecraft.core.NonNullList;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


import java.util.List;
import java.util.Random;

public class fireWandItem extends Item {
    public fireWandItem(Properties pProperties) {
        super(pProperties);
    }

    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {

    }

    public @NotNull InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand){
        Vec3 vec3 = pPlayer.getViewVector(1).normalize();
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        Random random = new Random();

        float f7 = pPlayer.getYRot();
        float f = pPlayer.getXRot();
        float f1 = -Mth.sin(f7 * ((float) Math.PI / 180F)) * Mth.cos(f * ((float) Math.PI / 180F));
        float f2 = -Mth.sin(f * ((float) Math.PI / 180F));
        float f3 = Mth.cos(f7 * ((float) Math.PI / 180F)) * Mth.cos(f * ((float) Math.PI / 180F));



        List<Entity> target = pLevel.getNearestEntity(null, TargetingConditions.forCombat(), pPlayer,10,10,10);
        System.out.println(target);

        for (int j = 0; j < 20; ++j) {
                pLevel.addParticle(ParticleTypes.FLAME, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), (double)f1, (double)f2, (double)f3);
            }
        for (int j = 0; j < 20; ++j) {
            pLevel.addParticle(ParticleTypes.FLAME, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), f1 + random.nextDouble(-0.3,0.3), f2 + random.nextDouble(-0.3,0.3), f3 + random.nextDouble(-0.3,0.3));
        }
        for (int j = 0; j < 20; ++j) {
            pLevel.addParticle(ParticleTypes.FLAME, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), f1 - random.nextDouble(-0.4,0.4), f2 - random.nextDouble(-0.4,0.4), f3 - random.nextDouble(-0.4,0.4));
        }
        return InteractionResultHolder.success(itemstack);


    }

/*

    //This code shoots you like a spawn fire ball on use
    public @NotNull InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        BlockPos blockpos = pContext.getClickedPos();
        BlockState blockstate = level.getBlockState(blockpos);
        boolean flag = false;
        if (!CampfireBlock.canLight(blockstate) && !CandleBlock.canLight(blockstate) && !CandleCakeBlock.canLight(blockstate)) {
            blockpos = blockpos.relative(pContext.getClickedFace());
            if (BaseFireBlock.canBePlacedAt(level, blockpos, pContext.getHorizontalDirection())) {
                this.playSound(level, blockpos);
                level.setBlockAndUpdate(blockpos, BaseFireBlock.getState(level, blockpos));
                level.gameEvent(pContext.getPlayer(), GameEvent.BLOCK_PLACE, blockpos);
                flag = true;
            }
        } else {
            this.playSound(level, blockpos);
            level.setBlockAndUpdate(blockpos, blockstate.setValue(BlockStateProperties.LIT, Boolean.valueOf(true)));
            level.gameEvent(pContext.getPlayer(), GameEvent.BLOCK_PLACE, blockpos);
            flag = true;
        }

        if (flag) {
            pContext.getItemInHand().shrink(1);
            return InteractionResult.sidedSuccess(level.isClientSide);
        } else {
            return InteractionResult.FAIL;
        }
    }


    private void playSound(Level pLevel, BlockPos pPos) {
        Random random = pLevel.getRandom();
        pLevel.playSound((Player)null, pPos, SoundEvents.FIRECHARGE_USE, SoundSource.BLOCKS, 1.0F, (random.nextFloat() - random.nextFloat()) * 0.2F + 1.0F);
    }
 */



}
