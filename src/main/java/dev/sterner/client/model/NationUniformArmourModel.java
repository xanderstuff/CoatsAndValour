package dev.sterner.client.model;

import dev.sterner.CoatsAndValour;
import dev.sterner.common.item.NationUniformArmourItem;
import mod.azure.azurelib.model.GeoModel;
import net.minecraft.util.Identifier;

public class NationUniformArmourModel extends GeoModel<NationUniformArmourItem> {
	@Override
	public Identifier getModelResource(NationUniformArmourItem animatable) {
		return CoatsAndValour.id("geo/nation_uniform.geo.json");
	}

	@Override
	public Identifier getTextureResource(NationUniformArmourItem animatable) {
		return CoatsAndValour.id("textures/armor/nation_uniform/blank.png");
	}

	@Override
	public Identifier getAnimationResource(NationUniformArmourItem animatable) {
		return CoatsAndValour.id("animations/nation_uniform.animation.json");
	}
}
