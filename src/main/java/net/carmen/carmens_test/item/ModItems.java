package net.carmen.carmens_test.item;

import net.carmen.carmens_test.CarmensTest;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    public static final String ID_TEST_ITEM = "test_item";

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CarmensTest.MOD_ID);

    public static final DeferredItem<Item> TEST_ITEM =
            ITEMS.registerItem(ID_TEST_ITEM, Item::new, new Item.Properties()
            );

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
