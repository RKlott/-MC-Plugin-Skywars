package mq.xivklott.game;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import mq.xivklott.main.SkyWars;
import mq.xivklott.main.SqlConnection;

public class SkyWinner {
	
	SqlConnection sql;
	SkyWars main;
	public SkyWinner(SqlConnection sql) {
		this.sql = sql;
	}
	
	public SkyWinner(SkyWars main) {
		this.main = main;
	}
	

	public void check() {
		if(SkyWars.getInstance().playersList.size() == 0 && GameState.isState(GameState.GAME)) {
			
			GameState.setState(GameState.FINISH);
			Bukkit.spigot().restart();
			
		}
		if(SkyWars.getInstance().playersList.size() == 1) {

			GameState.setState(GameState.FINISH);
			
			//Player winner = players.get(0);
			Player p = SkyWars.getInstance().playersList.get(0).getPlayer();
			Bukkit.broadcastMessage(SkyWars.getInstance().coloration("&b&lGrand gagnant &7: &1&k!&b&k!&1&k!&f&l&f&l " + SkyWars.getInstance().playersList.get(0).getPlayer().getName() + "&1&k !&b&k!&1&k!"));
			
			Bukkit.broadcastMessage("§aRemise des prix ! Téléportation au Hub dans quelques secondes..");
			
			for(Player player : Bukkit.getOnlinePlayers()) {
				
				
				sql.addMoney(player, 25);
				player.sendMessage("§eTu as gagné 25coins en terminant cette partie !");
				
				sql.addMoney(p, 75);
				player.sendMessage("§eTu as gagné 100 coins en remportant cette partie ! Bien joué !");
				
				Bukkit.broadcastMessage("§7Téléportation au lobby en cours...");
				main.Lobbytp(player);
				
				
			}
			Bukkit.spigot().restart();
		}
	}
	
}
