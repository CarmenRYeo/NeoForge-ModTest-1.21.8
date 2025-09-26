package net.carmen.carmenstest.item;

import net.carmen.carmenstest.CarmensTest;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CarmensTest.MOD_ID);

    public static final DeferredItem<Item> TESTITEM =
            ITEMS.registerItem("testitem", Item::new, new Item.Properties()
            );

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
