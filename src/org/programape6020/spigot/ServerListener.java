package org.programape6020.spigot;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import java.util.Date;
import java.text.SimpleDateFormat;

public class ServerListener implements Listener {
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		//Get player ID and send time information
		Player player_join = event.getPlayer();
		String player_name = player_join.getName().toString();
		player_join.sendMessage("Welcome " + player_name + "to the server.");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//Set date format
        player_join.sendMessage("Now is " + df.format(new Date()));
	}
}
