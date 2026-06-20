package net.ovco69.tutorialmod.util;

import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.resources.ResourceLocation;
import net.ovco69.tutorialmod.TutorialMod;
import net.ovco69.tutorialmod.block.ModBlocks;
import net.ovco69.tutorialmod.item.ModItems;

public class ModPortals {
    public static void registerPortals() {
        CustomPortalBuilder.beginPortal()
                .frameBlock(ModBlocks.BISMUTH_BLOCK.get())
                .lightWithItem(ModItems.STARLIGHT_ASHES.get())
                .destDimID(ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "ovcodim"))
                .tintColor(0xc76efa)
                .registerPortal();
    }
}
