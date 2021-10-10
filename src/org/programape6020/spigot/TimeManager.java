package org.programape6020.spigot;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import java.util.Date;

public class TimeManager extends Event implements Listener{
    private static final HandlerList handlers = new HandlerList();
    public int getTimeSec(String time) {
    	int hour = Integer.parseInt(time.substring(0, 2));
        int min = Integer.parseInt(time.substring(3, 5));
        int sec = Integer.parseInt(time.substring(6, 8));
        return hour * 60 * 60 + min * 60 + sec;
    }
    public long convertTime() {
        String time = (new Date()).toString().substring(11, 19);
        int timeInSec = (int)(getTimeSec(time) / 3.6D);
        int mcTime = 0;
        if (timeInSec - 6000 < 0) {
          mcTime = timeInSec + 24000 - 6000;
        } else {
          mcTime = timeInSec - 6000;
        } 
        return mcTime;
      }
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
    public static HandlerList getHandlerList() {
        return handlers;
    }
    public boolean TimeChange() {
    	return true;
    }
    @EventHandler
    public void TimeSet() {
    	if(TimeChange() == true) {
    		
    	}
    }
}