package dev.sterner.common.component;

import dev.onyxstudios.cca.api.v3.component.ComponentV3;
import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import net.minecraft.nbt.NbtCompound;

public final class GangreneComponent implements ComponentV3, AutoSyncedComponent {
	private int gangreneTime;
	private int gangreneLevel;

	@Override
	public void readFromNbt(NbtCompound tag) {
		gangreneTime = tag.getInt("GangreneTime");
		gangreneLevel = tag.getInt("GangreneLevel");
	}

	@Override
	public void writeToNbt(NbtCompound tag) {
		tag.putInt("GangreneTime", gangreneTime);
		tag.putInt("GangreneLevel", gangreneLevel);
	}

	public int getGangreneTime() {
		return gangreneTime;
	}

	public void setGangreneTime(int gangreneTime) {
		this.gangreneTime = gangreneTime;
	}

	public int getGangreneLevel() {
		return gangreneLevel;
	}

	public void setGangreneLevel(int gangreneLevel) {
		this.gangreneLevel = gangreneLevel;
	}
}
