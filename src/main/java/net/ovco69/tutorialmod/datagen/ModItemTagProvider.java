package net.ovco69.tutorialmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.ovco69.tutorialmod.TutorialMod;
import net.ovco69.tutorialmod.item.ModItems;
import net.ovco69.tutorialmod.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, TutorialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.BISMUTH.get())
                .add(ModItems.RAW_BISMUTH.get())
                .add(Items.STICK)
                .add(Items.COAL);

        tag(ItemTags.SWORDS)
                .add(ModItems.BISMUTH_SWORD.get());
        tag(ItemTags.PICKAXES)
                .add(ModItems.BISMUTH_PICKAXE.get());
        tag(ItemTags.AXES)
                .add(ModItems.BISMUTH_AXE.get());
        tag(ItemTags.SHOVELS)
                .add(ModItems.BISMUTH_SHOVEL.get());
        tag(ItemTags.HOES)
                .add(ModItems.BISMUTH_HOE.get());

        tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.BISMUTH_HELMET.get())
                .add(ModItems.BISMUTH_CHESTPLATE.get())
                .add(ModItems.BISMUTH_LEGGINGS.get())
                .add(ModItems.BISMUTH_BOOTS.get());

        tag(ItemTags.HEAD_ARMOR)
                .add(ModItems.BISMUTH_HELMET.get());
        tag(ItemTags.CHEST_ARMOR)
                .add(ModItems.BISMUTH_CHESTPLATE.get());
        tag(ItemTags.LEG_ARMOR)
                .add(ModItems.BISMUTH_LEGGINGS.get());
        tag(ItemTags.FOOT_ARMOR)
                .add(ModItems.BISMUTH_BOOTS.get());

        tag(ItemTags.TRIM_MATERIALS)
                .add(ModItems.BISMUTH.get());
        tag(ItemTags.TRIM_TEMPLATES)
                .add(ModItems.OVCO_SMITHING_TEMPLATE.get());

        tag(Tags.Items.RANGED_WEAPON_TOOLS)
                .add(ModItems.BISMUTH_BOW.get());
    }
}
