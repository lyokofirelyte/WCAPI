package com.github.lyokofirelyte.WCAPI.Events;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

import com.github.lyokofirelyte.WCAPI.WCEvent;

public class ParagonFindEvent extends WCEvent implements Cancellable {
	

    private static final HandlerList handlers = new HandlerList();
    private String paragon;
    private String color;
    private int blocksMined;
    private boolean cancelled;
    private Player p;
    private Color fwColor;
    private Material mat;
    private int itemColor;

    public ParagonFindEvent(Player p, String paragon, String color, Color fwColor, int itemColor, Material mat, int blocksMined) {
        this.p = p;
        this.paragon = paragon;
        this.mat = mat;
        this.blocksMined = blocksMined;
        this.color = color;
        this.itemColor = itemColor;
        this.fwColor = fwColor;
    }
 
    public boolean isCancelled() {
        return cancelled;
    }
 
    public void setCancelled(boolean cancel) {
        cancelled = cancel;
    }
    
    public void setPlayer(Player p){
    	this.p = p;
    }
    
    public int getBlocksMined(){
    	return blocksMined;
    }
    
    public int getItemColor(){
    	return itemColor;
    }
    
    public Color getfwColor(){
    	return fwColor;
    }
    
    public String getColor(){
    	return color;
    }
    
    public String getParagon(){
    	return paragon;
    }
    
    public Material getMat(){
    	return mat;
    }

    public Player getPlayer(){
    	return p;
    }
    
    public void setParagon(String a){
    	paragon = a;
    }
 
    public HandlerList getHandlers() {
        return handlers;
    }
 
    public static HandlerList getHandlerList() {
        return handlers;
    }
}