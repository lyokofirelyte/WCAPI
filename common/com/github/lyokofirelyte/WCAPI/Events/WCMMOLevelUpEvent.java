package com.github.lyokofirelyte.WCAPI.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

import com.github.lyokofirelyte.WCAPI.WCEvent;
import com.github.lyokofirelyte.WCAPI.Manager.SkillType;

public class WCMMOLevelUpEvent extends WCEvent implements Cancellable {
	
    private static final HandlerList handlers = new HandlerList();
    private Player p;
    private boolean cancelled;
    private SkillType skill;
    private int newLevel;

    public WCMMOLevelUpEvent(Player p, SkillType skill, int newLevel) {
        this.p = p;
        this.skill = skill;
        this.newLevel = newLevel;
    }
    
    public void setSkill(SkillType s){
    	skill = s;
    }
    
    public void setLevel(int a){
    	newLevel = a;
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
    
    public SkillType getSkill(){
    	return skill;
    }
    
    public int getLevel(){
    	return newLevel;
    }
 
    public HandlerList getHandlers() {
        return handlers;
    }
 
    public static HandlerList getHandlerList() {
        return handlers;
    }
}
