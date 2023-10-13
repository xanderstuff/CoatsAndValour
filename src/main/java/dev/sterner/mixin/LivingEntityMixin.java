package dev.sterner.mixin;

import dev.sterner.CoatsAndValourEntity;
import dev.sterner.registry.CAVComponents;
import dev.sterner.registry.CAVMobEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public final class LivingEntityMixin implements CoatsAndValourEntity {

    @Inject(method = "tick", at = @At("HEAD"))
    public void cav$tick(CallbackInfo ci) {
        var thiz = (LivingEntity) (Object) this;
        if (!thiz.getWorld().isClient) {
            var bleed = thiz.getComponent(CAVComponents.BLEED);

            if (isBleeding()) {
                var bleedTime = bleed.getBleedTime();
                if (bleedTime < 1200) {
                    bleed.setBleedTime(bleedTime + 1);
                } else if (!hasGangrene()) {
                    thiz.addStatusEffect(new StatusEffectInstance(CAVMobEffects.GANGRENE, 600, 1));
                }
            } else {
                bleed.setBleedTime(0);
            }

            thiz.syncComponent(CAVComponents.BLEED);
        }
    }

    @Override
    public boolean isBleeding() {
        return ((LivingEntity) (Object) this).hasStatusEffect(CAVMobEffects.BLEED);
    }

    @Override
    public boolean hasGangrene() {
        return ((LivingEntity) (Object) this).hasStatusEffect(CAVMobEffects.GANGRENE);
    }
}
