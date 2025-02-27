package slimeknights.tconstruct.tools.modifiers.ability;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.modifiers.SingleUseModifier;
import slimeknights.tconstruct.library.tools.helper.BlockSideHitListener;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;

public class ExchangingModifier extends SingleUseModifier {
  public ExchangingModifier() {
    super(0x258474);
  }

  @Override
  public int getPriority() {
    // super low because we need to run after the shears ability modifier, and any other similar hooks
    return Short.MIN_VALUE - 20;
  }

  @Override
  public Boolean removeBlock(IModifierToolStack tool, int level, PlayerEntity player, World world, BlockPos pos, BlockState state, boolean canHarvest, boolean isEffective) {
    // must have blocks in the offhand
    ItemStack offhand = player.getHeldItemOffhand();
    if (!isEffective || offhand.isEmpty() || !(offhand.getItem() instanceof BlockItem)) {
      return null;
    }
    // block is unchanged no need to replace, just cancel breaking entirely
    BlockItem blockItem = (BlockItem) offhand.getItem();
    if (state.getBlock() == blockItem.getBlock()) {
      return false;
    }

    // from this point on, we are in charge of breaking the block, start by harvesting it so piglins get mad and stuff
    state.getBlock().onBlockHarvested(world, pos, state, player);

    // generate placing context
    Direction sideHit = BlockSideHitListener.getSideHit(player);
    // subtract the offsets instead of adding as the position is empty, want to "hit" a realistic location
    Vector3d hit = new Vector3d((double)pos.getX() + 0.5D - sideHit.getXOffset() * 0.5D, pos.getY() + 0.5D - sideHit.getYOffset() * 0.5D, pos.getZ() + 0.5D - sideHit.getZOffset() * 0.5D);
    BlockItemUseContext context = new BlockItemUseContext(world, player, Hand.OFF_HAND, offhand, new BlockRayTraceResult(hit, sideHit, pos, false));
    context.replaceClicked = true; // force replacement, even if the position is not replacable (as it most always will be)

    // swap the block, it never goes to air so things like torches will remain
    ActionResultType success = blockItem.tryPlace(context);
    if (success.isSuccessOrConsume()) {
      player.swing(Hand.OFF_HAND, false);
      return true;
    } else {
      // so we failed to place the new block for some reason, remove the old block to prevent dupes
      return world.setBlockState(pos, world.getFluidState(pos).getBlockState(), 3);
    }
  }
}
