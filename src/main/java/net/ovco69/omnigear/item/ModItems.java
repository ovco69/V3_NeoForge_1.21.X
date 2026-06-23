package net.ovco69.omnigear.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.ovco69.omnigear.OmniGear;
import net.ovco69.omnigear.block.ModBlocks;
import net.ovco69.omnigear.entity.ModEntities;
import net.ovco69.omnigear.item.custom.*;
import net.ovco69.omnigear.sound.ModSounds;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(OmniGear.MOD_ID);

    public static final DeferredItem<Item> BISMUTH = ITEMS.register("bismuth",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_BISMUTH = ITEMS.register("raw_bismuth",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> CHISEL = ITEMS.register("chisel",
            () -> new ChiselItem(new Item.Properties()
                    .durability(32)));
    public static final DeferredItem<Item> RADISH = ITEMS.register("radish",
            () -> new Item(new Item.Properties()
                    .food(ModFoodProperties.RADISH)));

    public static final DeferredItem<Item> FROSTFIRE_ICE = ITEMS.register("frostfire_ice",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> STARLIGHT_ASHES = ITEMS.register("starlight_ashes",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<SwordItem> BISMUTH_SWORD = ITEMS.register("bismuth_sword",
            () -> new SwordItem(ModToolTiers.BISMUTH, new Item.Properties()
                    .fireResistant()
                    .attributes(SwordItem.createAttributes(ModToolTiers.BISMUTH, 5, -2.4f))));
    public static final DeferredItem<PickaxeItem> BISMUTH_PICKAXE = ITEMS.register("bismuth_pickaxe",
            () -> new PickaxeItem(ModToolTiers.BISMUTH, new Item.Properties()
                    .fireResistant()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.BISMUTH, 1, -2.8f))));
    public static final DeferredItem<AxeItem> BISMUTH_AXE = ITEMS.register("bismuth_axe",
            () -> new AxeItem(ModToolTiers.BISMUTH, new Item.Properties()
                    .fireResistant()
                    .attributes(AxeItem.createAttributes(ModToolTiers.BISMUTH, 6, -3.2f))));
    public static final DeferredItem<ShovelItem> BISMUTH_SHOVEL = ITEMS.register("bismuth_shovel",
            () -> new ShovelItem(ModToolTiers.BISMUTH, new Item.Properties()
                    .fireResistant()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.BISMUTH, 1.5f, -3f))));
    public static final DeferredItem<HoeItem> BISMUTH_HOE = ITEMS.register("bismuth_hoe",
            () -> new HoeItem(ModToolTiers.BISMUTH, new Item.Properties()
                    .fireResistant()
                    .attributes(HoeItem.createAttributes(ModToolTiers.BISMUTH, 0, -3f))));
    public static final DeferredItem<HammerItem> BISMUTH_HAMMER = ITEMS.register("bismuth_hammer",
            () -> new HammerItem(ModToolTiers.BISMUTH, new Item.Properties()
                    .fireResistant()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.BISMUTH, 7, -3.5f))));

    public static final DeferredItem<ArmorItem> BISMUTH_HELMET = ITEMS.register("bismuth_helmet",
            () -> new ModArmorItem(ModArmorMaterials.BISMUTH_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Properties()
                    .fireResistant()
                    .durability(ArmorItem.Type.HELMET.getDurability(42))));
    public static final DeferredItem<ArmorItem> BISMUTH_CHESTPLATE = ITEMS.register("bismuth_chestplate",
            () -> new ArmorItem(ModArmorMaterials.BISMUTH_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties()
                    .fireResistant()
                    .durability(ArmorItem.Type.CHESTPLATE.getDurability(42))));
    public static final DeferredItem<ArmorItem> BISMUTH_LEGGINGS = ITEMS.register("bismuth_leggings",
            () -> new ArmorItem(ModArmorMaterials.BISMUTH_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties()
                    .fireResistant()
                    .durability(ArmorItem.Type.LEGGINGS.getDurability(42))));
    public static final DeferredItem<ArmorItem> BISMUTH_BOOTS = ITEMS.register("bismuth_boots",
            () -> new ArmorItem(ModArmorMaterials.BISMUTH_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Properties()
                    .fireResistant()
                    .durability(ArmorItem.Type.BOOTS.getDurability(42))));

    public static final DeferredItem<Item> BISMUTH_HORSE_ARMOR = ITEMS.register("bismuth_horse_armor",
            () -> new AnimalArmorItem(ModArmorMaterials.BISMUTH_ARMOR_MATERIAL, AnimalArmorItem.BodyType.EQUESTRIAN,
                    false, new Item.Properties()
                    .stacksTo(1)));

    public static final DeferredItem<Item> OVCO_SMITHING_TEMPLATE = ITEMS.register("ovco_armor_trim_smithing_template",
            () -> SmithingTemplateItem.createArmorTrimTemplate(ResourceLocation.fromNamespaceAndPath(OmniGear.MOD_ID, "ovco")));

    public static final DeferredItem<Item> BISMUTH_BOW = ITEMS.register("bismuth_bow",
            () -> new BowItem(new Item.Properties()
                    .durability(500)));

    public static final DeferredItem<Item> ARTIST_BLOCK_MUSIC_DISC = ITEMS.register("artist_block_music_disc",
            () -> new Item(new Item.Properties()
                    .jukeboxPlayable(ModSounds.ARTIST_BLOCK_KEY)
                    .stacksTo(1)));

    public static final DeferredItem<Item> RADISH_SEEDS = ITEMS.register("radish_seeds",
            () -> new ItemNameBlockItem(ModBlocks.RADISH_CROP.get(), new Item.Properties()));
    public static final DeferredItem<Item> GOJI_BERRIES = ITEMS.register("goji_berries",
            () -> new ItemNameBlockItem(ModBlocks.GOJI_BERRY_BUSH.get(), new Item.Properties()
                    .food(ModFoodProperties.GOJI_BERRY)));

    public static final DeferredItem<Item> GECKO_SPAWN_EGG = ITEMS.register("gecko_spawn_egg",
            () -> new DeferredSpawnEggItem(ModEntities.GECKO, 0x31afaf, 0xffac00,
                    new Item.Properties()));

    public static final DeferredItem<Item> TOMAHAWK = ITEMS.register("tomahawk",
            () -> new TomahawkItem(new Item.Properties()
                    .stacksTo(16)));

    public static final DeferredItem<Item> RADIATION_STAFF = ITEMS.register("radiation_staff",
            () -> new Item(new Item.Properties()
                    .stacksTo(1)));

    public static final DeferredItem<Item> SCYTHE_OF_SHADOWS = ITEMS.register("scythe_of_shadows",
            () -> new ScytheOfShadowsItem(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
