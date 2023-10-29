package dev.sterner.mixin;

import dev.sterner.CoatsAndValourEntity;
import dev.sterner.common.effect.GangreneEffect;
import dev.sterner.registry.CAVComponents;
import dev.sterner.registry.CAVMobEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public final class LivingEntityMixin implements CoatsAndValourEntity {

    @Inject(method = "tick", at = @At("HEAD"))
    public void cav$tick(CallbackInfo ci) {
        if (!((LivingEntity) (Object) this).getWorld().isClient) {
            // server-side only
            updateBleeding();
            updateGangrene();
        }
    }

    @Unique
    private void updateBleeding() {
        var thiz = (LivingEntity) (Object) this;
        var bleed = thiz.getComponent(CAVComponents.BLEED);
        var bleedTime = bleed.getBleedTime();
        if (isBleeding()) {
            if (bleedTime < 1200) { // use 80 for testing
                bleed.setBleedTime(bleedTime + 1);
                // sending a packet every tick per entity that is bleeding is still somewhat excessive,
                // but in normal gameplay it is uncommon to have this effect, so this is adequate (KISS).
                // I suppose we could even just send this packet to clients every x ticks
                thiz.syncComponent(CAVComponents.BLEED);
            } else if (!hasGangrene()) {
                GangreneEffect.applyDefaultEffect(thiz);
            }
        } else if (bleedTime != 0) { // only update the first time the state changes from on -> off
            bleed.setBleedTime(0);
            thiz.syncComponent(CAVComponents.BLEED);
        }
    }

    @Unique
    private void updateGangrene() {
        var thiz = (LivingEntity) (Object) this;
        var gangrene = thiz.getComponent(CAVComponents.GANGRENE);
        var gangreneTime = gangrene.getGangreneTime();
        if (hasGangrene()) {
            gangrene.setGangreneTime(gangreneTime + 1);
            gangrene.setGangreneLevel(1 + MathHelper.floor((float) gangreneTime / GangreneEffect.TICKS_PER_INCREASE));
            // sending a packet every tick per entity that has active gangrene is still somewhat excessive,
            // but in normal gameplay it is uncommon to have this effect, so this is adequate (KISS).
            // I suppose we could even just send this packet to clients every x ticks
            thiz.syncComponent(CAVComponents.GANGRENE);
        } else if (gangrene.getGangreneLevel() != 0 || gangreneTime != 0) { // only update the first time the state changes from on -> off
            gangrene.setGangreneTime(0);
            gangrene.setGangreneLevel(0);
            thiz.syncComponent(CAVComponents.GANGRENE);
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
