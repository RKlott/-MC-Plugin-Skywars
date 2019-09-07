package mq.xivklott.chest;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.block.BlockState;
import org.bukkit.block.Chest;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;


public class ChestRefill {

	public void refillAllChests() {
		for(Chunk chunk : Bukkit.getWorld("world").getLoadedChunks()) {
			for(BlockState bs: chunk.getTileEntities()) {
				if(bs instanceof Chest) {
					
					Chest coffre = (Chest) bs.getBlock().getState();
					Inventory inv = coffre.getInventory();
					inv.clear();
					
					for(int i = 0; i < 5; i++) {
						ItemStack randomItem = ItemsRandom.getRandomItem();
						Random r = new Random();
						int limit = inv.getSize() - 1;
						int randomSlot = r.nextInt(limit);
						
						inv.setItem(randomSlot, randomItem);
					}
					
				}
			}
		}
	}
		
}
