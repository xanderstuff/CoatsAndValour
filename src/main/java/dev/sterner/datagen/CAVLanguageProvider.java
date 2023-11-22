package dev.sterner.datagen;

import dev.sterner.registry.CAVObjects;
import dev.sterner.registry.CAVMobEffects;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class CAVLanguageProvider extends FabricLanguageProvider {
    protected CAVLanguageProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generateTranslations(TranslationBuilder builder) {
        builder.add("coats-and-valour.group.main", "Coats and Valour");
        builder.add(CAVObjects.BLUNDERBUSS, "Blunderbuss");
        builder.add(CAVObjects.PISTOL, "Pistol");
        builder.add(CAVObjects.MUSKET, "Musket");
//        builder.add(CAVObjects.NOCK_GUN, "Nock Gun");
//        builder.add(CAVObjects.DUCKFOOT, "Duckfoot");
//        builder.add(CAVObjects.SANGUINE_HUNTER, "Sanguine Hunter");
//        builder.add(CAVObjects.PISTOL_SWORD, "Pistol Sword");

//        builder.add(CAVObjects.BATTLE_MAP, "Battle Map");
        builder.add(CAVObjects.BLOCK_RAMMER, "Block Rammer");
        builder.add(CAVObjects.CASESHOT, "Caseshot");
        builder.add(CAVObjects.MUSKET_SHOT, "Musket Shot");
//        builder.add(CAVObjects.NATION_FLAG, "Nation Flag");
        builder.add(CAVObjects.PELLET_SHOT, "Pellet Shot");
        builder.add(CAVObjects.PISTOL_SHOT, "Pistol Shot");
        builder.add(CAVObjects.POWDER_CHARGE, "Powder Charge");
        builder.add(CAVObjects.ROUNDSHOT, "Roundshot");
        builder.add(CAVObjects.SABRE, "Sabre");
        builder.add(CAVObjects.SHELLSHOT, "Shellshot");
        builder.add(CAVObjects.SILVER_SHOT, "Silver Shot");
        builder.add(CAVObjects.SPONGE, "Sponge");

        // crafting ingredients (Tier 1)
        builder.add(CAVObjects.BAYONET, "Bayonet");
        builder.add(CAVObjects.STOCK, "Stock");
        builder.add(CAVObjects.GRIP, "Grip");
        builder.add(CAVObjects.LONG_BARREL, "Long Barrel");
        builder.add(CAVObjects.SHORT_BARREL, "Short Barrel");
        builder.add(CAVObjects.THICK_BARREL, "Thick Barrel");
        builder.add(CAVObjects.RAMROD, "Ramrod");
        builder.add(CAVObjects.FLINTLOCK_MECHANISM, "Flintlock Mechanism");
        builder.add(CAVObjects.CYLINDER, "Cylinder");
        builder.add(CAVObjects.SPRING, "Spring");

        // crafting ingredients (Tier 2)
        builder.add(CAVObjects.CRUDE_PERCUSSION_MECHANISM, "Crude Percussion Mechanism");
        builder.add(CAVObjects.BOLT, "Bolt");
        builder.add(CAVObjects.SCOPE, "Scope");

        // misc items
        builder.add(CAVObjects.BANDAGE, "Bandage");
        builder.add(CAVObjects.BONE_SAW, "Bone Saw");
        builder.add(CAVObjects.NATION_UNIFORM_HAT, "Hat");
        builder.add(CAVObjects.NATION_UNIFORM_COAT, "Coat");
        builder.add(CAVObjects.NATION_UNIFORM_BREECHES, "Breeches");
        builder.add(CAVObjects.NATION_UNIFORM_BOOTS, "Boots");

        // status effects
        builder.add(CAVMobEffects.BLEED, "Bleed");
        builder.add(CAVMobEffects.GANGRENE, "Gangrene");

        builder.add(CAVObjects.DEBUG, "Debug Wand");
    }
}
