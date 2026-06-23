package net.ovco69.omnigear.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;

public class SlimeyEffect extends MobEffect {
    public SlimeyEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    private int wallTicks = 0;
    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        if (livingEntity.horizontalCollision) {
            Vec3 initialVec = livingEntity.getDeltaMovement();
            Vec3 climbVec;

            if (livingEntity.isShiftKeyDown()) {
                climbVec = new Vec3(initialVec.x, 0, initialVec.z);
            }
            else {
                climbVec = new Vec3(initialVec.x, 0.2, initialVec.z);
            }

            livingEntity.setDeltaMovement(climbVec.scale(.96));
            return true;
        }

        return super.applyEffectTick(livingEntity, amplifier);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
