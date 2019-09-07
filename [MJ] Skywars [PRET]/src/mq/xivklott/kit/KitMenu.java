package mq.xivklott.kit;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class KitMenu implements Listener {
	
	private Inventory inv;
	
	public KitMenu() {
		this.inv = Bukkit.createInventory(null, 18, "§5§lKITS");
		this.inv.setItem(Kits.GUERRIER.getSlot(), Kits.GUERRIER.getItem());
		this.inv.setItem(Kits.SNOWBALL.getSlot(), Kits.SNOWBALL.getItem());
		this.inv.setItem(Kits.TNT.getSlot(), Kits.TNT.getItem());
		this.inv.setItem(Kits.DEFAULT.getSlot(), Kits.DEFAULT.getItem());
		
	}
	
	public ItemStack Chest() {
		ItemStack is = new ItemStack(Material.CHEST, 1);
	    ItemMeta metachest = is.getItemMeta();
	    metachest.setDisplayName("§bMenu des Kits §7§m|§e Clique droit pour ouvrir");
	    is.setItemMeta(metachest);
	    return is;
	}
	
	@EventHandler
	public void join(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		p.getInventory().clear();
		p.getInventory().setItem(0, new ItemStack(Chest()));
		p.updateInventory();
	
	}
	
	@EventHandler
	public void interact(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		ItemStack i = e.getItem();
		
		if(i != null && i.getType() != null && i.getType() == Material.CHEST) {
			p.openInventory(inv);
		}
		
	}
	
	@EventHandler
	public void clickInventory(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		Inventory inv = e.getInventory();
		ItemStack current = e.getCurrentItem();
		
		if(inv.getName().equalsIgnoreCase("§5§lKITS")) {
			if(current == null) return;
			e.setCancelled(true);
			p.closeInventory();
			if(current.getType() == Kits.GUERRIER.getIcon().getType()) {
				Kits.GUERRIER.add(p);
				
			} else if(current.getType() == Kits.SNOWBALL.getIcon().getType()) {
				Kits.SNOWBALL.add(p);
				
			} else if(current.getType() == Kits.TNT.getIcon().getType()) {
				Kits.TNT.add(p);
				
			} else if(current.getType() == Kits.DEFAULT.getIcon().getType()) {
				Kits.DEFAULT.add(p);
				
			} else {
				Kits.DEFAULT.add(p);
			}
		}
		
	}
}
