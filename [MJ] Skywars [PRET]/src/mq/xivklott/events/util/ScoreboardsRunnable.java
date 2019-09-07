package mq.xivklott.events.util;

import java.util.Map.Entry;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import mq.xivklott.events.SkyJoin;

public class ScoreboardsRunnable extends BukkitRunnable{

	@Override
	public void run() {
		for(Entry<Player, CustomScoreboardManager> scoreboard : SkyJoin.sb.entrySet()) {
			CustomScoreboardManager board = scoreboard.getValue();
			board.refresh();
		}
	}
	

}
