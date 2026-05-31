package net.ovco69.tutorialmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.ovco69.tutorialmod.TutorialMod;
import net.ovco69.tutorialmod.block.ModBlocks;
import net.ovco69.tutorialmod.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        List<ItemLike> BISMUTH_SMELTABLES = List.of(
                ModItems.RAW_BISMUTH,
                ModBlocks.BISMUTH_ORE,
                ModBlocks.DEEPSLATE_BISMUTH_ORE
        );

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BISMUTH_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.BISMUTH.get())
                .unlockedBy("has_bismuth", has(ModItems.BISMUTH))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BISMUTH.get(), 9)
                .requires(ModBlocks.BISMUTH_BLOCK.get())
                .unlockedBy("has_bismuth_block", has(ModBlocks.BISMUTH_BLOCK.get()))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BISMUTH.get(), 9)
                .requires(ModBlocks.MAGIC_BLOCK.get())
                .unlockedBy("has_magic_block", has(ModBlocks.MAGIC_BLOCK.get()))
                .save(recipeOutput, "tutorialmod:bismuth_from_magic_block");

        oreSmelting(recipeOutput, BISMUTH_SMELTABLES, RecipeCategory.MISC, ModItems.BISMUTH.get(), .25f, 200, "bismuth");
        oreBlasting(recipeOutput, BISMUTH_SMELTABLES, RecipeCategory.MISC, ModItems.BISMUTH.get(), .25f, 100, "bismuth");

        stairBuilder(ModBlocks.BISMUTH_STAIRS.get(), Ingredient.of(ModItems.BISMUTH))
                .group("bismuth")
                .unlockedBy("has_bismuth", has(ModItems.BISMUTH))
                .save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BISMUTH_SLAB.get(), ModItems.BISMUTH.get());
        pressurePlate(recipeOutput, ModBlocks.BISMUTH_PRESSURE_PLATE, ModItems.BISMUTH.get());
        buttonBuilder(ModBlocks.BISMUTH_BUTTON.get(), Ingredient.of(ModItems.BISMUTH))
                .group("bismuth")
                .unlockedBy("has_bismuth", has(ModItems.BISMUTH))
                .save(recipeOutput);

        fenceBuilder(ModBlocks.BISMUTH_FENCE.get(), Ingredient.of(ModItems.BISMUTH))
                .group("bismuth")
                .unlockedBy("has_bismuth", has(ModItems.BISMUTH))
                .save(recipeOutput);
        fenceGateBuilder(ModBlocks.BISMUTH_FENCE_GATE.get(), Ingredient.of(ModItems.BISMUTH))
                .group("bismuth")
                .unlockedBy("has_bismuth", has(ModItems.BISMUTH))
                .save(recipeOutput);
        bismuthWall(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BISMUTH_WALL.get(), ModBlocks.BISMUTH_BLOCK.get());

        doorBuilder(ModBlocks.BISMUTH_DOOR.get(), Ingredient.of(ModItems.BISMUTH))
                .group("bismuth")
                .unlockedBy("has_bismuth", has(ModItems.BISMUTH))
                .save(recipeOutput);
        trapdoorBuilder(ModBlocks.BISMUTH_TRAPDOOR.get(), Ingredient.of(ModItems.BISMUTH))
                .group("bismuth")
                .unlockedBy("has_bismuth", has(ModItems.BISMUTH))
                .save(recipeOutput);

        helmetItem(recipeOutput, RecipeCategory.COMBAT, ModItems.BISMUTH_HELMET.get(), ModItems.BISMUTH.get());
        chestplateItem(recipeOutput, RecipeCategory.COMBAT, ModItems.BISMUTH_CHESTPLATE.get(), ModItems.BISMUTH.get());
        leggingsItem(recipeOutput, RecipeCategory.COMBAT, ModItems.BISMUTH_LEGGINGS.get(), ModItems.BISMUTH.get());
        bootsItem(recipeOutput, RecipeCategory.COMBAT, ModItems.BISMUTH_BOOTS.get(), ModItems.BISMUTH.get());

        trimSmithing(recipeOutput, ModItems.OVCO_SMITHING_TEMPLATE.get(), ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "ovco"));

        bowItem(recipeOutput, RecipeCategory.COMBAT, ModItems.BISMUTH_BOW, ModItems.BISMUTH.get(), Items.STRING);
    }

    private void bowItem(RecipeOutput recipeOutput, RecipeCategory recipeCategory, ItemLike bow, ItemLike material, ItemLike stringMaterial) {
        ShapedRecipeBuilder.shaped(recipeCategory, bow)
                .pattern(" BS")
                .pattern("B S")
                .pattern(" BS")
                .define('B', material)
                .define('S', stringMaterial)
                .unlockedBy("has_" + BuiltInRegistries.ITEM.getKey(material.asItem()).getPath(), has(material))
                .save(recipeOutput);
    }

    protected static void helmetItem(RecipeOutput recipeOutput, RecipeCategory recipeCategory, ItemLike helmet, ItemLike material) {
        ShapedRecipeBuilder.shaped(recipeCategory, helmet)
                .pattern("BBB")
                .pattern("B B")
                .define('B', material)
                .unlockedBy("has_" + BuiltInRegistries.ITEM.getKey(material.asItem()).getPath(), has(material))
                .save(recipeOutput);
    }
    protected static void chestplateItem(RecipeOutput recipeOutput, RecipeCategory recipeCategory, ItemLike chestplate, ItemLike material) {
        ShapedRecipeBuilder.shaped(recipeCategory, chestplate)
                .pattern("B B")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', material)
                .unlockedBy("has_" + BuiltInRegistries.ITEM.getKey(material.asItem()).getPath(), has(material))
                .save(recipeOutput);
    }
    protected static void leggingsItem(RecipeOutput recipeOutput, RecipeCategory recipeCategory, ItemLike leggings, ItemLike material) {
        ShapedRecipeBuilder.shaped(recipeCategory, leggings)
                .pattern("BBB")
                .pattern("B B")
                .pattern("B B")
                .define('B', material)
                .unlockedBy("has_" + BuiltInRegistries.ITEM.getKey(material.asItem()).getPath(), has(material))
                .save(recipeOutput);
    }
    protected static void bootsItem(RecipeOutput recipeOutput, RecipeCategory recipeCategory, ItemLike boots, ItemLike material) {
        ShapedRecipeBuilder.shaped(recipeCategory, boots)
                .pattern("B B")
                .pattern("B B")
                .define('B', material)
                .unlockedBy("has_" + BuiltInRegistries.ITEM.getKey(material.asItem()).getPath(), has(material))
                .save(recipeOutput);
    }

    protected static void bismuthWall(RecipeOutput recipeOutput, RecipeCategory recipeCategory, ItemLike wall, ItemLike material) {
        ShapedRecipeBuilder.shaped(recipeCategory, wall, 6)
                .pattern("BBB")
                .pattern("BBB")
                .define('B', material)
                .unlockedBy("has_bismuth", has(ModItems.BISMUTH.get()))
                .save(recipeOutput);
    }
    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer,
                                                                       AbstractCookingRecipe.Factory<T> factory, List<ItemLike> pIngredients,
                                                                       RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime,
                                                                       String pGroup, String pRecipeName) {
        for (ItemLike itemLike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemLike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory)
                    .group(pGroup)
                    .unlockedBy(getHasName(itemLike), has(itemLike))
                    .save(recipeOutput, TutorialMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemLike));
        }
    }
}
