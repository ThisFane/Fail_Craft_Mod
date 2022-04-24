package com.merl.fail_craft.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.merl.fail_craft.Fail_Craft;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;


public class ExtractorRecipes implements Recipe<SimpleContainer> {
   private final ResourceLocation id;
   private final ItemStack output;
   private final NonNullList<Ingredient> recipesItems;


   public ExtractorRecipes(ResourceLocation id, ItemStack output, NonNullList<Ingredient> recipesItems){
       this.id = id;
       this.output = output;
       this.recipesItems = recipesItems;
   }

   @Override
    public boolean matches(SimpleContainer pContainer, Level pLevel) {
        return recipesItems.get(0).test(pContainer.getItem(1));
    }

    @Override
    public ItemStack assemble(SimpleContainer pContainer) {
        return null;
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem() {
        return output.copy();
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<ExtractorRecipes>{
       private Type() {}
       public static Type INSTANCE = new Type();
       public static final String ID = "extracting";
    }


    public static class Serializer implements RecipeSerializer<ExtractorRecipes> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID =
                new ResourceLocation(Fail_Craft.MOD_ID,"extracting");

        @Override
        public ExtractorRecipes fromJson(ResourceLocation id, JsonObject json) {
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "output"));

            JsonArray ingredients = GsonHelper.getAsJsonArray(json, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(1, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            return new ExtractorRecipes(id, output, inputs);
        }

        @Override
        public ExtractorRecipes fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(buf.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork(buf));
            }

            ItemStack output = buf.readItem();
            return new ExtractorRecipes(id, output, inputs);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, ExtractorRecipes recipe) {
            buf.writeInt(recipe.getIngredients().size());
            for (Ingredient ing : recipe.getIngredients()) {
                ing.toNetwork(buf);
            }
            buf.writeItemStack(recipe.getResultItem(), false);
        }

        @Override
        public RecipeSerializer<?> setRegistryName(ResourceLocation name) {
            return INSTANCE;
        }

        @Nullable
        @Override
        public ResourceLocation getRegistryName() {
            return ID;
        }

        @Override
        public Class<RecipeSerializer<?>> getRegistryType() {
            return Serializer.castClass(RecipeSerializer.class);
        }

        @SuppressWarnings("unchecked") // Need this wrapper, because generics
        private static <G> Class<G> castClass(Class<?> cls) {
            return (Class<G>)cls;
        }
    }
}
