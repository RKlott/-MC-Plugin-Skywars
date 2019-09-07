package mq.xivklott.events;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.craftbukkit.v1_9_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import mq.xivklott.game.SkyWinner;
import mq.xivklott.main.SkyWars;
import mq.xivklott.main.SqlConnection;
import mq.xivklott.main.Title;
import net.minecraft.server.v1_9_R1.PacketPlayInClientCommand;
import net.minecraft.server.v1_9_R1.PacketPlayInClientCommand.EnumClientCommand;
//import net.minecraft.server.v1_9_R1.PacketPlayInChat;

public class SkyPvP implements Listener {
	
	private SqlConnection sql;
	public SkyPvP(SqlConnection sql) {
		this.sql = sql;
	}
	
	@EventHandler
	public void death(PlayerDeathEvent e) { 
		final Player p = e.getEntity();
		e.setDeathMessage("§7" + p.getName() + "§e est mort !");
		p.setGameMode(GameMode.SPECTATOR);
		SkyWars.getInstance().playersList.remove(p);
		new SkyWinner(sql).check();
		Bukkit.getScheduler().runTaskLater(SkyWars.getInstance(), new Runnable() {

			@Override
			public void run() {
				
				PacketPlayInClientCommand cmd = new PacketPlayInClientCommand(EnumClientCommand.PERFORM_RESPAWN);
				((CraftPlayer) p).getHandle().playerConnection.a(cmd);;
				Title.sendTitle(p, "§cGameOver :o", "", 25);
			}
			
		}, 5L);
	}
	

	
}
