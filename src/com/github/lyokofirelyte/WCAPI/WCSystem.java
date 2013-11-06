package com.github.lyokofirelyte.WCAPI;

import java.util.List;

public class WCSystem {
	
	String name;

	public WCSystem(String name) {
	this.name = name;
	}
	
	public int paragonTotal;
	public int paragonNewListSize;
	public int paragonTier;
	
	public List<String> emotes;
	public List<String> emoteActions;
	
	public void setParagonTotal(int a){
		paragonTotal = a;
	}
	
	public void setParagonTier(int a){
		paragonTier = a;
	}
	
	public void setParagonNewListSize(int a){
		paragonNewListSize = a;
	}
	
	public void setEmotes(List<String> a, List<String> b){
		emotes = a;
		emoteActions = b;
	}
	
	public void addEmote(String a, String b){
		emotes.add(a);
		emoteActions.add(b);
	}
	
	public void remEmote(String a){
		emotes.remove(a);
		emoteActions.remove(emotes.indexOf(a));
	}
	
	
	
	public int getParagonTotal(){
		return paragonTotal;
	}
	
	public int getParagonNewListSize(){
		return paragonNewListSize;
	}
	
	public int getParagonTier(){
		return paragonTier;
	}
	
	public List<String> getEmotes(){
		return emotes;
	}
	
	public List<String> getEmoteActions(){
		return emoteActions;
	}
	
}
