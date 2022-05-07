package com.merl.fail_craft.effect;


import net.minecraft.client.Minecraft;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;


public class DreamEffect extends MobEffect {
    protected DreamEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier){
            if(pLivingEntity.isSleeping() && pLivingEntity.canChangeDimensions()){
                    System.out.println("Dream Start");
                    pLivingEntity.stopSleeping();
                    pLivingEntity.changeDimension(((ServerLevel)pLivingEntity.level).getServer().getLevel(Level.END));
                    pLivingEntity.removeEffect(this);
            }
    }





    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier){
        return true;
    }


}
