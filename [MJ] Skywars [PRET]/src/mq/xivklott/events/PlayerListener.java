package mq.xivklott.events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.world.PortalCreateEvent;

import mq.xivklott.game.GameState;

public class PlayerListener implements Listener {
	
	@EventHandler
	public void place(BlockPlaceEvent e) {
		if(GameState.isState(GameState.LOBBY) || (GameState.isState(GameState.PREGAME))){
			e.setCancelled(true);
		}
		if(e.getBlock().getType() == Material.CHEST) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void breake(BlockBreakEvent e) {
		if(GameState.isState(GameState.LOBBY) || (GameState.isState(GameState.PREGAME))){
			e.setCancelled(true);
		} else if(e.getBlock().getType() == Material.GLASS) {
			if(GameState.isState(GameState.GAME)) {
				e.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void damage(EntityDamageEvent e) {
		if(GameState.isState(GameState.LOBBY) || (GameState.isState(GameState.PREGAME))){
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void portalCreate(PortalCreateEvent e) {
		e.setCancelled(true);
	}
	
	@EventHandler
	public void spawnMob(CreatureSpawnEvent e) {
		e.setCancelled(true);
	}
}
