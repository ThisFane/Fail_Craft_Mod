package com.merl.fail_craft.recipe;

import com.merl.fail_craft.Fail_Craft;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Fail_Craft.MOD_ID);



    public static final RegistryObject<RecipeSerializer<ExtractorRecipes>> EXTRACTOR_SERIALIZER = SERIALIZERS.register("extracting", () -> ExtractorRecipes.Serializer.INSTANCE);


    public static void register(IEventBus eventBus){
        SERIALIZERS.register(eventBus);
    }
}
