package net.ovco69.omnigear.item;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;
import net.ovco69.omnigear.util.ModTags;

public class ModToolTiers {
    public static final Tier BISMUTH = new SimpleTier(
            ModTags.Blocks.INCORRECT_FOR_BISMUTH_TOOL,
            3428,
            11,
            6,
            28,
            () -> Ingredient.of(ModItems.BISMUTH)
    );
}
