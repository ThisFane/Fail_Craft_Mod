package com.merl.fail_craft.util;

import com.merl.fail_craft.Fail_Craft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModTags {
    public static class Blocks {

    }

    public static class Items {
        public static final TagKey<Item> Kitchen_Knife = forgeTag("tools/kitchen_knife");
        public static final TagKey<Item> FireBall = forgeTag("can_explode");


        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(Fail_Craft.MOD_ID, name));
        }

        private static TagKey<Item> forgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }
}