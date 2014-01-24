package com.github.lyokofirelyte.WCAPI;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;

abstract public class WCEvent extends Event {
	
	/* Represents a custom WC event - these are required for a WC approved event along with handlers.
	 * All events must contain a get() and set() for every variable so that they can be intercepted! */
	
	public abstract Player getPlayer();
	
	public abstract void setPlayer(Player p);
	
    public abstract void setCancelled(boolean cancel);
    
    public abstract boolean isCancelled();
}