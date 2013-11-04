package com.github.lyokofirelyte.WCAPI.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

import com.github.lyokofirelyte.WCAPI.WCEvent;

public class PlayerEmoteEvent extends WCEvent implements Cancellable {
	

    private static final HandlerList handlers = new HandlerList();
    private String emote;
    private String sentence;
    private boolean cancelled;
    private Player player;

    public PlayerEmoteEvent(String emote, Player p, String sentence) {
        this.emote = emote;
        this.sentence = sentence;
        player = p;
    }
 
    public boolean isCancelled() {
        return cancelled;
    }
 
    public void setCancelled(boolean cancel) {
        cancelled = cancel;
    }
    
    public void setSentence(String s){
    	sentence = s;
    }
    
    public void setEmote(String emote){
    	this.emote = emote;
    }
    
    public String getEmote(){
    	return emote;
    }
    
    public String getSentence(){
    	return sentence;
    }

    
    public Player getPlayer(){
    	return player;
    }
 
    public HandlerList getHandlers() {
        return handlers;
    }
 
    public static HandlerList getHandlerList() {
        return handlers;
    }
}