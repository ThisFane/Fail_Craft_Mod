package com.merl.fail_craft.item;

import com.blakebr0.cucumber.item.BaseReusableItem;
import com.blakebr0.cucumber.lib.Tooltips;
import net.minecraft.network.chat.Component;
import com.blakebr0.cucumber.lib.Tooltips;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;


import java.util.List;
import java.util.function.Function;

public class KnifeItem extends BaseReusableItem {
    public KnifeItem(Function<Properties, Properties> properties) {
        super(1000, properties);
    }


    @Override
    public boolean isBarVisible(ItemStack stack) {
        return false;
    }


}
