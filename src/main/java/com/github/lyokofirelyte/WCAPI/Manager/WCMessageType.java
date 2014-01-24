package com.github.lyokofirelyte.WCAPI.Manager;

public enum WCMessageType {

	BROADCAST("broadcast"),
	PLAYER("player"),
	CONSOLE("console"),
	JSON_PLAYER("json_player"),
	JSON_BROADCAST("json_broadcast"),
	BAR("bar_call");
	
	String type;
	
	WCMessageType(String type){
		this.type = type;
	}
	
	public String getType(){
		return type;
	}
}