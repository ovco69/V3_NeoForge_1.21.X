package net.ovco69.omnigear.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.ovco69.omnigear.OmniGear;
import net.ovco69.omnigear.block.ModBlocks;
import net.ovco69.omnigear.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, OmniGear.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.BISMUTH_BLOCK.get())
                .add(ModBlocks.BISMUTH_ORE.get())
                .add(ModBlocks.DEEPSLATE_BISMUTH_ORE.get())
                .add(ModBlocks.NETHER_BISMUTH_ORE.get())
                .add(ModBlocks.END_BISMUTH_ORE.get())
                .add(ModBlocks.MAGIC_BLOCK.get())
                .add(ModBlocks.BISMUTH_STAIRS.get())
                .add(ModBlocks.BISMUTH_SLAB.get())
                .add(ModBlocks.BISMUTH_PRESSURE_PLATE.get())
                .add(ModBlocks.BISMUTH_BUTTON.get())
                .add(ModBlocks.BISMUTH_FENCE.get())
                .add(ModBlocks.BISMUTH_FENCE_GATE.get())
                .add(ModBlocks.BISMUTH_WALL.get())
                .add(ModBlocks.BISMUTH_DOOR.get())
                .add(ModBlocks.BISMUTH_TRAPDOOR.get())
                .add(ModBlocks.BISMUTH_LAMP.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.BISMUTH_BLOCK.get())
                .add(ModBlocks.BISMUTH_ORE.get())
                .add(ModBlocks.DEEPSLATE_BISMUTH_ORE.get())
                .add(ModBlocks.NETHER_BISMUTH_ORE.get())
                .add(ModBlocks.END_BISMUTH_ORE.get())
                .add(ModBlocks.MAGIC_BLOCK.get())
                .add(ModBlocks.BISMUTH_STAIRS.get())
                .add(ModBlocks.BISMUTH_SLAB.get())
                .add(ModBlocks.BISMUTH_PRESSURE_PLATE.get())
                .add(ModBlocks.BISMUTH_BUTTON.get())
                .add(ModBlocks.BISMUTH_FENCE.get())
                .add(ModBlocks.BISMUTH_FENCE_GATE.get())
                .add(ModBlocks.BISMUTH_WALL.get())
                .add(ModBlocks.BISMUTH_DOOR.get())
                .add(ModBlocks.BISMUTH_TRAPDOOR.get())
                .add(ModBlocks.BISMUTH_LAMP.get());


        tag(BlockTags.FENCES)
                .add(ModBlocks.BISMUTH_FENCE.get());

        tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.BISMUTH_FENCE_GATE.get());

        tag(BlockTags.WALLS)
                .add(ModBlocks.BISMUTH_WALL.get());


        tag(ModTags.Blocks.NEEDS_BISMUTH_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);

        tag(ModTags.Blocks.INCORRECT_FOR_BISMUTH_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
                .remove(ModTags.Blocks.NEEDS_BISMUTH_TOOL);

        tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.BLOODWOOD_LOG.get())
                .add(ModBlocks.BLOODWOOD_WOOD.get())
                .add(ModBlocks.STRIPPED_BLOODWOOD_LOG.get())
                .add(ModBlocks.STRIPPED_BLOODWOOD_WOOD.get());
    }
}
