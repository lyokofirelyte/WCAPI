package com.github.lyokofirelyte.WCAPI;

import java.util.List;

import org.bukkit.Location;


public class WCSystem {
	
	String name;

	public WCSystem(String name) {
	this.name = name;
	}
	
	public int paragonTotal;
	public int paragonNewListSize;
	public int paragonTier;
	
	public Boolean rebooting = false;
	
	public List<String> emotes;
	public List<String> emoteActions;
	public List<String> obeliskLocations;
	public List<String> users;
	public List<String> chests;
	public List<Location> teleportPads;
	
	public List<Location> getTeleportPads(){
		return teleportPads;
	}
	
	public void setTeleportPads(List<Location> a){
		teleportPads = a;
	}

	public List<String> getObelisks(){
		return obeliskLocations;
	}
	
	public List<String> getUsers(){
		return users;
	}
	
	public void setUsers(List<String> a){
		users = a;
	}
	
	public List<String> getChests(){
		return chests;
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
	
	public void setChests(List<String> a){
		chests = a;
	}
	
	public void setRebooting(Boolean a){
		rebooting = a;
	}
	
	
	public Boolean isRebooting(){
		return rebooting;
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
