package com.merl.fail_craft;

import com.merl.fail_craft.block.Modblocks;
import com.merl.fail_craft.block.entity.ModBlockEntities;
import com.merl.fail_craft.item.ModItems;
import com.merl.fail_craft.recipe.ModRecipes;
import com.merl.fail_craft.screen.ExtractorScreen;
import com.merl.fail_craft.screen.ModMenuTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(Fail_Craft.MOD_ID)
public class Fail_Craft
{
    public static final String MOD_ID = "fail_craft";


    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public Fail_Craft() {

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        Modblocks.register(eventBus);
        ModBlockEntities.register(eventBus);
        ModMenuTypes.register(eventBus);
        ModRecipes.register(eventBus);

        eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetup(final FMLClientSetupEvent event){
        ItemBlockRenderTypes.setRenderLayer(Modblocks.KHAOS_FLOWER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(Modblocks.POT_KHAOS_FLOWER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(Modblocks.FAIL_TANK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(Modblocks.MIXER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(Modblocks.CORTEX_CORE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(Modblocks.CORTEX_CORE.get(), RenderType.cutout());

        MenuScreens.register(ModMenuTypes.EXTRACTOR_MENU.get(), ExtractorScreen::new);
    }


    private void setup(final FMLCommonSetupEvent event) {

        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(Modblocks.KHAOS_FLOWER.getId(), Modblocks.POT_KHAOS_FLOWER);
        });
    }


}
// TODO: 09/04/2022 Textures: Caramel , Buttter
//TODO: Cortex Lang
//It's never to Choco-late for this.
