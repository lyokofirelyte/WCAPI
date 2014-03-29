package com.github.lyokofirelyte.WCAPI;

public enum Request {
	
	AUTH("AUTH"),
	CHAT_IN("CHAT_IN");

	Request(String t){
		type = t;
	}
	
	private String type;
	
	public String toString(){
		return type;
	}
}