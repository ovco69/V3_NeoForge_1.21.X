package net.ovco69.omnigear.item.custom;

import net.minecraft.world.item.Item;

public class PortalWandItem extends Item {
    public PortalWandItem(Properties properties) {
        super(properties);
    }

//    @Override
//    public InteractionResult useOn(UseOnContext context) {
//        Level level = context.getLevel();
//        if (level.isClientSide())
//            return InteractionResult.SUCCESS;
//
//        BlockPos origin = context.getClickedPos();
//        Player player = context.getPlayer();
//
//        var frame = PortalFrameValidator.findFixedFrame(level, origin);
//
//        if (frame.isPresent()) {
//            PortalFrame f = frame.get();
//
//            player.openMenu(new SimpleMenuProvider(
//                    (id, inv, p) -> new PortalMenu(id, inv, f.bottomLeft()),
//                    Component.literal("Select dimension")
//            ));
//        }
//        else {
//            player.displayClientMessage(Component.literal("Invalid portal frame"), true);
//        }
//
//        return InteractionResult.SUCCESS;
//    }
}
