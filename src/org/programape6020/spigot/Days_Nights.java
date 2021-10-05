package org.programape6020.spigot;

import org.bukkit.plugin.java.JavaPlugin;

public class Days_Nights extends JavaPlugin {
	 @Override
	 public void onEnable() {
		 System.out.println("Days Nights loaded successfully");
		 getServer().getPluginManager().registerEvents(new ServerListener(), this);
	 }
	    
	 @Override
	 public void onDisable() {
		 System.out.println("Days nights uninstalled successfully");
	 }
}
