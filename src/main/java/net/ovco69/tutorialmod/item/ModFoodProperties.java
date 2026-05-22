package net.ovco69.tutorialmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties RADISH = new FoodProperties.Builder()
            .nutrition(3)
            .saturationModifier(.25f)
            .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 800), .35f)
            .build();
}
