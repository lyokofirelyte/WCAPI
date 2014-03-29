package com.github.lyokofirelyte.WCAPI.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

import com.github.lyokofirelyte.WCAPI.WCEvent;
import com.github.lyokofirelyte.WCAPI.JSON.JSONChatMessage;
import com.github.lyokofirelyte.WCAPI.Manager.WCMessageType;

public class WCPluginMessageEvent extends WCEvent implements Cancellable {
	
    private static final HandlerList handlers = new HandlerList();
    private Player p;
    private String message;
    private JSONChatMessage jsonMessage;
    private WCMessageType type;
    private boolean cancelled;

    public WCPluginMessageEvent(Player p, WCMessageType type, String message) {
        this.p = p;
        this.type = type;
        this.message = message;
        jsonMessage = new JSONChatMessage(message, null, null);
    }
    
    public WCPluginMessageEvent(WCMessageType type, String message){
    	this.type = type;
    	this.message = message;
        jsonMessage = new JSONChatMessage(message, null, null);
    }
    
    public WCPluginMessageEvent(Player p, WCMessageType type, JSONChatMessage json){
    	this.p = p;
    	this.message = json.toString();
    	this.type = type;
    	jsonMessage = json;
    }
    
    public WCPluginMessageEvent(WCMessageType type, JSONChatMessage json){
    	this.type = type;
    	this.message = json.toString();
    	jsonMessage = json;
    }
    
    public void setJsonMessage(JSONChatMessage a){
    	jsonMessage = a;
    }
    
    public void setMessageType(WCMessageType a){
    	type = a;
    }
    
    public void setMessage(String a){
    	message = a;
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
    
    public WCMessageType getMessageType(){
    	return type;
    }
    
    public JSONChatMessage getJsonMessage(){
    	return jsonMessage;
    }
    
    public String getMessage(){
    	return message;
    }
 
    public HandlerList getHandlers() {
        return handlers;
    }
 
    public static HandlerList getHandlerList() {
        return handlers;
    }
}
