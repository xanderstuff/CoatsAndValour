package dev.sterner.registry;

import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.item.DyeableItem;
import net.minecraft.item.Item;

public interface CAVColorProviders {
	static void clientInit() {
		for (Item item : CAVObjects.ITEMS.keySet()) {
			if (item instanceof DyeableItem) {
				// similar to how net.minecraft.client.color.item.ItemColors.create() registers color providers for leather armour
				ColorProviderRegistry.ITEM.register((stack, tintIndex) -> tintIndex > 0 ? -1 : ((DyeableItem) stack.getItem()).getColor(stack), item);
			}
		}
	}
}
