package mq.xivklott.events.util;

import org.bukkit.Location;
import org.bukkit.Material;

public class CagesUtil {

	public static void destroyAllCages() {
		for(Location allCages : Locations.cages) {
			Location glass = allCages.add(0, -1, 0);

			glass.getBlock().setType(Material.AIR);
		}
	}

}
