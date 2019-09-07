package mq.xivklott.oremanager;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class IronOre implements Listener {

	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		Block block = e.getBlock();
		Location bLoc = block.getLocation();

		if(block.getType() == Material.IRON_ORE) {
			e.setCancelled(true);
			block.setType(Material.AIR);
		int r = new Random().nextInt(24);

		 switch (r) {
		case 0:
			block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.IRON_HELMET));
			break;
		case 1:
			block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.IRON_CHESTPLATE));
			break;
		case 2:
			block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.IRON_LEGGINGS));
			break;
		 case 3:
			 block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.IRON_BOOTS));
	       break;
		 case 4:
			 block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.IRON_SWORD));
			break;
			case 5:
				block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.GOLD_HELMET));
				break;
			case 6:
				block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.GOLD_CHESTPLATE));
				break;
			case 7:
				block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.GOLD_LEGGINGS));
				break;
			 case 8:
				 block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.GOLD_BOOTS));
		       break;
			 case 9:
				 block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.GOLD_SWORD));
				break;
			 case 10:
					block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.LEATHER_HELMET));
					break;
				case 11:
					block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.LEATHER_CHESTPLATE));
					break;
				case 12:
					block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.LEATHER_LEGGINGS));
					break;
				 case 13:
					 block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.LEATHER_BOOTS));
			       break;
				 case 14:
					 block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.WOOD_SWORD));
					break;
				 case 15:
						block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.CHAINMAIL_HELMET));
						break;
					case 16:
						block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.CHAINMAIL_CHESTPLATE));
						break;
					case 17:
						block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.CHAINMAIL_LEGGINGS));
						break;
					 case 18:
						 block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.CHAINMAIL_BOOTS));
				       break;
					 case 19:
						 block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.STONE_SWORD));
						break;
					 case 20:
						 block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.IRON_INGOT, 12));
					 case 21:
						 block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.COAL, 12));
					 case 22:
						 block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.GOLD_INGOT, 12));
					 case 23:
						 block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.WOOD, 32));
						
					
		
	}
		}
	}
}


