package mq.xivklott.oremanager;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class LapisLazuliOre implements Listener {

	

	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		Block block = e.getBlock();
		Location bLoc = block.getLocation();

		if(block.getType() == Material.LAPIS_ORE) {
			e.setCancelled(true);
			block.setType(Material.AIR);
		int r = new Random().nextInt(6);

		 switch (r) {
		case 0:
			block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.EXP_BOTTLE, 32));
			block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.LAPIS_BLOCK, 4));
			block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.IRON_PICKAXE));
			break;
		case 1:
			block.getWorld().dropItemNaturally(bLoc, EnchantedBook1());
			break;
		case 2:
			block.getWorld().dropItemNaturally(bLoc, EnchantedBook2());
			break;
		 case 3:
			 block.getWorld().dropItemNaturally(bLoc, EnchantedBook3());
	       break;
		 case 4:
			 block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.CAULDRON_ITEM));
			break;
		 case 5:
			 block.getWorld().dropItemNaturally(bLoc, new ItemStack(Material.CACTUS, 5));
			 break;
	}
		}
	}

	private ItemStack EnchantedBook1() {
		ItemStack isbook1 = new ItemStack(Material.BOOK, 1);
		ItemMeta metabook1 = isbook1.getItemMeta();
		metabook1.setDisplayName("§c§lLivre Enflammé");
		metabook1.addEnchant(Enchantment.FIRE_ASPECT, 1, true);
		ArrayList <String> book1 = new ArrayList<>();
		book1.add("§f§l<->§f§l§m---§f§l<X>§f§l§m---§f§l<->");
		book1.add("§eEnchantement :");
		book1.add("  §cAura de Feu I");
		metabook1.setLore(book1);
		isbook1.setItemMeta(metabook1);
		return isbook1;
	}
	
	private ItemStack EnchantedBook2() {
		ItemStack isbook2 = new ItemStack(Material.BOOK, 1);
		ItemMeta metabook2 = isbook2.getItemMeta();
		metabook2.setDisplayName("§9§lLivre de Repoussement");
		metabook2.addEnchant(Enchantment.KNOCKBACK, 1, true);
		ArrayList <String> book2 = new ArrayList<>();
		book2.add("§f§l<->§f§l§m---§f§l<X>§f§l§m---§f§l<->");
		book2.add("§eEnchantement :");
		book2.add("  §9Knockback I");
		book2.add("");
		book2.add("");
		metabook2.setLore(book2);
		isbook2.setItemMeta(metabook2);
		return isbook2;
	}
	
	private ItemStack EnchantedBook3() {
		ItemStack isbook3 = new ItemStack(Material.BOOK, 2);
		ItemMeta metabook3 = isbook3.getItemMeta();
		metabook3.setDisplayName("§4§lLivre de Protection anti flamèche");
		metabook3.addEnchant(Enchantment.PROTECTION_FIRE, 1, true);
		ArrayList <String> book3 = new ArrayList<>();
		book3.add("§f§l<->§f§l§m---§f§l<X>§f§l§m---§f§l<->");
		book3.add("§eEnchantement :");
		book3.add("  §4Protection contre le Feu I");
		book3.add("");
		book3.add("");
		book3.add("");
		metabook3.setLore(book3);
		isbook3.setItemMeta(metabook3);
		return isbook3;
	}
}
