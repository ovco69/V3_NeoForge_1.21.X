package net.ovco69.tutorialmod.util.portal;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.ovco69.tutorialmod.block.ModBlocks;

import java.util.Optional;

public class PortalFrameValidator {
    private static final int WIDTH = 5;
    private static final int HEIGHT = 4;

    public static Optional<PortalFrame> findFixedFrame(Level level, BlockPos pos) {
        for (Direction dir : Direction.Plane.HORIZONTAL) {
            if (checkFrame(level, pos, dir)) {
                return Optional.of(new PortalFrame(pos, dir));
            }
        }

        return Optional.empty();
    }

    private static boolean checkFrame(Level level, BlockPos origin, Direction dir) {
        Direction right = dir.getClockWise();

        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                BlockPos checkPos = origin.relative(right, x).above(y);
                boolean border = x == 0 || x == WIDTH - 1 || y == 0 || y == HEIGHT - 1;

                Block expected = level.getBlockState(checkPos).getBlock();

                if (border) {
                    if (expected != ModBlocks.BISMUTH_BLOCK.get()) {
                        return false;
                    }
                }
                else {
                    if (!level.isEmptyBlock(checkPos)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
