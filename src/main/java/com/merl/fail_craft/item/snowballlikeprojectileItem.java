package com.merl.fail_craft.item;

import com.merl.fail_craft.entity.SnowballLikeProjectile;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class snowballlikeprojectileItem extends Item {
    public snowballlikeprojectileItem(Properties pProperties) {
        super(pProperties);
    }

    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand){
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        pLevel.playSound((Player)null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.ENDER_EYE_LAUNCH, SoundSource.NEUTRAL, 0.5F, 0.4F / (pLevel.getRandom().nextFloat() * 0.4F + 0.8F));
        if (!pLevel.isClientSide) {
            SnowballLikeProjectile snowballlikeprojectile = new SnowballLikeProjectile(pLevel, pPlayer);
            snowballlikeprojectile.setItem(itemstack);
            snowballlikeprojectile.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 2.5F, 1.0F);
            pLevel.addFreshEntity(snowballlikeprojectile);
        }
        pPlayer.awardStat(Stats.ITEM_USED.get(this));
        if (!pPlayer.getAbilities().instabuild) {
            itemstack.shrink(1);
        }

        return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
    }
}
