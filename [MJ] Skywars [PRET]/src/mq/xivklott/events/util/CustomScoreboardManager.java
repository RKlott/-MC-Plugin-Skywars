package mq.xivklott.events.util;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import mq.xivklott.events.SkyJoin;
import mq.xivklott.game.GameManager;
import mq.xivklott.main.SkyWars;

public class CustomScoreboardManager implements ScoreboardManager {

	public Player player;
	public Scoreboard scoreboard;
	public Objective objective;
	
	private String name; 
	
	public CustomScoreboardManager(Player p) {
		this.scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
		this.player = p;
		   
		if(SkyJoin.sb.containsKey(p)) return;
		SkyJoin.sb.put(p, this);	
		
		this.name = "sb." + new Random().nextInt(999999);
		
		objective =scoreboard.registerNewObjective(name, "dummy");
		objective = scoreboard.getObjective(name);
		objective.setDisplayName("§b§lSKYWARS         ");
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
		
	} 
	
	public void refresh() {
		for(String ligne : scoreboard.getEntries()) {
			if(ligne.contains("§9» §bRefill des Chests")) { 
				
				scoreboard.resetScores(ligne);
				String lastligne = ligne.split(":")[0];
				String newligne = lastligne + ":" + " " + GameManager.timer + "s";
				String twoligne = lastligne + ":" + " §cAucun refill actif";
				
				if(GameManager.timer == 0) {
					objective.getScore(twoligne).setScore(2);
				} else {
					objective.getScore(newligne).setScore(2);
				}
			}
			if(ligne.contains("§4» §cJoueurs :")) {
				
				scoreboard.resetScores(ligne);
				String lastligne = ligne.split(":")[0];
				String newligne = lastligne + ":" + " " + SkyWars.getInstance().playersList.size() + "§e/§c8";
				
				objective.getScore(newligne).setScore(4);
			}
		}
	}
	
	public void sendLine() {
		objective.getScore(ChatColor.WHITE + "-" + ChatColor.GRAY + "§m---------------" + ChatColor.DARK_GRAY + "-").setScore(8);
		objective.getScore("§8 ").setScore(7);
		objective.getScore("§e» §6Map : " + ChatColor.YELLOW+ SkyWars.getInstance().getConfig().getString(SkyWars.getInstance().coloration("map"))).setScore(6);
		objective.getScore("§1 ").setScore(5);
		objective.getScore("§4» §cJoueurs :").setScore(4);
		objective.getScore("§6 ").setScore(3);
		objective.getScore("§9» §bRefill des Chests : ").setScore(2);
		objective.getScore("§5 ").setScore(1);
		objective.getScore(ChatColor.DARK_GRAY+ "-" + ChatColor.GRAY + "§m---------------" + ChatColor.WHITE + "-").setScore(0);
	}

	@Override
	public Scoreboard getMainScoreboard() {
		return scoreboard;
	}

	@Override
	public Scoreboard getNewScoreboard() {
		return null;
	}
	public void set() {
		player.setScoreboard(getMainScoreboard());
	}
	
	
	
	
}
