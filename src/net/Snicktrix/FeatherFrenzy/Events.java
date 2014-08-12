package net.Snicktrix.FeatherFrenzy;

import org.bukkit.entity.Chicken;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * Created by Luke on 8/11/14.
 */
public class Events implements Listener {
	private FeatherFrenzy plugin;

	public Events(FeatherFrenzy plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		this.plugin.gameManager.join(event.getPlayer());
	}

	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		this.plugin.gameManager.leave(event.getPlayer());
	}

	@EventHandler
	public void onDeath(EntityDeathEvent event) {
		if (event.getEntity() instanceof Chicken) {
			if (event.getEntity().getKiller() instanceof Player) {
				Player killer = event.getEntity().getKiller();
			}
		}
	}
}
