package dev.sterner.datagen;

import dev.sterner.registry.CAVObjects;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.Items;

public class CAVModelProvider extends FabricModelProvider {
    public CAVModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator generator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator generator) {
        generator.register(CAVObjects.BANDAGE, Models.GENERATED);
//        generator.register(CAVObjects.BATTLE_MAP, Models.GENERATED);
        generator.register(CAVObjects.BLOCK_RAMMER, Models.HANDHELD);
        generator.register(CAVObjects.BONE_SAW, Models.HANDHELD);
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

        generator.register(CAVObjects.DEBUG, Items.STICK, Models.GENERATED);
    }
}
