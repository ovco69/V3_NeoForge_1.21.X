package net.ovco69.tutorialmod.event;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ComputeFovModifierEvent;
import net.neoforged.neoforge.client.event.ViewportEvent;
import net.ovco69.tutorialmod.TutorialMod;
import net.ovco69.tutorialmod.item.ModItems;

@EventBusSubscriber(modid = TutorialMod.MOD_ID, bus = EventBusSubscriber.Bus.GAME, value = Dist.CLIENT)
public class ModClientEvents {

    @SubscribeEvent
    public static void onComputeFovModifierEvent(ComputeFovModifierEvent event) {
        if (event.getPlayer().isUsingItem() && event.getPlayer().getUseItem().getItem() == ModItems.BISMUTH_BOW.get()) {
            float fovModifier = 1;
            int ticksUsingItem = event.getPlayer().getTicksUsingItem();

            float deltaTicks = (float)ticksUsingItem / 20;

            if (deltaTicks > 1) {
                deltaTicks = 1;
            }
            else {
                deltaTicks *= deltaTicks;
            }

            fovModifier *= 1 - deltaTicks * .15f;
            event.setNewFovModifier(fovModifier);
        }
    }
}
