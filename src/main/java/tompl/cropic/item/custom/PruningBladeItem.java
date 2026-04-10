package tompl.cropic.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import tompl.cropic.item.ModItems;

import java.util.Map;

public class PruningBladeItem extends Item
{
    public static final Map<Block, Item> PRUNING_BLADE_MAP =
            Map.of(
                    Blocks.SHORT_GRASS, ModItems.TOMATO_SEEDS,
                    Blocks.TALL_GRASS, ModItems.TOMATO_SEEDS,
                    Blocks.OAK_LEAVES, ModItems.TOMATO_SEEDS,
                    Blocks.BIRCH_LEAVES, ModItems.TOMATO_SEEDS
            );

    public PruningBladeItem(Settings settings)
    {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context)
    {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if(PRUNING_BLADE_MAP.containsKey(clickedBlock))
        {
            if(!world.isClient())
            {
                world.setBlockState(context.getBlockPos(), Blocks.AIR.getDefaultState());
                context.getStack().damage(1, ((ServerWorld)world), ((ServerPlayerEntity)context.getPlayer()),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_GROWING_PLANT_CROP, SoundCategory.BLOCKS);
            }
        }

        return ActionResult.SUCCESS;
    }
}
