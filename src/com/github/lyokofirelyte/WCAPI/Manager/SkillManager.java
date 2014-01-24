package com.github.lyokofirelyte.WCAPI.Manager;

import org.bukkit.entity.Player;

import com.github.lyokofirelyte.WCAPI.WCAPI;
import com.github.lyokofirelyte.WCAPI.Events.WCMMOLevelUpEvent;

public abstract class SkillManager {

	public WCAPI pl;
	
	public SkillManager(WCAPI i){
		pl = i;
	}

	public void setSkill(Player p, SkillType skill, int level){
		pl.wcm.getWCPlayer(p.getName()).skills().put(skill.name(), level);
	}
	
	public void incrementSkill(Player p, SkillType skill){	
		pl.wcm.getWCPlayer(p.getName()).skills().put(skill.name(), pl.wcm.getWCPlayer(p.getName()).skills().get(skill.name())+1);
		pl.getServer().getPluginManager().callEvent(new WCMMOLevelUpEvent(p, skill, pl.wcm.getWCPlayer(p.getName()).skills().get(skill)));
	}
	
	public int getSkill(Player p, SkillType skill){
		return pl.wcm.getWCPlayer(p.getName()).skills().get(skill.name());
	}
}