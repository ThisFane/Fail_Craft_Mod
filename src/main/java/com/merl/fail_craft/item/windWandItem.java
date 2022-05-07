package com.merl.fail_craft.item;


import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.eventbus.EventBus;


public class windWandItem extends Item {
    public windWandItem(Properties pProperties) {
        super(pProperties);
    }

    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if(pIsSelected) {
            pEntity.fallDistance = 0F;
        }

    }






    //This code shoots you like a TridentItem on use
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);

        float f7 = pPlayer.getYRot();
        float f = pPlayer.getXRot();
        float f1 = -Mth.sin(f7 * ((float)Math.PI / 180F)) * Mth.cos(f * ((float)Math.PI / 180F));
        float f2 = -Mth.sin(f * ((float)Math.PI / 180F));
        float f3 = Mth.cos(f7 * ((float)Math.PI / 180F)) * Mth.cos(f * ((float)Math.PI / 180F));
        float f4 = Mth.sqrt(f1 * f1 + f2 * f2 + f3 * f3);
        float f5 = 3.0F * ((1.0F + (float)1) / 4.0F);
        f1 *= f5 / f4;
        f2 *= f5 / f4;
        f3 *= f5 / f4;
        pPlayer.push((double)f1, (double)f2, (double)f3);
        pPlayer.startAutoSpinAttack(20);
        if (pPlayer.isOnGround()) {
            float f6 = 1.1999999F;
            pPlayer.move(MoverType.SELF, new Vec3(0.0D, (double)1.1999999F, 0.0D));

        }
        return InteractionResultHolder.success(itemstack);
    }


}
