package com.github.lyokofirelyte.WCAPI.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

import com.github.lyokofirelyte.WCAPI.WCEvent;

public class ScoreboardUpdateEvent extends WCEvent implements Cancellable {
	

    private static final HandlerList handlers = new HandlerList();
    private Player p;
    private boolean cancelled;
    private Boolean forced;

    public ScoreboardUpdateEvent(Player p, Boolean forced) {
        this.p = p;
        this.forced = forced;
    }
    
    public void setPlayer(Player p){
    	this.p = p;
    }
 
    public void setCancelled(boolean cancel) {
        cancelled = cancel;
    }
    
    public boolean isCancelled() {
        return cancelled;
    }

    public Player getPlayer(){
    	return p;
    }

    public Boolean getForced(){
    	return forced;
    }
    
    public void setForced(Boolean a){
    	forced = a;
    }
 
    public HandlerList getHandlers() {
        return handlers;
    }
 
    public static HandlerList getHandlerList() {
        return handlers;
    }
}