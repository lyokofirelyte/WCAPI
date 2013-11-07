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
	public List<String> obeliskLocations;
	public List<String> walkwaystarts;
	public List<String> walkwayends;
	
	public List<String> getObelisks(){
		return obeliskLocations;
	}
	
	public List<String> getWalkWayStarts(){
		return walkwaystarts;
	}
	
	public List<String> getWalkWayEnds(){
		return walkwayends;
	}
	
	public void setWalkWayStarts(List<String> a){
		walkwaystarts = a;
	}
	
	public void setWalkWayEnds(List<String> a){
		walkwayends = a;
	}
	
	public void addWalkWayStart(String a){
		walkwaystarts.add(a);
	}
	
	public void addWalkWayEnd(String a){
		walkwayends.add(a);
	}
	
	public void remWalkWayStart(String a){
		walkwaystarts.remove(a);
	}
	
	public void remWalkWayEnd(String a){
		walkwayends.remove(a);
	}
	
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
	
	public void remObelisk(String a){
		obeliskLocations.remove(a);
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
	
	public void setObelisks(List<String> a){
		obeliskLocations = a;
	}
	
	public void addObelisk(String a){
		obeliskLocations.add(a);
	}
	
}
