package mq.xivklott.chest;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class ItemsRandom {
	
	public static ArrayList<ItemStack> itemList = new ArrayList<>();
	
	public ItemsRandom() {
		itemList.add(getItem(null, Material.STONE_SWORD, 1, 0, Enchantment.DAMAGE_ALL, 2));
		itemList.add(getItem(null, Material.GOLDEN_APPLE, 1, 1, null, 0));
		itemList.add(getItem(null, Material.GOLD_CHESTPLATE, 1, 0, null, 0));
		itemList.add(getItem(null, Material.STONE, 32, 0, null, 0));
		itemList.add(getItem(null, Material.CHAINMAIL_HELMET, 1, 0, null, 0));
		itemList.add(getItem(null, Material.CHAINMAIL_CHESTPLATE, 1, 0, null, 0));
		itemList.add(getItem(null, Material.TNT, 5, 0, null, 0));
		itemList.add(getItem(null, Material.COOKED_BEEF, 16, 0, null, 0));
		itemList.add(getItem(null, Material.LOG, 24, 0, null, 0));
		itemList.add(getItem(null, Material.LEATHER_LEGGINGS, 1, 0, Enchantment.PROTECTION_EXPLOSIONS, 2));
		itemList.add(getItem(null, Material.LEATHER_HELMET, 1, 0, null, 0));
		itemList.add(getItem(null, Material.DIRT, 32, 0, null, 0));
		itemList.add(getItem(null, Material.IRON_HELMET, 1, 0, null, 0));
		itemList.add(getItem(null, Material.LEATHER_BOOTS, 1, 0, null, 0));
		itemList.add(getItem(null, Material.STONE_SWORD, 1, 0, Enchantment.DAMAGE_ALL, 1));
		itemList.add(getItem(null, Material.IRON_SWORD, 1, 0, null, 0));
		itemList.add(getItem(null, Material.GOLDEN_APPLE, 1, 0, null, 0));
		itemList.add(getItem(null, Material.WATER_BUCKET, 1, 0, null, 0));
		itemList.add(getItem(null, Material.FISHING_ROD, 1, 0, null, 0));
		itemList.add(getItem(null, Material.DIAMOND_SWORD, 1, 0, null, 0));
		
		
	}
	
	public static ItemStack getRandomItem() {
		
		int listlimit = itemList.size() -1;
		Random r = new Random();
		int alea = r.nextInt(listlimit);
		
		return itemList.get(alea);
		
	}

	private ItemStack getItem(String displayName, Material mat, int amount, int data, Enchantment ench, int enchLevel) {
		
		ItemStack i = new ItemStack(mat, amount, (byte)data);
		ItemMeta iM = i.getItemMeta();
		iM.setDisplayName(displayName);
		
		if(ench != null && enchLevel != 0) {
			iM.addEnchant(ench, enchLevel, true);
		}
		i.setItemMeta(iM);
		return i;
	}
	
}
