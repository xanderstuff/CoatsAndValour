package dev.sterner.datagen;

import dev.sterner.registry.CAVObjects;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

public class CAVModelProvider extends FabricModelProvider {
    public CAVModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator generator) {
        // note: see BlockStateModelGenerator for vanilla examples
        generator.registerNorthDefaultHorizontalRotated(CAVObjects.TEXTILE_STATION, TexturedModel.ORIENTABLE_WITH_BOTTOM); // similar to vanilla's Loom
    }

    @Override
    public void generateItemModels(ItemModelGenerator generator) {
//        generator.register(CAVObjects.BATTLE_MAP, Models.GENERATED);
        generator.register(CAVObjects.BLOCK_RAMMER, Models.HANDHELD);
        generator.register(CAVObjects.CASESHOT, Models.GENERATED);
//        generator.register(CAVObjects.NATION_FLAG, Models.HANDHELD);
        generator.register(CAVObjects.POWDER_CHARGE, Models.GENERATED);
        generator.register(CAVObjects.ROUNDSHOT, Models.GENERATED);
        generator.register(CAVObjects.SHELLSHOT, Models.GENERATED);
        generator.register(CAVObjects.SPONGE, Models.GENERATED);

        // crafting ingredients (Tier 1)
        generator.register(CAVObjects.BAYONET, Models.GENERATED);
        generator.register(CAVObjects.STOCK, Models.GENERATED);
        generator.register(CAVObjects.GRIP, Models.GENERATED);
        generator.register(CAVObjects.LONG_BARREL, Models.GENERATED);
        generator.register(CAVObjects.SHORT_BARREL, Models.GENERATED);
        generator.register(CAVObjects.THICK_BARREL, Models.GENERATED);
        generator.register(CAVObjects.RAMROD, Models.HANDHELD);
        generator.register(CAVObjects.FLINTLOCK_MECHANISM, Models.GENERATED);
        generator.register(CAVObjects.CYLINDER, Models.GENERATED);
        generator.register(CAVObjects.SPRING, Models.GENERATED);

        // crafting ingredients (Tier 2)
        generator.register(CAVObjects.CRUDE_PERCUSSION_MECHANISM, Models.GENERATED);
        generator.register(CAVObjects.BOLT, Models.GENERATED);
        generator.register(CAVObjects.SCOPE, Models.GENERATED);

        // misc items
        generator.register(CAVObjects.BANDAGE, Models.GENERATED);
        generator.register(CAVObjects.BONE_SAW, Models.HANDHELD);
        registerGeneratedWithTwoLayers(generator, CAVObjects.NATION_UNIFORM_HAT);
        registerGeneratedWithTwoLayers(generator, CAVObjects.NATION_UNIFORM_COAT);
        registerGeneratedWithTwoLayers(generator, CAVObjects.NATION_UNIFORM_BREECHES);
        registerGeneratedWithTwoLayers(generator, CAVObjects.NATION_UNIFORM_BOOTS);

        generator.register(CAVObjects.DEBUG, Items.STICK, Models.GENERATED);
    }

    private void registerGeneratedWithTwoLayers(ItemModelGenerator generator, Item item) {
        // Based on net.minecraft.data.client.ItemModelGenerator.registerArmor
        Models.GENERATED_TWO_LAYERS.upload(
                ModelIds.getItemModelId(item),
                TextureMap.layered(TextureMap.getId(item), TextureMap.getSubId(item, "_overlay")),
                generator.writer,
                Models.GENERATED_TWO_LAYERS::createJson // ItemModelGenerator.createArmorJson() simplifies to this when you exclude the armour trim texture overrides
        );
    }
}
