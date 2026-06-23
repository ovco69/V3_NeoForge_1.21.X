package net.ovco69.omnigear.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties RADISH = new FoodProperties.Builder()
            .nutrition(3)
            .saturationModifier(.25f)
            .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 800), .35f)
            .build();
    public static final FoodProperties GOJI_BERRY = new FoodProperties.Builder()
            .nutrition(1)
            .saturationModifier(0)
            .effect(() -> new MobEffectInstance(MobEffects.SATURATION, 500), .1f)
            .fast()
            .build();

}
