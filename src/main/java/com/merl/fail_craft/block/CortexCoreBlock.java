package com.merl.fail_craft.block;

import com.merl.fail_craft.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.Random;

public class CortexCoreBlock extends Block {


    public CortexCoreBlock(Properties properties) {
        super(properties);
    }


    @Nullable
    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, Random pRand) {
            if (pRand.nextInt(10) == 0) {
                pLevel.playLocalSound((double)pPos.getX() + 0.5D, (double)pPos.getY() + 0.5D, (double)pPos.getZ() + 0.5D, SoundEvents.CAMPFIRE_CRACKLE, SoundSource.BLOCKS, 0.9F + pRand.nextFloat(), pRand.nextFloat() * 0.7F + 0.6F, false);
            }
    }


    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {

        if(pPlayer.getItemInHand(pHand).sameItem(new ItemStack(ModItems.Block_Crusher.get()))) {

            pLevel.destroyBlock(pPos, true, pPlayer);
            //pLevel.explode(pPlayer, pHit.getLocation().x, pHit.getLocation().y, pHit.getLocation().z, 20, Explosion.BlockInteraction.BREAK);

        }
        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);

    }



}
