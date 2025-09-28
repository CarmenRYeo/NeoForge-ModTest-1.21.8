package net.carmen.carmens_test.item;

import net.carmen.carmens_test.CarmensTest;
import net.carmen.carmens_test.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CarmensTest.MOD_ID);

    public static final Supplier<CreativeModeTab> TEST_ITEMS_TAB = CREATIVE_MODE_TAB.register("test_items_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.TEST_ITEM.get()))
                    .title(Component.translatable("creativetab." + CarmensTest.MOD_ID + ".test_items"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.TEST_ITEM);
                        output.accept(ModBlocks.TEST_BLOCK);
                    })
                    .build()
    );

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
