package dev.sterner.common.effect;

import dev.sterner.registry.CAVMobEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;

public final class BleedEffect extends StatusEffect {
    public BleedEffect() {
        super(StatusEffectCategory.HARMFUL, 0xD40017);
    }

    public static void applyDefaultEffect(LivingEntity livingEntity) {
        livingEntity.addStatusEffect(new StatusEffectInstance(CAVMobEffects.BLEED, -1, 0, false, false, true));
    }
}
