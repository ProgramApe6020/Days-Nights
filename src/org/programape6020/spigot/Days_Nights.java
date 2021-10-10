package org.programape6020.spigot;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.GameRule;

public class Days_Nights extends JavaPlugin {
	 //Load plugin execution
	 @Override
	 public void onEnable() {
		 System.out.println("Days Nights loaded successfully");
		 World world = Bukkit.getWorld(getName());
		 //Set game time stop
		 world.setGameRule(GameRule.DO_DAYLIGHT_CYCLE, false);
		 //Register event listener
		 getServer().getPluginManager().registerEvents(new ServerListener(), this);
		 getServer().getPluginManager().registerEvents(new TimeManager(), this);
	 }
	 //Disable plugin execution
	 @Override
	 public void onDisable() {
		 System.out.println("Days nights uninstalled successfully");
	 }
}
