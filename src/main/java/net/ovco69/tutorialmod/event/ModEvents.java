package net.ovco69.tutorialmod.event;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.player.ItemEntityPickupEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.wrapper.PlayerMainInvWrapper;
import net.ovco69.tutorialmod.TutorialMod;
import net.ovco69.tutorialmod.item.ModItems;
import net.ovco69.tutorialmod.item.custom.HammerItem;
import net.ovco69.tutorialmod.potion.ModPotions;

import java.util.HashSet;
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
    public static void onItemPickupEvent(ItemEntityPickupEvent.Pre event) {
        ItemStack pickedItem = event.getItemEntity().getItem();
        ItemStack playerItem = findItemInInventory(event.getPlayer(), pickedItem);

        if (playerItem == null || !playerItem.isDamageableItem())
            return;
        if (!pickedItem.isDamageableItem() || pickedItem.isDamaged())
            return;

        int max = playerItem.getMaxDamage();

        int remainingPlayer = max - playerItem.getDamageValue();
        int remainingPicked = max - pickedItem.getDamageValue();
        int combined = Math.min(max, remainingPlayer + remainingPicked);

        int newDamage = max - combined;

        playerItem.setDamageValue(newDamage);
        pickedItem.setCount(0);
    }

    private static ItemStack findItemInInventory(Player player, ItemStack targetItem) {
        IItemHandler inventory = new PlayerMainInvWrapper(player.getInventory());

        for (int i = 0; i < inventory.getSlots(); i++) {
            ItemStack stack = inventory.getStackInSlot(i);

            if (!stack.isEmpty() && stack.getItem() == targetItem.getItem())
                return stack;
        }

        return null;
    }
}
