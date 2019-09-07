package mq.xivklott.events;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import mq.xivklott.events.util.CustomScoreboardManager;
import mq.xivklott.events.util.Locations;
import mq.xivklott.events.util.ScoreboardsRunnable;
import mq.xivklott.game.GameState;
import mq.xivklott.game.PreGameManager;
import mq.xivklott.game.SkyWinner;
import mq.xivklott.main.SkyWars;
import mq.xivklott.main.SqlConnection;
import mq.xivklott.main.Title;

public class SkyJoin implements Listener {
	 
	int timer = 15;
	int task;
	public static HashMap<Player, CustomScoreboardManager> sb = new HashMap<>();
	private SkyWars main;
	private SqlConnection sql;
	
	public SkyJoin(SkyWars main) { 
		this.main = main;
	} 
	
	public SkyJoin(SqlConnection sql) {
		this.sql = sql;
	}

	@EventHandler 
	public void join(PlayerJoinEvent e) {
		
		Player p = e.getPlayer();
		p.setMaxHealth(40.0D);
		p.setHealth(40.0D);
		p.setFoodLevel(20);
		p.getInventory().setHelmet(null);
		p.getInventory().setChestplate(null);
		p.getInventory().setLeggings(null);
		p.getInventory().setBoots(null);
		p.getInventory().clear();
		p.teleport(Bukkit.getWorlds().get(0).getSpawnLocation()); //lobby
		if(!GameState.isState(GameState.LOBBY)) {
			p.setGameMode(GameMode.SPECTATOR);
			p.sendMessage("Vous êtes spectateur.");
			return;
		}
		
		if(!SkyWars.getInstance().playersList.contains(p)) {
			p.setGameMode(GameMode.SURVIVAL);
			SkyWars.getInstance().playersList.add(p);
			e.setJoinMessage("§7"+p.getName() + " §ea rejoint la partie ! §7["+main.playersList.size()+"/8]");
			
			Title.sendTitle(p, "§eSkyWars", "§cBienvenue", 40);
			
			new ScoreboardsRunnable().runTaskTimer(SkyWars.getInstance(), 0L, 20L);
			CustomScoreboardManager scoreboard = new CustomScoreboardManager(p);
			scoreboard.sendLine();
			scoreboard.set();
			
			if(SkyWars.getInstance().playersList.size() == 6) {
			
				task = Bukkit.getScheduler().scheduleSyncRepeatingTask(SkyWars.getInstance(), new Runnable() {

					@Override
					public void run() {
						
						timer--;
						
						for(Player pl : Bukkit.getOnlinePlayers()) {
							pl.setLevel(timer);
						}
						
						if(timer == 15 || timer == 10 || timer == 5 || timer == 4 || timer == 3 || timer == 2 || timer == 1) {
							for(Player pl : Bukkit.getOnlinePlayers()) {
								Title.sendTitle(pl, "§c" + timer + "s", "§ePréparez vous", 20);
							}
						}
						
						if(timer == 0) {
							for(Player pl : Bukkit.getOnlinePlayers()) {
								Title.sendTitle(pl, "§cTéléportation... !", " ", 20);
							}
							Bukkit.getScheduler().cancelTask(task);
							GameState.setState(GameState.PREGAME);
							Locations.teleportPlayers();
							new PreGameManager();
						}
						
					}
					
				}, 20, 20);
				
			}
		}
		
	}
	
	@EventHandler 
	public void quit(PlayerQuitEvent e) {
		
		Player p = e.getPlayer(); 
		e.setQuitMessage(null);
		if(SkyWars.getInstance().playersList.contains(p)) {
			SkyWars.getInstance().playersList.remove(p);
		}
		
		new SkyWinner(sql).check();
		
	}
	
}
