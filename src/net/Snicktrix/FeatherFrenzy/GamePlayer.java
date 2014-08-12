package net.Snicktrix.FeatherFrenzy;

import org.bukkit.entity.Player;

/**
 * Created by Luke on 8/11/14.
 */
public class GamePlayer {
	private Player player;
	private int score;
	private Pad pad;

	public GamePlayer(Player player) {
		this.player = player;

		//Default score
		this.score = 0;
	}

	public Pad getPad() {
		return pad;
	}

	public void setPad(Pad pad) {
		this.pad = pad;
	}

	public Player getPlayer() {
		return player;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
