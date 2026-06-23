package net.ovco69.omnigear.potion;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.ovco69.omnigear.OmniGear;
import net.ovco69.omnigear.effect.ModEffects;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(BuiltInRegistries.POTION, OmniGear.MOD_ID);

    public static final Holder<Potion> SLIMEY_POTION = POTIONS.register("slimey_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.SLIMEY_EFFECT, 1200, 0)));
    public static final Holder<Potion> SLIMEY_POTION_EXTENDED = POTIONS.register("slimey_potion_extended",
            () -> new Potion(new MobEffectInstance(ModEffects.SLIMEY_EFFECT, 3600, 0)));

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}
