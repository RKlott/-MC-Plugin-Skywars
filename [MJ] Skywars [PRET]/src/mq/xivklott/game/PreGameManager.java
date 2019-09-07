package mq.xivklott.game;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import mq.xivklott.chest.ChestRefill;
import mq.xivklott.events.util.CagesUtil;
import mq.xivklott.kit.Kits;
import mq.xivklott.main.SkyWars;
import mq.xivklott.main.Title;

public class PreGameManager {
	
	
	static int timer = 5;
	int task;
	
	
	public PreGameManager() {
		task = Bukkit.getScheduler().scheduleSyncRepeatingTask(SkyWars.getInstance(), new Runnable() {
		
			@Override
			public void run() {
				
				timer--;
				
				if(timer == 5 || timer == 4 || timer == 3 || timer == 2 || timer == 1) {
					for(Player pl : Bukkit.getOnlinePlayers()) {
						
						Title.sendTitle(pl, "§c" + timer + "s", "§ePréparez vous", 20);
					}
				}
				
				for(Player p : Bukkit.getOnlinePlayers()) {
					p.setLevel(timer);
				}
				
				if (timer == 0) {
					GameState.setState(GameState.GAME);
					for(Player pl : Bukkit.getOnlinePlayers()) {
						Title.sendTitle(pl, "§cLancement du Jeu !", "§eBonne Chance !", 20);
						
						
						Kits playerKit = SkyWars.getInstance().kits.get(pl);
						ArrayList<ItemStack> itemsdukit = playerKit.getItems();
						pl.getInventory().clear();
						for(ItemStack item : itemsdukit) {
							pl.getInventory().addItem(item);
						}
						
						
					}
					Bukkit.getScheduler().cancelTask(task);
					
					CagesUtil.destroyAllCages();
					new ChestRefill().refillAllChests(); 
					new GameManager();
				}
				
			}
	
		}, 20, 20);	
	}
	
}
