package mq.xivklott.events;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

import mq.xivklott.game.ChatListener;
import mq.xivklott.kit.KitMenu;
import mq.xivklott.main.SkyWars;
import mq.xivklott.main.SqlConnection;

public class EventsManager {

	public SkyWars pl;
	private SqlConnection sql;
	
	public EventsManager(SkyWars skyWars) {
		
		this.pl = skyWars;
		
		
	}
	
	public EventsManager(SqlConnection sql) {
		this.sql = sql;
	}

	public void registerEvents() {
		
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new SkyJoin(pl), pl);
		pm.registerEvents(new PlayerListener(), pl);
		pm.registerEvents(new SkyPvP(sql), pl);
		pm.registerEvents(new KitMenu(), pl);
		pm.registerEvents(new ChatListener(), pl);
		
	}
	
	
	
}
