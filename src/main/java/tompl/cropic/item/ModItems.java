package tompl.cropic.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import tompl.cropic.Cropic;

public class ModItems
{
    public static final Item TOMATO = registerItem("tomato", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item)
    {
        return Registry.register(Registries.ITEM, Identifier.of(Cropic.MOD_ID, name), item);
    }

    public static void registerModItems()
    {
        Cropic.LOGGER.info("Registering mod items for {}", Cropic.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(TOMATO);
        });
    }

}