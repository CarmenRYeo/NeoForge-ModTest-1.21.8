package net.carmen.carmens_test.item.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Map;

public class TestCustomItem extends Item {
    private static final Map<Block, Block> TRANSFORM_MAP =
            Map.of(
                    Blocks.DIRT, Blocks.GRASS_BLOCK,
                    Blocks.GRASS_BLOCK, Blocks.MYCELIUM,
                    Blocks.MYCELIUM, Blocks.DIRT
            );

    public TestCustomItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();

        if (TRANSFORM_MAP.containsKey(clickedBlock)) {
            if (!level.isClientSide()) {
                level.setBlockAndUpdate(context.getClickedPos(), TRANSFORM_MAP.get(clickedBlock).defaultBlockState());

                context.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), context.getPlayer(),
                        item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND)
                );

                level.playSound(null, context.getClickedPos(), SoundEvents.ALLAY_AMBIENT_WITH_ITEM, SoundSource.BLOCKS);
            }
        }

        return InteractionResult.SUCCESS;
    }
}
