package net.ovco69.tutorialmod.entity.client;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.ovco69.tutorialmod.TutorialMod;
import net.ovco69.tutorialmod.entity.GeckoVariant;
import net.ovco69.tutorialmod.entity.custom.GeckoEntity;

import java.util.Map;

public class GeckoRenderer extends MobRenderer<GeckoEntity, GeckoModel<GeckoEntity>> {
    private static final Map<GeckoVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(GeckoVariant.class), map -> {
                map.put(GeckoVariant.BLUE, ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "textures/entity/gecko/gecko_blue.png"));
                map.put(GeckoVariant.GREEN, ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "textures/entity/gecko/gecko_green.png"));
                map.put(GeckoVariant.PINK, ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "textures/entity/gecko/gecko_pink.png"));
                map.put(GeckoVariant.BROWN, ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "textures/entity/gecko/gecko_brown.png"));
            });

    public GeckoRenderer(EntityRendererProvider.Context context) {
        super(context, new GeckoModel<>(context.bakeLayer(GeckoModel.LAYER_LOCATION)), .25f);
    }

    @Override
    public ResourceLocation getTextureLocation(GeckoEntity entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
    }

    @Override
    public void render(GeckoEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        if (entity.isBaby()) {
            poseStack.scale(.45f, .45f, .45f);
        }
        else {
            poseStack.scale(1f, 1f, 1f);
        }

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}
