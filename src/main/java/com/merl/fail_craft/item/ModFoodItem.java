package com.merl.fail_craft.item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistryEntry;
import net.minecraftforge.registries.IForgeRegistryModifiable;

import java.util.Random;

public class ModFoodItem {
    public static final FoodProperties PUMPKIN_MILK = (new FoodProperties.Builder().nutrition(4).saturationMod(0.3F).build());
    public static final FoodProperties CHOCOLATE_MILK = (new FoodProperties.Builder().nutrition(7).saturationMod(0.5F).build());
    public static final FoodProperties SUGAR_WATER = (new FoodProperties.Builder().nutrition(1).saturationMod(0.0F).effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED,50,1),1F).build());
    public static final FoodProperties CARAMEL = (new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED,70,1),1F).build());
    public static final FoodProperties SLICED_BREAD = (new FoodProperties.Builder().nutrition(1).saturationMod(0.1F).build());


}


