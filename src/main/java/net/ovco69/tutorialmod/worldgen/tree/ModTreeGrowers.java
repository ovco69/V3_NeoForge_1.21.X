package net.ovco69.tutorialmod.worldgen.tree;

import net.minecraft.world.level.block.grower.TreeGrower;
import net.ovco69.tutorialmod.TutorialMod;
import net.ovco69.tutorialmod.worldgen.ModConfiguredFeatures;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower BLOODWOOD = new TreeGrower(TutorialMod.MOD_ID + ":bloodwood",
            Optional.empty(), Optional.of(ModConfiguredFeatures.BLOODWOOD_KEY), Optional.empty());
}
