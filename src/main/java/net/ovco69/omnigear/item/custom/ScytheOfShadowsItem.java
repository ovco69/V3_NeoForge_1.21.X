package net.ovco69.omnigear.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.ovco69.omnigear.OmniGear;

import java.util.List;

public class ScytheOfShadowsItem extends Item {
    public ScytheOfShadowsItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip." + OmniGear.MOD_ID + ".scythe_of_shadows.tooltip1")
                .withStyle(ChatFormatting.DARK_PURPLE, ChatFormatting.ITALIC));
        tooltipComponents.add(Component.translatable("tooltip." + OmniGear.MOD_ID + ".scythe_of_shadows.tooltip2")
                .withStyle(ChatFormatting.DARK_PURPLE, ChatFormatting.ITALIC));
        tooltipComponents.add(Component.translatable("tooltip" + OmniGear.MOD_ID + "scythe_of_shadows.tooltip3")
                .withStyle(ChatFormatting.DARK_PURPLE, ChatFormatting.ITALIC));
        tooltipComponents.add(Component.translatable("tooltip." + OmniGear.MOD_ID + ".scythe_of_shadows.tooltip4")
                .withStyle(ChatFormatting.DARK_PURPLE, ChatFormatting.ITALIC));

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
