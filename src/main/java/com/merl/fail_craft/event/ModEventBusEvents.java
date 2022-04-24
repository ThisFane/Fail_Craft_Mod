package com.merl.fail_craft.event;

import com.merl.fail_craft.Fail_Craft;
import com.merl.fail_craft.event.loot.MucilageFromLeavesModifier;
import com.merl.fail_craft.recipe.ExtractorRecipes;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = Fail_Craft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerModifierSerializers(@Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>> event){

        event.getRegistry().registerAll(new MucilageFromLeavesModifier.Serializer().setRegistryName(new ResourceLocation(Fail_Craft.MOD_ID, "mucilage_from_oak_leaves")));
        event.getRegistry().registerAll(new MucilageFromLeavesModifier.Serializer().setRegistryName(new ResourceLocation(Fail_Craft.MOD_ID, "mucilage_from_birch_leaves")));
        event.getRegistry().registerAll(new MucilageFromLeavesModifier.Serializer().setRegistryName(new ResourceLocation(Fail_Craft.MOD_ID, "mucilage_from_acacia_leaves")));
        event.getRegistry().registerAll(new MucilageFromLeavesModifier.Serializer().setRegistryName(new ResourceLocation(Fail_Craft.MOD_ID, "mucilage_from_azalea_leaves")));
        event.getRegistry().registerAll(new MucilageFromLeavesModifier.Serializer().setRegistryName(new ResourceLocation(Fail_Craft.MOD_ID, "mucilage_from_dark_oak_leaves")));
        event.getRegistry().registerAll(new MucilageFromLeavesModifier.Serializer().setRegistryName(new ResourceLocation(Fail_Craft.MOD_ID, "mucilage_from_jungle_leaves")));
        event.getRegistry().registerAll(new MucilageFromLeavesModifier.Serializer().setRegistryName(new ResourceLocation(Fail_Craft.MOD_ID, "mucilage_from_spruce_leaves")));
    }

    @SubscribeEvent
    public static void registerRecipeTypes(final RegistryEvent.Register<RecipeSerializer<?>> event){
        Registry.register(Registry.RECIPE_TYPE, ExtractorRecipes.Type.ID, ExtractorRecipes.Type.INSTANCE);
    }


}
