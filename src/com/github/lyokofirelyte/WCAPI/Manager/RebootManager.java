package com.github.lyokofirelyte.WCAPI.Manager;

import org.bukkit.Bukkit;

import com.github.lyokofirelyte.WCAPI.WCAPI;


public class RebootManager {
	
	WCAPI pl;
    
	public RebootManager(WCAPI instance){
	pl = instance;
	}
	
	public String WC = "§dWC §5// §d";

	
	long delay = 0L;
	
	public void scheduleReboot(){
		
    	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(pl, new Runnable(){
        public void run(){
        	Bukkit.broadcastMessage(WC + "The server has been running successfully for two minutes so we've automatically scheduled the next reboot for 24 hours from now.");
        }
        }
        , 2400L);	
    	
    	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(pl, new Runnable(){
        public void run(){
        	  wcReboot();
        }
        }
        , 1728000);	
	}

	public void wcReboot(){

		Bukkit.broadcastMessage(WC + "The server will be executing the daily reboot in 5 minutes.");
		
		for (int x = 5; x > 0; x--){
		
			delay = delay + 1200L;
			
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(pl, new Runnable(){
		    public void run() {
		    	Bukkit.broadcastMessage(WC + "The server will be executing the daily reboot in less than 5 minutes.");
		    }
		    }
		    , delay);
			
			if (x == 1){
				
				delay = delay + 1200L;
				
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(pl, new Runnable(){
			    public void run(){
			    	Bukkit.broadcastMessage(WC + "The server is rebooting. Don't worry, we've saved the world! See you in 60.");
			    	Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "stop");
			    }
			    }
			    , delay);
			}
		}
	}
}
