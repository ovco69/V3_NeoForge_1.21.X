package net.ovco69.tutorialmod.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.player.ItemEntityPickupEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import net.neoforged.neoforge.event.village.WandererTradesEvent;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.wrapper.PlayerMainInvWrapper;
import net.ovco69.tutorialmod.TutorialMod;
import net.ovco69.tutorialmod.item.ModItems;
import net.ovco69.tutorialmod.item.custom.HammerItem;
import net.ovco69.tutorialmod.potion.ModPotions;
import net.ovco69.tutorialmod.villager.ModVillagers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@EventBusSubscriber(modid = TutorialMod.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class ModEvents {
    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();

    @SubscribeEvent
    public static void onHammerUsage(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        ItemStack mainHandItem = player.getMainHandItem();

        if (mainHandItem.getItem() instanceof HammerItem hammer && player instanceof ServerPlayer serverPlayer) {
            BlockPos initialBlockPos = event.getPos();
            if (HARVESTED_BLOCKS.contains(initialBlockPos)) {
                return;
            }

            for (BlockPos pos : HammerItem.getBlocksToBeDestroyed(2, initialBlockPos, serverPlayer)) {
                if (pos == initialBlockPos || !hammer.isCorrectToolForDrops(mainHandItem, event.getLevel().getBlockState(pos))) {
                    continue;
                }

                HARVESTED_BLOCKS.add(pos);
                serverPlayer.gameMode.destroyBlock(pos);
                HARVESTED_BLOCKS.remove(pos);
            }
        }
    }

    @SubscribeEvent
    public static void onLivingDamageEvent(LivingDamageEvent.Pre event) {
        if (event.getEntity() instanceof Sheep sheep && event.getSource().getDirectEntity() instanceof Player player) {
            if (player.getMainHandItem().getItem() == Items.END_ROD) {
                player.sendSystemMessage(Component.literal(player.getName().getString() + " just hit a sheep with an END ROD? YOU SICK FRICK!"));
                sheep.addEffect(new MobEffectInstance(MobEffects.POISON, 600, 6));
                player.getMainHandItem().shrink(1);
            }
        }

        if (event.getSource().getDirectEntity() instanceof Player player) {
            player.displayClientMessage(Component.literal("Damage amount: ").append(Component.literal("" + event.getOriginalDamage()).withStyle(ChatFormatting.GREEN)), true);
        }
    }

    @SubscribeEvent
    public static void onBrewingRecipeRegister(RegisterBrewingRecipesEvent event) {
        PotionBrewing.Builder builder = event.getBuilder();

        builder.addMix(Potions.MUNDANE, Items.SLIME_BALL, ModPotions.SLIMEY_POTION);
        builder.addMix(ModPotions.SLIMEY_POTION, Items.REDSTONE, ModPotions.SLIMEY_POTION_EXTENDED);
    }

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if (event.getType() == VillagerProfession.FARMER) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(1).add((trader, random) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 3),
                    new ItemStack(ModItems.GOJI_BERRIES.get(), 18),
                    6,
                    3,
                    0.05f
                    ));
            trades.get(1).add((trader, random) -> new MerchantOffer(
                    new ItemCost(Items.DIAMOND, 7),
                    new ItemStack(ModItems.RADISH.get(), 3),
                    6,
                    3,
                    0.05f
                    ));

            trades.get(2).add((trader, random) -> new MerchantOffer(
                    new ItemCost(Items.ENDER_PEARL, 1),
                    new ItemStack(ModItems.RADISH_SEEDS.get(), 1),
                    2,
                    3,
                    0.05f
                    ));
        }
        if (event.getType() == ModVillagers.KAUPENGER.value()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(1).add((trader, random) -> new MerchantOffer(
                    new ItemCost(Items.NETHERITE_INGOT, 3),
                    new ItemStack(ModItems.RADIATION_STAFF.get(), 1),
                    1,
                    4,
                    0.05f
            ));
            trades.get(1).add((trader, random) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 3),
                    new ItemStack(ModItems.RAW_BISMUTH.get(), 8),
                    7,
                    3,
                    0.05f
            ));

            trades.get(2).add((trader, random) -> new MerchantOffer(
                    new ItemCost(ModItems.BISMUTH.get(), 57),
                    new ItemStack(Items.MACE, 1),
                    3,
                    6,
                    0.05f
            ));
        }
    }

    @SubscribeEvent
    public static void addWanderingTrades(WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();

        genericTrades.add((trader, random) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 8),
                new ItemStack(ModItems.STARLIGHT_ASHES.get(), 3),
                2,
                3,
                0.05f
        ));
    }
}
