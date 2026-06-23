package net.ovco69.omnigear.worldgen.tree;

import net.minecraft.world.level.block.grower.TreeGrower;
import net.ovco69.omnigear.OmniGear;
import net.ovco69.omnigear.worldgen.ModConfiguredFeatures;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower BLOODWOOD = new TreeGrower(OmniGear.MOD_ID + ":bloodwood",
            Optional.empty(), Optional.of(ModConfiguredFeatures.BLOODWOOD_KEY), Optional.empty());
}
