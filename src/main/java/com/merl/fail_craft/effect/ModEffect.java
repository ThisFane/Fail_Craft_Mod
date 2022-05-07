package com.merl.fail_craft.effect;

import com.merl.fail_craft.Fail_Craft;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffect {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Fail_Craft.MOD_ID);

    public static final RegistryObject<MobEffect> DREAMY = MOB_EFFECTS.register("dreamy", () -> new DreamEffect(MobEffectCategory.NEUTRAL, 12401351));

    public static void register(IEventBus eventBus){
        MOB_EFFECTS.register(eventBus);
    }

}
