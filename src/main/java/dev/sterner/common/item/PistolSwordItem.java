package dev.sterner.common.item;

import dev.sterner.api.interfaces.IDualModel;
import dev.sterner.common.util.GunProperties;
import net.minecraft.item.ToolMaterials;

@Deprecated(forRemoval = false)
public class PistolSwordItem extends CockableSwordGunItem implements IDualModel {
    public PistolSwordItem(Settings settings, GunProperties gunProperties) {
        super(ToolMaterials.IRON, 3, -2.4F, gunProperties, settings);
    }
}
