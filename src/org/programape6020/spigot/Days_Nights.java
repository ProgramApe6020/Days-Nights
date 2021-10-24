package org.programape6020.spigot;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.GameRule;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Days_Nights extends JavaPlugin {
	 public static JavaPlugin plugin;
	 static Map<World, Boolean> addDay = new HashMap<>();
	//Load plugin execution
	 @Override
	 public void onEnable() {
		 plugin = this;
	     this.saveDefaultConfig();
		 System.out.println("Days Nights loaded successfully");
		 String WorldName = Days_Nights.super.getConfig().getString("world");	 
		 World world = Bukkit.getWorld(WorldName);
		 //Register event listener
		 getServer().getPluginManager().registerEvents(new ServerListener(), this);
		//Set game time stop
		 world.setGameRule(GameRule.DO_DAYLIGHT_CYCLE, false);
		 Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, () -> {
			 if (!addDay.containsKey(world))
				 addDay.put(world, true);
			 Calendar c = Calendar.getInstance();
			 int hour = c.get(Calendar.HOUR_OF_DAY);  	//Get the current hour
			 int minute = c.get(Calendar.MINUTE);  		//Get the current minute
			 int second = c.get(Calendar.SECOND);  		//Get the current second
			 if(hour<6)
				 hour+=18;  							//hour = hour + 24 - 6
			 else
                hour-=6;
	         double milliHour = (minute * 60 + second) / 3.6;
	         int time = (int) (hour * 1000 + milliHour);
             if (time == 0 && addDay.get(world)) {
                 time = 24000;
                 addDay.put(world, false);
             }else if (time != 0)
                 addDay.put(world, true);
             long nowTime = world.getTime();
             long nowFullTime = world.getFullTime();
             long newFullTime = nowFullTime + time - nowTime;
             world.setFullTime(newFullTime);
		 }, 0L, 5L);
	 }
	 //Disable plugin execution
	 @Override
	 public void onDisable() {
		 System.out.println("Days nights uninstalled successfully");
	 }
}
