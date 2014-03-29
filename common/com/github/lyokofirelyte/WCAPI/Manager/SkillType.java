package com.github.lyokofirelyte.WCAPI.Manager;

public enum SkillType {

	WOODCUTTING("woodcutting"),
	DIGGING("digging"),
	FARMING("farming"),
	WITCHCRAFT("witchcraft"),
	AGILITY("agility"),
	SLAYER("slayer"),
	COMBAT("combat"),
	ARCHERY("archery"),
	SMELTING("smelting"),
	MAGIC("magic"),
	MINING("mining"),
	SUMMONING("summoning");
	
	String skill;
	
	SkillType(String skill){
		this.skill = skill;
	}
	
	public String getSkill(){
		return skill;
	}
}