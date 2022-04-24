package com.merl.fail_craft.block;

import com.merl.fail_craft.Fail_Craft;
import com.merl.fail_craft.item.ModCreativModeTap;
import com.merl.fail_craft.item.ModItems;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class Modblocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Fail_Craft.MOD_ID);

    //Block
    public static final RegistryObject<Block> KHAOS_ORE = registerBlock("khaos_ore", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1F).requiresCorrectToolForDrops()), ModCreativModeTap.Fail_Craft);
    public static final RegistryObject<Block> KHAOS_BLOCK = registerBlock("khaos_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1F).requiresCorrectToolForDrops()), ModCreativModeTap.Fail_Craft);
    public static final RegistryObject<Block> KHAOS_BRICK = registerBlock("khaos_brick", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1F).requiresCorrectToolForDrops()), ModCreativModeTap.Fail_Craft);
    public static final RegistryObject<Block> CORTEX_CORE = registerBlock("cortex_core", () -> new CortexCoreBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1F).requiresCorrectToolForDrops().noOcclusion()), ModCreativModeTap.Fail_Craft);


    public static final RegistryObject<Block> CORTEX_BRICK = registerBlock("cortex_brick", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1F).requiresCorrectToolForDrops()), ModCreativModeTap.Fail_Craft);
    public static final RegistryObject<Block> CORTEX_BRICK_BLACK = registerBlock("cortex_brick_black", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1F).requiresCorrectToolForDrops()), ModCreativModeTap.Fail_Craft);
    public static final RegistryObject<Block> CORTEX_BRICK_RED = registerBlock("cortex_brick_red", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1F).requiresCorrectToolForDrops()), ModCreativModeTap.Fail_Craft);
    public static final RegistryObject<Block> CORTEX_BRICK_GREEN = registerBlock("cortex_brick_green", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1F).requiresCorrectToolForDrops()), ModCreativModeTap.Fail_Craft);
    public static final RegistryObject<Block> CORTEX_BRICK_BROWN = registerBlock("cortex_brick_brown", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1F).requiresCorrectToolForDrops()), ModCreativModeTap.Fail_Craft);
    public static final RegistryObject<Block> CORTEX_BRICK_BLUE = registerBlock("cortex_brick_blue", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1F).requiresCorrectToolForDrops()), ModCreativModeTap.Fail_Craft);
    public static final RegistryObject<Block> CORTEX_BRICK_PURPLE = registerBlock("cortex_brick_purple", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1F).requiresCorrectToolForDrops()), ModCreativModeTap.Fail_Craft);
    public static final RegistryObject<Block> CORTEX_BRICK_CYAN = registerBlock("cortex_brick_cyan", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1F).requiresCorrectToolForDrops()), ModCreativModeTap.Fail_Craft);
    public static final RegistryObject<Block> CORTEX_BRICK_LIGHT_GRAY = registerBlock("cortex_brick_light_gray", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1F).requiresCorrectToolForDrops()), ModCreativModeTap.Fail_Craft);
    public static final RegistryObject<Block> CORTEX_BRICK_GRAY = registerBlock("cortex_brick_gray", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1F).requiresCorrectToolForDrops()), ModCreativModeTap.Fail_Craft);
    public static final RegistryObject<Block> CORTEX_BRICK_PINK = registerBlock("cortex_brick_pink", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1F).requiresCorrectToolForDrops()), ModCreativModeTap.Fail_Craft);
    public static final RegistryObject<Block> CORTEX_BRICK_LIME = registerBlock("cortex_brick_lime", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1F).requiresCorrectToolForDrops()), ModCreativModeTap.Fail_Craft);
    public static final RegistryObject<Block> CORTEX_BRICK_YELLOW = registerBlock("cortex_brick_yellow", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1F).requiresCorrectToolForDrops()), ModCreativModeTap.Fail_Craft);
    public static final RegistryObject<Block> CORTEX_BRICK_LIGHT_BLUE = registerBlock("cortex_brick_light_blue", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1F).requiresCorrectToolForDrops()), ModCreativModeTap.Fail_Craft);
    public static final RegistryObject<Block> CORTEX_BRICK_MAGENTA = registerBlock("cortex_brick_magenta", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1F).requiresCorrectToolForDrops()), ModCreativModeTap.Fail_Craft);
    public static final RegistryObject<Block> CORTEX_BRICK_ORANGE = registerBlock("cortex_brick_orange", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1F).requiresCorrectToolForDrops()), ModCreativModeTap.Fail_Craft);
    public static final RegistryObject<Block> CORTEX_BRICK_WHITE = registerBlock("cortex_brick_white", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1F).requiresCorrectToolForDrops()), ModCreativModeTap.Fail_Craft);

    //slabs
    public static final RegistryObject<Block> CORTEX_BRICK_SLAB = registerBlock("cortex_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1F).requiresCorrectToolForDrops()), ModCreativModeTap.Fail_Craft);
    public static final RegistryObject<Block> CORTEX_BRICK_BLACK_SLAB = registerBlock("cortex_brick_black_slab", () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1F).requiresCorrectToolForDrops()), ModCreativModeTap.Fail_Craft);
    public static final RegistryObject<Block> CORTEX_BRICK_RED_SLAB = registerBlock("cortex_brick_red_slab", () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1F).requiresCorrectToolForDrops()), ModCreativModeTap.Fail_Craft);
    public static final RegistryObject<Block> CORTEX_BRICK_GREEN_SLAB = registerBlock("cortex_brick_green_slab", () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1F).requiresCorrectToolForDrops()), ModCreativModeTap.Fail_Craft);
    public static final RegistryObject<Block> CORTEX_BRICK_BROWN_SLAB = registerBlock("cortex_brick_brown_slab", () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1F).requiresCorrectToolForDrops()), ModCreativModeTap.Fail_Craft);
    public static final RegistryObject<Block> CORTEX_BRICK_BLUE_SLAB = registerBlock("cortex_brick_blue_slab", () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1F).requiresCorrectToolForDrops()), ModCreativModeTap.Fail_Craft);
    public static final RegistryObject<Block> CORTEX_BRICK_PURPLE_SLAB = registerBlock("cortex_brick_purple_slab", () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1F).requiresCorrectToolForDrops()), ModCreativModeTap.Fail_Craft);
    public static final RegistryObject<Block> CORTEX_BRICK_CYAN_SLAB = registerBlock("cortex_brick_cyan_slab", () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1F).requiresCorrectToolForDrops()), ModCreativModeTap.Fail_Craft);
    public static final RegistryObject<Block> CORTEX_BRICK_LIGHT_GRAY_SLAB = registerBlock("cortex_brick_light_gray_slab", () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1F).requiresCorrectToolForDrops()), ModCreativModeTap.Fail_Craft);
    public static final RegistryObject<Block> CORTEX_BRICK_GRAY_SLAB = registerBlock("cortex_brick_gray_slab", () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1F).requiresCorrectToolForDrops()), ModCreativModeTap.Fail_Craft);
    public static final RegistryObject<Block> CORTEX_BRICK_PINK_SLAB = registerBlock("cortex_brick_pink_slab", () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1F).requiresCorrectToolForDrops()), ModCreativModeTap.Fail_Craft);
    public static final RegistryObject<Block> CORTEX_BRICK_LIME_SLAB = registerBlock("cortex_brick_lime_slab", () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1F).requiresCorrectToolForDrops()), ModCreativModeTap.Fail_Craft);
    public static final RegistryObject<Block> CORTEX_BRICK_YELLOW_SLAB = registerBlock("cortex_brick_yellow_slab", () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1F).requiresCorrectToolForDrops()), ModCreativModeTap.Fail_Craft);
    public static final RegistryObject<Block> CORTEX_BRICK_LIGHT_BLUE_SLAB = registerBlock("cortex_brick_light_blue_slab", () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1F).requiresCorrectToolForDrops()), ModCreativModeTap.Fail_Craft);
    public static final RegistryObject<Block> CORTEX_BRICK_MAGENTA_SLAB = registerBlock("cortex_brick_magenta_slab", () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1F).requiresCorrectToolForDrops()), ModCreativModeTap.Fail_Craft);
    public static final RegistryObject<Block> CORTEX_BRICK_ORANGE_SLAB = registerBlock("cortex_brick_orange_slab", () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1F).requiresCorrectToolForDrops()), ModCreativModeTap.Fail_Craft);
    public static final RegistryObject<Block> CORTEX_BRICK_WHITE_SLAB = registerBlock("cortex_brick_white_slab", () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1F).requiresCorrectToolForDrops()), ModCreativModeTap.Fail_Craft);


    //Light Blocks
    public static final RegistryObject<Block> Glowing_Khaos_Block = registerBlock("glowing_khaos_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1F).requiresCorrectToolForDrops().lightLevel(value -> 15)), ModCreativModeTap.Fail_Craft);
    public static final RegistryObject<Block> Glowing_Khaos_Brick = registerBlock("glowing_khaos_brick", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1F).requiresCorrectToolForDrops().lightLevel(value -> 15)), ModCreativModeTap.Fail_Craft);

    //flower
    public static final RegistryObject<Block> KHAOS_FLOWER = registerBlock("khaos_flower", () -> new FlowerBlock(MobEffects.CONFUSION, 9, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativModeTap.Fail_Craft);
    public static final RegistryObject<Block> POT_KHAOS_FLOWER = registerBlockWithoutItem("pot_khaos_flower", () -> new FlowerPotBlock(null, Modblocks.KHAOS_FLOWER, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()));

    //Complex
    public static final RegistryObject<Block> FAIL_TANK = registerBlock("fail_tank", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1F).requiresCorrectToolForDrops().noOcclusion()), ModCreativModeTap.Fail_Craft);
    public static final RegistryObject<Block> MIXER = registerBlock("mixer", () -> new MixerBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1F).requiresCorrectToolForDrops().noOcclusion()), ModCreativModeTap.Fail_Craft);
    public static final RegistryObject<Block> EXTRACTOR = registerBlock("extractor", () -> new ExtractorBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1F).requiresCorrectToolForDrops().noOcclusion()), ModCreativModeTap.Fail_Craft);







    private static <T extends  Block> RegistryObject<T> registerBlockWithoutItem(String name, Supplier<T> block){
        return BLOCKS.register(name, block);
    }

    private static <T extends  Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name,toReturn,tab);
        return toReturn;
    }

    private static <t extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<t> block, CreativeModeTab tab){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }


    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }



}

