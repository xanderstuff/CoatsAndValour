package dev.sterner.client.render.item;

import dev.sterner.client.model.NationUniformArmourModel;
import dev.sterner.common.item.NationUniformArmourItem;
import mod.azure.azurelib.renderer.GeoArmorRenderer;

public class NationUniformArmourRenderer extends GeoArmorRenderer<NationUniformArmourItem> {
	public NationUniformArmourRenderer() {
		super(new NationUniformArmourModel());
	}
}
