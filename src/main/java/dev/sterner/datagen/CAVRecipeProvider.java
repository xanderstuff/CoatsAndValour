package dev.sterner.datagen;

import dev.sterner.registry.CAVObjects;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.ItemTags;

import java.util.function.Consumer;

public class CAVRecipeProvider extends FabricRecipeProvider {

	public CAVRecipeProvider(FabricDataOutput output) {
		super(output);
	}

	@Override
	public void generate(Consumer<RecipeJsonProvider> exporter) {
		// note: see RecipeProvider for what methods are available and see VanillaRecipeProvider for examples

//		ShapelessRecipeJsonBuilder.create(RecipeCategory.SOMETHING, CAVObjects.RESULT, 1)
//				.input(CAVObjects.INPUT1)
//				.input(CAVObjects.INPUT2)
//				.input(CAVObjects.INPUT3)
//				.criterion(hasItem(CAVObjects.INPUT1), conditionsFromItem(CAVObjects.INPUT1))
//				.criterion(hasItem(CAVObjects.INPUT2), conditionsFromItem(CAVObjects.INPUT2))
//				.criterion(hasItem(CAVObjects.INPUT3), conditionsFromItem(CAVObjects.INPUT3))
//				.offerTo(exporter);

//		ShapedRecipeJsonBuilder.create(RecipeCategory.SOMETHING, ModItems.RESULT, 1)
//				.input('A', CAVObjects.INPUT1)
//				.input('B', CAVObjects.INPUT2)
//				.input('S', Items.STICK)
//				.pattern(" A ")
//				.pattern("ABA")
//				.pattern(" S ")
//				.criterion(hasItem(CAVObjects.INPUT1), conditionsFromItem(CAVObjects.INPUT1))
//				.criterion(hasItem(CAVObjects.INPUT2), conditionsFromItem(CAVObjects.INPUT2))
//				.offerTo(exporter);

		// simple crafting ingredients (Tier 1)
		ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, CAVObjects.BAYONET, 1)
				.input('i', Items.IRON_INGOT)
				.input('n', Items.IRON_NUGGET)
				.pattern("i  ")
				.pattern("nnn")
				.criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
				.criterion(hasItem(Items.GUNPOWDER), conditionsFromItem(Items.GUNPOWDER))
				.offerTo(exporter);
		ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, CAVObjects.STOCK, 1)
				.input('w', ItemTags.LOGS)
				.pattern("www")
				.pattern(" ww")
				.criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
				.criterion(hasItem(Items.GUNPOWDER), conditionsFromItem(Items.GUNPOWDER))
				.offerTo(exporter);
		ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, CAVObjects.GRIP, 1)
				.input('p', ItemTags.PLANKS)
				.pattern("pp")
				.pattern(" p")
				.criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
				.criterion(hasItem(Items.GUNPOWDER), conditionsFromItem(Items.GUNPOWDER))
				.offerTo(exporter);
		ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, CAVObjects.LONG_BARREL, 1)
				.input('i', Items.IRON_INGOT)
				.input('n', Items.IRON_NUGGET)
				.pattern("nii")
				.criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
				.criterion(hasItem(Items.GUNPOWDER), conditionsFromItem(Items.GUNPOWDER))
				.offerTo(exporter);
		ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, CAVObjects.SHORT_BARREL, 1)
				.input('n', Items.IRON_NUGGET)
				.pattern("nnn")
				.criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
				.criterion(hasItem(Items.GUNPOWDER), conditionsFromItem(Items.GUNPOWDER))
				.offerTo(exporter);
		ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, CAVObjects.THICK_BARREL, 1)
				.input('i', Items.IRON_INGOT)
				.input('n', Items.IRON_NUGGET)
				.pattern("nii")
				.pattern("nii")
				.criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
				.criterion(hasItem(Items.GUNPOWDER), conditionsFromItem(Items.GUNPOWDER))
				.offerTo(exporter);
		ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, CAVObjects.RAMROD, 1)
				.input('n', Items.IRON_NUGGET)
				.input('s', Items.STICK)
				.input('c', Items.COPPER_INGOT)
				.pattern("nsc")
				.criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
				.criterion(hasItem(Items.GUNPOWDER), conditionsFromItem(Items.GUNPOWDER))
				.offerTo(exporter);
		ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, CAVObjects.FLINTLOCK_MECHANISM, 1)
				.input('n', Items.IRON_NUGGET)
				.input('f', Items.FLINT_AND_STEEL)
				.input('t', Items.TRIPWIRE_HOOK)
				.input('s', CAVObjects.SPRING)
				.pattern("n f")
				.pattern(" ts")
				.criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
				.criterion(hasItem(Items.GUNPOWDER), conditionsFromItem(Items.GUNPOWDER))
				.offerTo(exporter);
		ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, CAVObjects.CYLINDER, 1)
				.input('i', Items.IRON_INGOT)
				.input('n', Items.IRON_NUGGET)
				.input('s', CAVObjects.SPRING)
				.pattern(" i ")
				.pattern("ini")
				.pattern(" is")
				.criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
				.criterion(hasItem(Items.GUNPOWDER), conditionsFromItem(Items.GUNPOWDER))
				.offerTo(exporter);
		ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, CAVObjects.SPRING, 1)
				.input('n', Items.IRON_NUGGET)
				.pattern("nn ")
				.pattern(" nn")
				.pattern("nn ")
				.criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
				.criterion(hasItem(Items.GUNPOWDER), conditionsFromItem(Items.GUNPOWDER))
				.offerTo(exporter);

		// simple crafting ingredients (Tier 2)
		ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, CAVObjects.CRUDE_PERCUSSION_MECHANISM, 1)
				.input('i', Items.IRON_INGOT)
				.input('n', Items.IRON_NUGGET)
				.input('s', CAVObjects.SPRING)
				.input('t', Items.TRIPWIRE_HOOK)
				.input('d', Items.DIAMOND)
				.pattern("  i")
				.pattern("nds")
				.pattern(" t ")
				.criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
				.offerTo(exporter);
		ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, CAVObjects.BOLT, 1)
				.input('i', Items.IRON_INGOT)
				.input('n', Items.IRON_NUGGET)
				.input('s', CAVObjects.SPRING)
				.pattern("iis")
				.pattern(" n ")
				.criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
				.offerTo(exporter);
		ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, CAVObjects.SCOPE, 1)
				.input('s', Items.SPYGLASS)
				.input('n', Items.IRON_NUGGET)
				.input('t', Items.TRIPWIRE_HOOK)
				.pattern(" n ")
				.pattern(" s ")
				.pattern("tnt")
				.criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
				.offerTo(exporter);
	}
}
