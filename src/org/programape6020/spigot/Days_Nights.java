package org.programape6020.spigot;

import org.bukkit.plugin.java.JavaPlugin;

public class Days_Nights extends JavaPlugin {
	 //Load plugin execution
	 @Override
	 public void onEnable() {
		 System.out.println("Days Nights loaded successfully");
		 //Register event listener
		 getServer().getPluginManager().registerEvents(new ServerListener(), this);
	 }
	 //Disable plugin execution
	 @Override
	 public void onDisable() {
		 System.out.println("Days nights uninstalled successfully");
	 }
}
