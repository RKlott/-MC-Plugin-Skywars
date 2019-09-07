package mq.xivklott.oremanager;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class EmeraldOre implements Listener {
	

	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		Block block = e.getBlock();
		Location bLoc = block.getLocation();

		if(block.getType() == Material.EMERALD_ORE) {
			e.setCancelled(true);
			block.setType(Material.AIR);
		int r = new Random().nextInt(4);

		 switch (r) {
		case 0:
			block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.ENDER_PEARL, 4));
			break;
		case 1:
			block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.POTION, 3));
			break;
		case 2:
			block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.TNT, 6));
			block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.FLINT_AND_STEEL));
			break;
		 case 3:
			 block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.GOLDEN_APPLE));
	       break;
	}
		}
	}
}