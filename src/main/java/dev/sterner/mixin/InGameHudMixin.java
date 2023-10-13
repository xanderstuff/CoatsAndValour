package dev.sterner.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import dev.sterner.CoatsAndValour;
import dev.sterner.registry.CAVComponents;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public abstract class InGameHudMixin {
	@Unique
	private static final Identifier GANGRENE_HEARTS = CoatsAndValour.id("textures/gui/gangrene_hearts.png");


	// Inject within the for loop of renderHealthBar, at the very end of the loop so that we can overlap all other heart icon layers
	@Inject(method = "renderHealthBar",
			at = @At(value = "INVOKE",
					target = "Lnet/minecraft/client/gui/hud/InGameHud;drawHeart(Lnet/minecraft/client/gui/DrawContext;Lnet/minecraft/client/gui/hud/InGameHud$HeartType;IIIZZ)V",
					ordinal = 3, // target the last (4th) drawHeart() call in the for loop, so that we can draw over all other layers
					// the last drawHeart() is "inside an if statement", and that if statement is inside the for loop.
					// we want to be after (outside) of the if statement, but still inside the for loop,
					// ie we want to be the very last thing to run in the for loop.
					// unfortunately, there's not much to target within Mixin's limitations, so we need to Shift By 2 opcodes forward
					shift = At.Shift.BY,
					by = 2
					// Alternatively, we may be able to Inject At a JUMP (GOTO) and shift before, but that seems more fragile
			)
	)
	public void cav$renderGangreneHearts(
			DrawContext context, PlayerEntity player, int x, int y, int lines, int regeneratingHeartIndex, float maxHealth, int lastHealth, int health, int absorption, boolean blinking, CallbackInfo ci,
			@Local(ordinal = 11, name = "m") int heartLoopIndex,
			@Local(ordinal = 14, name = "p") int heartX,
			@Local(ordinal = 15, name = "q") int heartY
	) {
		// 'heartX' and 'heartY' are the x and y screen positions used for the drawHeart() calls in renderHealthBar()
		// 'heartLoopIndex' is the iteration count variable of the main for loop of renderHealthBar()
		// - it loops over all heart icons (1 heart icon = 2 half hearts) that are about to be drawn, counting down, from left to right on screen
		// note: the maximum/starting value is: ceil(max health / 2) + ceil(absorption hearts/2) - 1

		if (player.hasGangrene()) {
			//TODO: minor optimization: yes, these values could be cached with another Mixin so that we only get them once per frame
			var maxNormalHearts = MathHelper.ceil(maxHealth / 2.0);
			var gangreneLevel = player.getComponent(CAVComponents.GANGRENE).getGangreneLevel();
			if (maxNormalHearts - heartLoopIndex <= gangreneLevel) {
				context.drawTexture(GANGRENE_HEARTS, heartX, heartY, 9, 0, 9, 9);
			}
		}
	}
}
