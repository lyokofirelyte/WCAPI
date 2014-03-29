package com.github.lyokofirelyte.WCAPI.Manager;


public enum SkillAbility {

	TREE_FELLER(new String[] {"Knock the whole tree down with one swing", "woodcutting", "20"}),
	SUPER_BREAKER(new String[] {"Faster mining", "mining", "5"}),
	INSTA_KILL(new String[] {"Insta-kill a mob, with a smash", "slayer", "20"});
	
	String[] info;
	
	SkillAbility(String[] info){
		this.info = info;
	}
	
	public String getInfo(){
		return info[0];
	}
	
	public String getTiedSkill(){
		return info[1];
	}
	
	public String getLevel(){
		return info[2];
	}
}