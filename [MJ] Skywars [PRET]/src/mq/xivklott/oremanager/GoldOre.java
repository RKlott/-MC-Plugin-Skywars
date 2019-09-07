package mq.xivklott.oremanager;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class GoldOre implements Listener {
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		Block block = e.getBlock();
		Location bLoc = block.getLocation();

		if(block.getType() == Material.GOLD_ORE) {
			e.setCancelled(true);
			block.setType(Material.AIR);
		int r = new Random().nextInt(4);

		 switch (r) {
		case 0:
			block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.ARROW));
			break;
		case 1:
			block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.APPLE));
			break;
		 case 2:
			 block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.GOLD_SWORD));
	       break;
		 case 3:
			 block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.BOW));

	}
		}
	}
}

