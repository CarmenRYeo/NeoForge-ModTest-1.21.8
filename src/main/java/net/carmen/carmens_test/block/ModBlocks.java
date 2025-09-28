package net.carmen.carmens_test.block;

import net.carmen.carmens_test.CarmensTest;
import net.carmen.carmens_test.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {

    public static final String ID_TEST_BLOCK = "test_block";

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(CarmensTest.MOD_ID);

    public static final DeferredBlock<Block> TEST_BLOCK = registerBlock(ID_TEST_BLOCK,
            () -> new Block(
                    BlockBehaviour.Properties.of()
                            .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse(CarmensTest.MOD_ID + ":" + ID_TEST_BLOCK)))
                            .strength(4f)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.AMETHYST)
            )
    );

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().setId(
                ResourceKey.create(Registries.ITEM, ResourceLocation.parse(CarmensTest.MOD_ID + ":" + ID_TEST_BLOCK))
        )));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
