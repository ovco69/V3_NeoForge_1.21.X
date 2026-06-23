package net.ovco69.omnigear;

import net.minecraft.client.renderer.entity.EntityRenderers;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.ovco69.omnigear.block.ModBlocks;
import net.ovco69.omnigear.block.entity.ModBlockEntities;
import net.ovco69.omnigear.component.ModDataComponents;
import net.ovco69.omnigear.effect.ModEffects;
import net.ovco69.omnigear.enchantment.ModEnchantmentEffects;
import net.ovco69.omnigear.entity.ModEntities;
import net.ovco69.omnigear.entity.client.ChairRenderer;
import net.ovco69.omnigear.entity.client.GeckoRenderer;
import net.ovco69.omnigear.entity.client.TomahawkProjectileRenderer;
import net.ovco69.omnigear.item.ModCreativeModeTabs;
import net.ovco69.omnigear.item.ModItems;
import net.ovco69.omnigear.loot.ModLootModifiers;
import net.ovco69.omnigear.particle.BismuthParticles;
import net.ovco69.omnigear.particle.ModParticles;
import net.ovco69.omnigear.potion.ModPotions;
import net.ovco69.omnigear.sound.ModSounds;
import net.ovco69.omnigear.util.ModItemProperties;
import net.ovco69.omnigear.util.ModPortals;
import net.ovco69.omnigear.villager.ModVillagers;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(OmniGear.MOD_ID)
public class OmniGear {
    public static final String MOD_ID = "omnigear";
    public static final Logger LOGGER = LogUtils.getLogger();

    public OmniGear(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
        NeoForge.EVENT_BUS.register(this);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModCreativeModeTabs.register(modEventBus);

        ModDataComponents.register(modEventBus);

        ModSounds.register(modEventBus);
        ModEffects.register(modEventBus);

        ModPotions.register(modEventBus);
        ModEnchantmentEffects.register(modEventBus);

        ModEntities.register(modEventBus);
        ModVillagers.register(modEventBus);

        ModParticles.register(modEventBus);
        ModLootModifiers.register(modEventBus);

        modEventBus.addListener(this::addCreative);
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            ModItemProperties.addCustomItemProperties();

            EntityRenderers.register(ModEntities.GECKO.get(), GeckoRenderer::new);
            EntityRenderers.register(ModEntities.TOMAHAWK.get(), TomahawkProjectileRenderer::new);
            EntityRenderers.register(ModEntities.CHAIR_ENTITY.get(), ChairRenderer::new);

            event.enqueueWork(ModPortals::registerPortals);
        }

        @SubscribeEvent
        public static void registerParticleFactories(RegisterParticleProvidersEvent event) {
            event.registerSpriteSet(ModParticles.BISMUTH_PARTICLES.get(), BismuthParticles.Provider::new);
        }
    }
}
