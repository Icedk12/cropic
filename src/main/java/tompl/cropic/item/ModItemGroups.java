package tompl.cropic.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import tompl.cropic.Cropic;
import tompl.cropic.block.ModBlocks;

public class ModItemGroups
{
    public static final ItemGroup CROPIC_CROPS_ITEMS_GROUP = Registry.register(
            Registries.ITEM_GROUP,
            Identifier.of(Cropic.MOD_ID, "cropic_crops_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.TOMATO))
                    .displayName(Text.translatable("itemgroup.cropic.cropic_crops_items"))
                    .entries((displayContext, entries) ->
                    {
                        entries.add(ModItems.TOMATO_SEEDS);
                        entries.add(ModItems.TOMATO);
                    })
                    .build());

    public static final ItemGroup CROPIC_BLOCKS_ITEMS_GROUP = Registry.register(
            Registries.ITEM_GROUP,
            Identifier.of(Cropic.MOD_ID, "cropic_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.SOIL_BLOCK))
                    .displayName(Text.translatable("itemgroup.cropic.cropic_blocks"))
                    .entries((displayContext, entries) ->
                    {
                        entries.add(ModBlocks.SOIL_BLOCK);

                    })
                    .build());


    public static void registerItemGroups()
    {
        Cropic.LOGGER.info("Registering Item groups for {}",Cropic.MOD_ID);
    }

}
