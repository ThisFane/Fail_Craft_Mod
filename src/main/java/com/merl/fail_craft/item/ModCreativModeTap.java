package com.merl.fail_craft.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativModeTap {
    public static final CreativeModeTab Fail_Craft = new CreativeModeTab("fail_craft") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.Khaos_Crystal.get());
        }
    };
}
