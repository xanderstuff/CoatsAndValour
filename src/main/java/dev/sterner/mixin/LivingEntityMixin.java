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
            } else if (!hasGangrene()) {
                GangreneEffect.applyDefaultEffect(thiz);
            }
        } else {
            bleed.setBleedTime(0);
        }

        thiz.syncComponent(CAVComponents.BLEED); //FIXME: packet spam! 1 packet per entity per tick
    }

    @Unique
    private void updateGangrene() {
        var thiz = (LivingEntity) (Object) this;
        var gangrene = thiz.getComponent(CAVComponents.GANGRENE);
        var gangreneTime = gangrene.getGangreneTime();
        if (hasGangrene()) {
            gangrene.setGangreneTime(gangreneTime + 1);
            gangrene.setGangreneLevel(1 + MathHelper.floor((float) gangreneTime / GangreneEffect.TICKS_PER_INCREASE));
        } else {
            gangrene.setGangreneTime(0);
            gangrene.setGangreneLevel(0);
        }

        thiz.syncComponent(CAVComponents.GANGRENE); //FIXME: packet spam! 1 packet per entity per tick
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
