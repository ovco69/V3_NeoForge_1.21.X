package net.ovco69.omnigear.util;

import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.resources.ResourceLocation;
import net.ovco69.omnigear.OmniGear;
import net.ovco69.omnigear.block.ModBlocks;
import net.ovco69.omnigear.item.ModItems;

public class ModPortals {
    public static void registerPortals() {
        CustomPortalBuilder.beginPortal()
                .frameBlock(ModBlocks.BISMUTH_BLOCK.get())
                .lightWithItem(ModItems.STARLIGHT_ASHES.get())
                .destDimID(ResourceLocation.fromNamespaceAndPath(OmniGear.MOD_ID, "ovcodim"))
                .tintColor(0xc76efa)
                .registerPortal();
    }
}
