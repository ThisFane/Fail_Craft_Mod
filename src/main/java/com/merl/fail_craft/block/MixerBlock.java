package com.merl.fail_craft.block;

import com.merl.fail_craft.block.Modblocks;
import com.merl.fail_craft.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.*;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.FireworkRocketEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.Random;


public class MixerBlock extends Block{
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;


    public MixerBlock(Properties properties) {
        super(properties);
    }

    private static final VoxelShape SHAPE =  Block.box(3, 0, 3, 13, 17, 13);

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    @Nullable
    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, Random pRandom) {

    }


    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {

        if(pPlayer.getItemInHand(pHand).sameItem(new ItemStack(ModItems.Block_Crusher.get()))) {

            pLevel.destroyBlock(pPos, true, pPlayer);
            //pLevel.explode(pPlayer, pHit.getLocation().x, pHit.getLocation().y, pHit.getLocation().z, 20, Explosion.BlockInteraction.BREAK);

        }
        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);

    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
    }


}
