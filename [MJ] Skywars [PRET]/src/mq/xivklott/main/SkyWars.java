package mq.xivklott.main;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import mq.xivklott.chest.ItemsRandom;
import mq.xivklott.events.EventsManager;
import mq.xivklott.events.util.Locations;
import mq.xivklott.game.GameState;
import mq.xivklott.kit.KitContents;
import mq.xivklott.kit.KitMenu;
import mq.xivklott.kit.Kits;

public class SkyWars extends JavaPlugin{
	
	public KitContents kitContents = new KitContents();
	public HashMap<Player, Kits> kits = new HashMap<>();
	public SqlConnection sql;
	public ArrayList<Player> playersList = new ArrayList<>();
	ByteArrayDataOutput out = ByteStreams.newDataOutput();
	public static SkyWars instance;
	
	public static SkyWars getInstance() {
		return instance;
	}
	
	@Override
	public void onEnable() {	
		super.onEnable();
		instance = this;
		GameState.setState(GameState.LOBBY);
		new EventsManager(this).registerEvents();
		new Locations();
		new KitMenu();
		new ItemsRandom();
		sql = new SqlConnection("jdbc:mysql://", "127.0.0.1 <- Adresse PhpMyAdmin", "BaseDeDonnée","Identifiant", "MotDePasse");
		sql.connection();
		getConfig().options().copyDefaults(true);
		saveDefaultConfig();
		getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		getServer().dispatchCommand(getServer().getConsoleSender(), "save-off");
	}
	
	@Override
	public void onDisable() {
		getServer().dispatchCommand(getServer().getConsoleSender(), "save-off");
		sql.disconnect();

			
		}
	
	public void Lobbytp(Player player) {
		out.writeUTF("Connect");
		out.writeUTF("lobby");
		player.sendPluginMessage((Plugin)this, "BungeeCord", out.toByteArray());
	}

	
	public String coloration(String msg)
	{
		String coloredMsg = "";
		for (int i = 0; i < msg.length(); i++) {
			if (msg.charAt(i) == '&')
				coloredMsg += '§';
			else
				coloredMsg += msg.charAt(i);
		}
		return coloredMsg;
	}
	
}
