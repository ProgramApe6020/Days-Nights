package org.programape6020.spigot;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServerListener implements Listener {
	GetServerName server;
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		//Clear the original online prompt
		event.setJoinMessage(null);
		//Get player ID and send time information
		Player player_join = event.getPlayer();
		String player_name = player_join.getName().toString();
		String ServerName = server.GetName();
		Bukkit.broadcastMessage("[" + ServerName + "]:Welcome " + player_name + " to the server.");	//Send Message
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");		//Set date format
		Bukkit.broadcastMessage("[" + ServerName + "]:Now is " + df.format(new Date()));				//Send Message
	}
}
