package mq.xivklott.events.util;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import mq.xivklott.main.SkyWars;

public class Locations {
	
	public static ArrayList<Location> cages = new ArrayList<>();
	
	public Locations() {
		World w = Bukkit.getWorld("world"); //8 JOUEURS
		cages.add(new Location(w, 256.300, 86, 215.535));
		cages.add(new Location(w, 247.408, 86, 207.560));
		cages.add(new Location(w, 221.515, 86, 208.549));
		cages.add(new Location(w, 214.586, 86, 217.626));
		cages.add(new Location (w, 214.530, 86, 243.401));
		cages.add(new Location (w, 223.605, 86, 250.357));
		cages.add(new Location (w, 249.482, 86, 250.325));
		cages.add(new Location (w, 256.437, 86, 241.600));
	}
	
	public static void teleportPlayers() {
		for(int i = 0; i < SkyWars.getInstance().playersList.size(); i++) {
			
			Player player = SkyWars.getInstance().playersList.get(i);
			Location cage = cages.get(i);
			player.teleport(cage);
		}
	}
	
}
