package mq.xivklott.oremanager;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class DiamondOre implements Listener {
	

	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		Block block = e.getBlock();
		Location bLoc = block.getLocation();

		if(block.getType() == Material.DIAMOND_ORE) {
			e.setCancelled(true);
			block.setType(Material.AIR);
		int r = new Random().nextInt(16);

		 switch (r) {
		case 0:
			block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.DIAMOND_HELMET));
			break;
		case 1:
			block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.DIAMOND_CHESTPLATE));
			break;
		case 2:
			block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.DIAMOND_LEGGINGS));
			break;
		 case 3:
			 block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.DIAMOND_BOOTS));
	       break;
		 case 4:
			 block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.DIAMOND_SWORD));
			break;
		 case 5:
			 block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.DIAMOND_BLOCK, 5));
			 break;
	}
		}
	}
}
