package mq.xivklott.game;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import mq.xivklott.chest.ChestRefill;
import mq.xivklott.main.SkyWars;
import mq.xivklott.main.Title;

public class GameManager {

	int task;
	public static int timer = 180;
	
	public GameManager() {
		
		task = Bukkit.getScheduler().scheduleSyncRepeatingTask(SkyWars.getInstance(), new Runnable() {

			@Override
			public void run() {

				timer--;
				
				if(timer == 0) {
					
					for(Player pl : Bukkit.getOnlinePlayers()) {
						Title.sendTitle(pl, "§cRefill des Chests", "", 25);
					}
					new ChestRefill().refillAllChests();
					Bukkit.getScheduler().cancelTask(task);
					return;
				}
				
				
			}
			
		}, 20, 20);
	}
	
}
