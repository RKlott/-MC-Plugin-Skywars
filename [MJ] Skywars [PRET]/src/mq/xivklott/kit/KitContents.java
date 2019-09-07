package mq.xivklott.kit;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class KitContents {
	
	public ArrayList<ItemStack> getDefaultKit(){
		ArrayList<ItemStack> i = new ArrayList<>() ;
		i.add(get(Material.WOOD_PICKAXE, 1, (byte)0, "§aPioche", null, 0));
		i.add(get(Material.WOOD_AXE, 1, (byte)0, "§aHache", null, 0));
		i.add(get(Material.WOOD_SPADE, 1, (byte)0, "§aPelle", null, 0));

		return i;
	}
	
	public ArrayList<ItemStack> getGuerrierKit(){
		ArrayList<ItemStack> i = new ArrayList<>() ;
		i.add(get(Material.WOOD_SWORD, 1, (byte)0, "§aÉpée en Fer §7(Kits)", Enchantment.KNOCKBACK, 1));
		i.add(get(Material.CHAINMAIL_BOOTS, 1, (byte)0, "§aPaire de Botte §7(Kits)", null, 0));
		i.add(get(Material.LEATHER_CHESTPLATE, 1, (byte)0, "§aPlastron  §7(Kits)", null, 0));

		return i;
	}
	
	public ArrayList<ItemStack> getSnowballKit(){
		ArrayList<ItemStack> i = new ArrayList<>() ;
		i.add(get(Material.SNOW_BALL, 32, (byte)0, "§aBoule de Neige §7(Kits)", Enchantment.ARROW_KNOCKBACK, 1));
		i.add(get(Material.SNOW_BLOCK, 12, (byte)0, "§aBloc de Neige §7(Kits)", null, 0));
		i.add(get(Material.PUMPKIN, 1, (byte)0, "§aCitrouille §7(Kits)", null, 0));
		i.add(get(Material.STONE_SPADE, 1, (byte)0, "§aPelle de Neige §7(Kits)", Enchantment.LUCK, 1));

		return i;
	}
	
	
	public ArrayList<ItemStack> getTntKit(){
		ArrayList<ItemStack> i = new ArrayList<>() ;
		i.add(get(Material.TNT, 16, (byte)0, "§aT.n.T §7(Kits)", null, 0));
		i.add(get(Material.FLINT_AND_STEEL, 1, (byte)0, "§aBriquet §7(Kits)", Enchantment.ARROW_KNOCKBACK, 1));
		i.add(get(Material.IRON_LEGGINGS, 1, (byte)0, "§aJambières §7(Kits)", Enchantment.PROTECTION_EXPLOSIONS, 2));
		i.add(get(Material.LEATHER_HELMET, 1, (byte)0, "§aChapeau §7(Kits)", Enchantment.PROTECTION_PROJECTILE, 1));

		return i;
	}

	private ItemStack get(Material mat, int amount, byte data, String displayName, Enchantment ench, int enchLevel) {
		ItemStack i = new ItemStack(mat, amount, data);
		ItemMeta iM = i.getItemMeta();
		iM.setDisplayName(displayName);
		if(ench != null) {
			iM.addEnchant(ench, enchLevel, true);
		}
		i.setItemMeta(iM);
		return i;
	}
	
}
