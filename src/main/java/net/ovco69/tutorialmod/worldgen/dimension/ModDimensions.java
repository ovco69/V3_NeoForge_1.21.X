package net.ovco69.tutorialmod.worldgen.dimension;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.ovco69.tutorialmod.TutorialMod;

import java.util.OptionalLong;

public class ModDimensions {
    public static final ResourceKey<Level> OVCODIM_LEVEL_KEY = ResourceKey.create(Registries.DIMENSION,
            ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "ovcodim"));
    public static final ResourceKey<DimensionType> OVCODIM_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE,
            ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "ovcodim_type"));

    public static void bootstrapType(BootstrapContext<DimensionType> context) {
        context.register(OVCODIM_TYPE, new DimensionType(
                OptionalLong.of(12000),
                false,
                false,
                false,
                true,
                1d,
                true,
                false,
                0,
                256,
                256,
                BlockTags.INFINIBURN_OVERWORLD,
                BuiltinDimensionTypes.OVERWORLD_EFFECTS,
                1f,
                new DimensionType.MonsterSettings(
                        false,
                        false,
                        UniformInt.of(0, 0),
                        0
                )
        ));
    }
}
