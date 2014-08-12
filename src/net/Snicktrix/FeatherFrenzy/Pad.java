package net.Snicktrix.FeatherFrenzy;

import org.bukkit.Location;

/**
 * Created by Luke on 8/11/14.
 */
public class Pad {
	private Location location;
	private boolean free = true;

	public Pad(Location location) {
		this.location = location;
	}

	public boolean isFree() {
		return free;
	}

	public void setFree(boolean free) {
		this.free = free;
	}

	public Location getLocation() {
		return location;
	}
}
