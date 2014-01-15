package com.github.lyokofirelyte.WCAPI.Manager;

public enum SkillType {

	ACROBATICS("acrobatics"),
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
	MINING("mining");
	
	String skill;
	
	SkillType(String skill){
		this.skill = skill;
	}
	
	public String getSkill(){
		return skill;
	}
}