package net.ovco69.omnigear.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.ovco69.omnigear.OmniGear;
import net.ovco69.omnigear.enchantment.ModEnchantments;
import net.ovco69.omnigear.trim.ModTrimMaterials;
import net.ovco69.omnigear.trim.ModTrimPatterns;
import net.ovco69.omnigear.worldgen.ModBiomeModifiers;
import net.ovco69.omnigear.worldgen.ModConfiguredFeatures;
import net.ovco69.omnigear.worldgen.ModPlacedFeatures;
import net.ovco69.omnigear.worldgen.dimension.ModDimensions;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModDatapackProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.TRIM_MATERIAL, ModTrimMaterials::bootstrap)
            .add(Registries.TRIM_PATTERN, ModTrimPatterns::bootstrap)
            .add(Registries.ENCHANTMENT, ModEnchantments::boostrap)

            .add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModifiers::bootstrap)

            .add(Registries.DIMENSION_TYPE, ModDimensions::bootstrapType);

    public ModDatapackProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(OmniGear.MOD_ID));
    }
}
