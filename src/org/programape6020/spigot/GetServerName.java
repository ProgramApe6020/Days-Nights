package org.programape6020.spigot;

import org.bukkit.plugin.java.JavaPlugin;

public class GetServerName extends JavaPlugin {
	String ServerName = GetServerName.super.getConfig().getString("server_name");
	public String GetName() {
		return ServerName;
	}
}
