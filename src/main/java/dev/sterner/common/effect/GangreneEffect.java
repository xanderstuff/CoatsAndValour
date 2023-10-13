package dev.sterner.common.effect;

import dev.sterner.registry.CAVMobEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;

public final class GangreneEffect extends StatusEffect {
    public static final int TICKS_PER_INCREASE = 2400; // use 60 for testing

    public GangreneEffect() {
        super(StatusEffectCategory.HARMFUL, 0xB9B01A);
    }

    public static void applyDefaultEffect(LivingEntity livingEntity) {
        livingEntity.addStatusEffect(new StatusEffectInstance(CAVMobEffects.GANGRENE, -1, 0, false, false, true));
    }
}
