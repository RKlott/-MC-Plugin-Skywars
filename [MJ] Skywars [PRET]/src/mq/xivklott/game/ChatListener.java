package mq.xivklott.game;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

@SuppressWarnings("deprecation")
public class ChatListener implements Listener {
	
	  @EventHandler
	  public void onChat(PlayerChatEvent e)
	  {
		  Player p = e.getPlayer();
		  e.setFormat(ChatColor.GOLD + p.getName() + ChatColor.GRAY+ " §l» " + ChatColor.YELLOW +e.getMessage());
		  p.setPlayerListName("§6 "+p.getName());

	  }
	  

}
