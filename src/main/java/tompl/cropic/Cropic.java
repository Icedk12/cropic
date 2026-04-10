package tompl.cropic;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tompl.cropic.block.ModBlocks;
import tompl.cropic.item.ModItemGroups;
import tompl.cropic.item.ModItems;

public class Cropic implements ModInitializer {
	public static final String MOD_ID = "cropic";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}