package com.github.lyokofirelyte.WCAPI.Events;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

import com.github.lyokofirelyte.WCAPI.WCEvent;

public class SpleefPlayerFallEvent extends WCEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    public boolean cancelled = false;
    
    Player player;
    Player spleefer;
    
    public SpleefPlayerFallEvent(Player p){
    	player = p;
    	findSpleefer();
    }
    
    public HandlerList getHandlers() {
        return handlers;
    }
 
    public static HandlerList getHandlerList() {
        return handlers;
    }
    
    public boolean isCancelled(){
    	return cancelled;
    }

	public void setCancelled(boolean a) {
		cancelled = a;
	}
	
	public void setPlayer(Player a){
		player = a;
	}
	
	public Player getPlayer(){
		return player;
	}
	
	public Player getSpleefer(){
		return spleefer;
	}
	
	public void findSpleefer(){
		
		String p = "meh";
		
		for (Entity e : player.getNearbyEntities(10D, 3D, 10D)){
			if (e instanceof Player){
				p = ((Player)e).getName();
				spleefer = ((Player)e);
			}
		}
		
		if (p.equals("meh")){
			for (Entity e : player.getNearbyEntities(25D, 3D, 25D)){
				if (e instanceof Player){
					p = ((Player)e).getName();
					spleefer = ((Player)e);
				}
			}
		}
		
		if (p.equals("meh")){
			spleefer = player;
		}
	}
}