package com.github.lyokofirelyte.WCAPI;

import java.util.ArrayList;
import java.util.List;

public class WCPatrol {

	String name;
	Boolean canTp = true;

	public WCPatrol(String name) {
	this.name = name;
	}
	
	List<String> members = new ArrayList<String>();
	String patrolName;
	
	public List<String> getMembers(){
		return members;
	}
	
	public String getName(){
		return patrolName;
	}
	
	public void setMembers(List<String> a){
		members = a;
	}
	
	public void setName(String a){
		patrolName = a;
	}
	
	public void setCanTp(Boolean a){
		canTp = a;
	}
	
	public Boolean getCanTp(){
		return canTp;
	}
}
