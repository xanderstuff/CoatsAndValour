package dev.sterner.datagen;

import dev.sterner.registry.CAVObjects;
import dev.sterner.registry.CAVTagKeys;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class CAVTagProvider {
    public static class BlockTagProvider extends FabricTagProvider.BlockTagProvider {

        public BlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
            super(output, registriesFuture);
        }

        @Override
        protected void configure(RegistryWrapper.WrapperLookup arg) {
            // note: see VanillaBlockTagProvider for examples
            getOrCreateTagBuilder(BlockTags.AXE_MINEABLE).add(CAVObjects.TEXTILE_STATION);
        }
    }

    public static class ItemTagProvider extends FabricTagProvider.ItemTagProvider {

        public ItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
            super(output, completableFuture);
        }

        @Override
        protected void configure(RegistryWrapper.WrapperLookup arg) {
            getOrCreateTagBuilder(CAVTagKeys.PISTOL_AMMO).add(CAVObjects.PISTOL_SHOT).add(CAVObjects.SILVER_SHOT);
            getOrCreateTagBuilder(CAVTagKeys.MUSKET_AMMO).add(CAVObjects.MUSKET_SHOT).add(CAVObjects.SILVER_SHOT);
            getOrCreateTagBuilder(CAVTagKeys.BLUNDERBUSS_AMMO).addTag(CAVTagKeys.PISTOL_AMMO).addTag(CAVTagKeys.MUSKET_AMMO).add(CAVObjects.SILVER_SHOT).add(CAVObjects.PELLET_SHOT);
            getOrCreateTagBuilder(CAVTagKeys.DUCKFOOT_AMMO).addTag(CAVTagKeys.BLUNDERBUSS_AMMO);
            getOrCreateTagBuilder(CAVTagKeys.SANGUINE_HUNTER_AMMO).addTag(CAVTagKeys.BLUNDERBUSS_AMMO);
            getOrCreateTagBuilder(CAVTagKeys.NOCK_GUN_AMMO).addTag(CAVTagKeys.BLUNDERBUSS_AMMO);
            getOrCreateTagBuilder(CAVTagKeys.PISTOL_SWORD_AMMO).addTag(CAVTagKeys.PISTOL_AMMO);

        }
    }

    public static class EntityTypeTagProvider extends FabricTagProvider.EntityTypeTagProvider {

        public EntityTypeTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
            super(output, completableFuture);
        }

        @Override
        protected void configure(RegistryWrapper.WrapperLookup arg) {
            // note: see VanillaEntityTypeTagProvider for examples

        }
    }
}
