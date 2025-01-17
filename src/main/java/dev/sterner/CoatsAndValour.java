package dev.sterner;

import dev.sterner.registry.*;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CoatsAndValour implements ModInitializer {
    public static final String MODID = "coats-and-valour";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

    public static Identifier id(String name) {
        return new Identifier(MODID, name);
    }

    @Override
    public void onInitialize() {
        CAVObjects.init();
        CAVBlockEntities.init();
        CAVEntityTypes.init();
        CAVParticleTypes.init();
        CAVTagKeys.init();
        CAVSoundEvents.init();
        CAVMobEffects.registerAll();
    }
}