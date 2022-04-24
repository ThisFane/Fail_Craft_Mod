package com.merl.fail_craft.block.entity;

import com.merl.fail_craft.Fail_Craft;
import com.merl.fail_craft.block.Modblocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> Block_Entities = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, Fail_Craft.MOD_ID);


    public static final RegistryObject<BlockEntityType<ExtractorBlockEntity>> EXTRACTOR_BLOCK_ENTITY = Block_Entities.register("extractor_block_entity", ()  -> BlockEntityType.Builder.of(ExtractorBlockEntity::new, Modblocks.EXTRACTOR.get()).build(null));




    public static void register(IEventBus eventBus){
        Block_Entities.register(eventBus);
    }
}
