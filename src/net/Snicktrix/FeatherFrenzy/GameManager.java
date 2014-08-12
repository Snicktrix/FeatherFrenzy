package net.Snicktrix.FeatherFrenzy;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

/**
 * Created by Luke on 8/11/14.
 */
public class GameManager {
	private FeatherFrenzy plugin;

	private ArrayList<GamePlayer> gamePlayers = new ArrayList<GamePlayer>();
	private ArrayList<Pad> padList = new ArrayList<Pad>();


	public GameManager(FeatherFrenzy plugin) {
		this.plugin = plugin;
	}

	//Todo for tomorrow
	//Generate three random integers between the
	// minimum and maximum values on all three axes
	// (Random.nextInt(max - min) + min),
	// then convert them to a Location and teleport the player there.

	public void join(Player player) {
		GamePlayer gamePlayer = new GamePlayer(player);
		this.gamePlayers.add(gamePlayer);

		if (getEmptyPad() != null) ß{
			Pad pad = getEmptyPad();
			gamePlayer.setPad(pad);
			pad.setFree(false);
			Location loc = pad.getLocation();

			player.teleport(new Location(loc.getWorld(), loc.getX(), loc.getY(), loc.getZ()));
			setupPlayerInventory(player);
			player.sendMessage("You have joined the game");
		} else {
			System.out.println("Not enough room for " + player.getName() + " to join. Kicking...");
			player.kickPlayer("Game Full");
		}
	}

	public void leave(Player player) {
		GamePlayer gamePlayer = getGamePlayer(player);
		if (gamePlayer.getPad() != null) {
			for (Pad pad : this.padList) {
				if (gamePlayer.getPad().equals(pad)) {
					pad.setFree(true);
				}
			}
		}
		this.gamePlayers.remove(gamePlayer);
	}

	public void setupPlayerInventory(Player player) {
		player.setHealth(player.getMaxHealth());

		player.getInventory().setArmorContents(null);
		player.getInventory().clear();

		player.getInventory().addItem(new ItemStack(Material.BOW));
		player.getInventory().addItem(new ItemStack(Material.ARROW, 64));
		player.getInventory().addItem(new ItemStack(Material.ARROW, 64));
	}

	public void chickenKill(Player player) {
		GamePlayer gamePlayer = getGamePlayer(player);

		player.playSound(player.getLocation(), Sound.NOTE_PLING, 10, 1);
		gamePlayer.setScore(gamePlayer.getScore() + 1);
		gamePlayer.getPlayer().sendMessage("You have " + Integer.toString(gamePlayer.getScore()) + " points");
	}

	public void addPad(Location location) {
		Pad pad = new Pad(location);
		this.padList.add(pad);
	}

	//********** GETTERS **********//

	public Pad getEmptyPad() {
		for (Pad pad : this.padList) {
			if (pad.isFree()) {
				return pad;
			}
		}
		return null;
	}

	public GamePlayer getGamePlayer(Player player) {
		for (GamePlayer gamePlayer : this.gamePlayers) {
			if (gamePlayer.getPlayer() == player) {
				return gamePlayer;
			}
		}
		return null;
	}

}
