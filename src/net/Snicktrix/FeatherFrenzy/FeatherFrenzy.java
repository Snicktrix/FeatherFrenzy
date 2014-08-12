package net.Snicktrix.FeatherFrenzy;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Luke on 8/11/14.
 */
public class FeatherFrenzy extends JavaPlugin {
	public GameManager gameManager;
	public Events events;

	public void onEnable() {
		this.gameManager = new GameManager(this);
		this.events = new Events(this);
		Bukkit.getPluginManager().registerEvents(this.events, this);

		this.loadConfig();
	}

	private void loadConfig() {
		//Set up the config
		getConfig().options().copyDefaults(true);
		saveDefaultConfig();

		for (String s : getConfig().getKeys(false)) {
			double x = getConfig().getDouble(s + ".x");
			double y = getConfig().getDouble(s + ".y");
			double z = getConfig().getDouble(s + ".z");

			Location location = new Location(Bukkit.getWorld("game"), x, y, z);
			gameManager.addPad(location);
			//Log it
			System.out.println("Added pad at " + Double.toString(x) + ", " + Double.toString(y)
					+ ", " + Double.toString(z));
		}
	}
}
