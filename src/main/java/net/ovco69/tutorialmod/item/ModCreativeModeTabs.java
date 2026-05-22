package net.ovco69.tutorialmod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.ovco69.tutorialmod.TutorialMod;
import net.ovco69.tutorialmod.block.ModBlocks;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);

    public static Supplier<CreativeModeTab> TUTORIAL_ITEMS = TABS.register("tutorial_items_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.BISMUTH.get()))
                    .title(Component.translatable("creativetab.tutorialmod.tutorial_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.CHISEL);

                        output.accept(ModItems.BISMUTH);
                        output.accept(ModItems.RAW_BISMUTH);

                        output.accept(ModItems.RADISH);
                        output.accept(ModItems.FROSTFIRE_ICE);
                        output.accept(ModItems.STARLIGHT_ASHES);
                    })
                    .build());

    public static Supplier<CreativeModeTab> TUTORIAL_BLOCKS = TABS.register("tutorial_blocks_tab",
            () -> CreativeModeTab.builder()
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "tutorial_items_tab"))
                    .icon(() -> new ItemStack(ModBlocks.BISMUTH_BLOCK.get()))
                    .title(Component.translatable("creativetab.tutorialmod.tutorial_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.BISMUTH_BLOCK);
                        output.accept(ModBlocks.BISMUTH_ORE);
                        output.accept(ModBlocks.DEEPSLATE_BISMUTH_ORE);
                        output.accept(ModBlocks.MAGIC_BLOCK);

                        output.accept(ModBlocks.BISMUTH_STAIRS);
                        output.accept(ModBlocks.BISMUTH_SLAB);

                        output.accept(ModBlocks.BISMUTH_PRESSURE_PLATE);
                        output.accept(ModBlocks.BISMUTH_BUTTON);

                        output.accept(ModBlocks.BISMUTH_FENCE);
                        output.accept(ModBlocks.BISMUTH_FENCE_GATE);
                        output.accept(ModBlocks.BISMUTH_WALL);

                        output.accept(ModBlocks.BISMUTH_DOOR);
                        output.accept(ModBlocks.BISMUTH_TRAPDOOR);

                        output.accept(ModBlocks.BISMUTH_LAMP);
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        TABS.register(eventBus);
    }
}
