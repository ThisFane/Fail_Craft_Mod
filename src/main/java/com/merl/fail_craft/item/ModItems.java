package com.merl.fail_craft.item;

import com.merl.fail_craft.Fail_Craft;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;




public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Fail_Craft.MOD_ID);

    //Basic Items
    //public static final RegistryObject<Item> Khaos_Crystal = ITEMS.register("khaos_crystal", () -> new Item(new Item.Properties().tab(ModCreativModeTap.Fail_Craft).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> Khaos_Dust = ITEMS.register("khaos_dust", () -> new Item(new Item.Properties().tab(ModCreativModeTap.Fail_Craft).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> Mucilage = ITEMS.register("mucilage", () -> new Item(new Item.Properties().tab(ModCreativModeTap.Fail_Craft)));
    public static final RegistryObject<Item> ANIMA_DUST = ITEMS.register("anima_dust", () -> new Item(new Item.Properties().tab(ModCreativModeTap.Fail_Craft).rarity(Rarity.EPIC)));



    public static final RegistryObject<Item> Khaos_Crystal = ITEMS.register("khaos_crystal", () -> new snowballlikeprojectileItem(new Item.Properties().tab(ModCreativModeTap.Fail_Craft).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> FIREBALL = ITEMS.register("fireball", () -> new snowballlikeprojectileItem(new Item.Properties().tab(ModCreativModeTap.Fail_Craft).rarity(Rarity.EPIC)));

    //Tools
    public static final RegistryObject<Item> Block_Crusher = ITEMS.register("block_crusher", () -> new PickaxeItem(Tiers.STONE, 1, -2.8F, (new Item.Properties()).tab(ModCreativModeTap.Fail_Craft)));
    public static final RegistryObject<Item> KHAOS_TESTER = ITEMS.register("khais_tester", () -> new snowballlikeprojectileItem((new Item.Properties()).tab(ModCreativModeTap.Fail_Craft)));

    //Knifes
    //public static final RegistryObject<Item> WOODEN_COOKING_KNIFE = ITEMS.register("wooden_cooking_knife", () -> new SwordItem(Tiers.WOOD, 0, 0.9F, (new Item.Properties()).tab(ModCreativModeTap.Fail_Craft)));
    //public static final RegistryObject<Item> STONE_COOKING_KNIFE = ITEMS.register("stone_cooking_knife", () -> new SwordItem(Tiers.STONE, -1, 0.9F, (new Item.Properties()).tab(ModCreativModeTap.Fail_Craft)));
    //public static final RegistryObject<Item> IRON_COOKING_KNIFE = ITEMS.register("iron_cooking_knife", () -> new SwordItem(Tiers.IRON, -2, 0.9F, (new Item.Properties()).tab(ModCreativModeTap.Fail_Craft)));
    //public static final RegistryObject<Item> DIAMOND_COOKING_KNIFE = ITEMS.register("diamond_cooking_knife", () -> new SwordItem(Tiers.DIAMOND, -2, 0.9F, (new Item.Properties()).tab(ModCreativModeTap.Fail_Craft)));
    //public static final RegistryObject<Item> KHAOS_COOKING_KNIFE = ITEMS.register("khaos_cooking_knife", () -> new SwordItem(Tiers.DIAMOND, -2, 0.9F, (new Item.Properties()).tab(ModCreativModeTap.Fail_Craft)));

    public static final RegistryObject<Item> WOODEN_COOKING_KNIFE = ITEMS.register("wooden_cooking_knife", () -> new KnifeItem(properties -> new Item.Properties().durability(127).tab(ModCreativModeTap.Fail_Craft)));
    public static final RegistryObject<Item> STONE_COOKING_KNIFE = ITEMS.register("stone_cooking_knife", () -> new KnifeItem(properties -> new Item.Properties().durability(255).tab(ModCreativModeTap.Fail_Craft)));
    public static final RegistryObject<Item> IRON_COOKING_KNIFE = ITEMS.register("iron_cooking_knife", () -> new KnifeItem(properties -> new Item.Properties().durability(511).tab(ModCreativModeTap.Fail_Craft)));
    public static final RegistryObject<Item> DIAMOND_COOKING_KNIFE = ITEMS.register("diamond_cooking_knife", () -> new KnifeItem(properties -> new Item.Properties().durability(1023).tab(ModCreativModeTap.Fail_Craft)));
    public static final RegistryObject<Item> KHAOS_COOKING_KNIFE = ITEMS.register("khaos_cooking_knife", () -> new  KnifeItem(properties -> new Item.Properties().durability(2047).tab(ModCreativModeTap.Fail_Craft)));
    public static final RegistryObject<Item> MIXING_CUP = ITEMS.register("mixing_cup", () -> new  KnifeItem(properties -> new Item.Properties().durability(999).tab(ModCreativModeTap.Fail_Craft)));


    //Food items
    public static final RegistryObject<Item> Soaked_Pumpkin_Seeds = ITEMS.register("soaked_pumpkin_seeds", () -> new Item(new Item.Properties().tab(ModCreativModeTap.Fail_Craft).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> Drinking_Water = ITEMS.register("drinking_water", () -> new Item(new Item.Properties().tab(ModCreativModeTap.Fail_Craft).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> Pumpkin_Milk = ITEMS.register("pumpkin_milk", () -> new Item(new Item.Properties().tab(ModCreativModeTap.Fail_Craft).rarity(Rarity.UNCOMMON).food(ModFoodItem.PUMPKIN_MILK)));
    public static final RegistryObject<Item> Fresh_Milk = ITEMS.register("fresh_milk", () -> new Item(new Item.Properties().tab(ModCreativModeTap.Fail_Craft).rarity(Rarity.UNCOMMON).food(ModFoodItem.PUMPKIN_MILK)));
    public static final RegistryObject<Item> Chocolate_Milk = ITEMS.register("chocolate_milk", () -> new Item(new Item.Properties().tab(ModCreativModeTap.Fail_Craft).rarity(Rarity.EPIC).food(ModFoodItem.CHOCOLATE_MILK)));
    public static final RegistryObject<Item> cocoa_dust = ITEMS.register("cocoa_dust", () -> new Item(new Item.Properties().tab(ModCreativModeTap.Fail_Craft).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> Sugar_Water = ITEMS.register("sugar_water", () -> new Item(new Item.Properties().tab(ModCreativModeTap.Fail_Craft).rarity(Rarity.UNCOMMON).food(ModFoodItem.SUGAR_WATER)));
    public static final RegistryObject<Item> Caramel = ITEMS.register("caramel", () -> new Item(new Item.Properties().tab(ModCreativModeTap.Fail_Craft).rarity(Rarity.UNCOMMON).food(ModFoodItem.CARAMEL)));
    public static final RegistryObject<Item> Sliced_Bread = ITEMS.register("sliced_bread", () -> new Item(new Item.Properties().tab(ModCreativModeTap.Fail_Craft).rarity(Rarity.UNCOMMON).food(ModFoodItem.SLICED_BREAD)));
    public static final RegistryObject<Item> BUTTER = ITEMS.register("butter", () -> new Item(new Item.Properties().tab(ModCreativModeTap.Fail_Craft).rarity(Rarity.UNCOMMON)));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
