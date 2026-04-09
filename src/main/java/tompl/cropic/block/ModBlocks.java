package tompl.cropic.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import tompl.cropic.Cropic;

public class ModBlocks
{
    public static final Block SOIL_BLOCK = registerBlock("soil_block",
            new Block(AbstractBlock.Settings.create().
                    strength(1f).
                    sounds(BlockSoundGroup.MUD)
            ));
    public static final Block BUSH_BLOCK = registerBlock("bush_block",
            new Block(AbstractBlock.Settings.create().
                    dropsNothing().
                    sounds(BlockSoundGroup.AZALEA_LEAVES).
                    breakInstantly()
            ));

    private static Block registerBlock(String name, Block block)
    {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Cropic.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block)
    {
        Registry.register(Registries.ITEM, Identifier.of(Cropic.MOD_ID, name), new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks()
    {
        Cropic.LOGGER.info("Registering mod items for {}", Cropic.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(ModBlocks.SOIL_BLOCK);
        });
    }

}
