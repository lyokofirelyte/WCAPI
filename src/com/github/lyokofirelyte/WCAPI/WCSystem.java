package com.github.lyokofirelyte.WCAPI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.github.lyokofirelyte.WC.WCLiftFloor;

public class WCSystem {
	
	String name;

	public WCSystem(String name) {
	this.name = name;
	}
	
	public int paragonTotal;
	public int paragonNewListSize;
	public int paragonTier;

	public Player elevatorUser;
	
	public Entity patrolCrystal; 
	
	public Boolean elevatorActive = false;
	public Boolean rebooting = false;
	
	public List<String> emotes;
	public List<String> emoteActions;
	public List<String> obeliskLocations;
	public List<String> users;
	public List<String> chests;
	public List<Location> teleportPads = new ArrayList<Location>();
	public List<Integer> sheepTasks = new ArrayList<Integer>();
	public List<String> vanishedPlayers = new ArrayList<String>();
	public Map <String, WCLiftFloor> elevatorMap = new HashMap<>();
	public String borderCenter;
	
	public Location hotSpot;
	public int diff = 0;
	public int kills = 0;
	public int checkTask;
	public int healthTimerTask = 0;
	public long sheepStart = 0L;
	public List<Location> hotSpotAreas = new ArrayList<Location>();
	public List<String> participants = new ArrayList<String>();
	public List<ItemStack> items = new ArrayList<ItemStack>();
	public List<LivingEntity> ents = new ArrayList<LivingEntity>();
	public List<String> markkitSigns = new ArrayList<String>();
	public List<String> signUsers = new ArrayList<String>();
	
	public Map <String, WCLiftFloor> getElevatorMap(){
		return elevatorMap;
	}
	
	public void setElevatorMap(Map <String, WCLiftFloor> a){
		elevatorMap = a;
	}
	
	public Player getElevatorUser(){
		return elevatorUser;
	}
	
	public void setElevatorUser(Player p){
		elevatorUser = p;
	}
	
	public List<String> getSignUsers(){
		return signUsers;
	}
	
	public void setSignUsers(List<String> a){
		signUsers = a;
	}
	
	public List<String> getMarketSigns(){
		return markkitSigns;
	}
	
	public void setBorder(String a){
		borderCenter = a;
	}
	
	public Boolean isElevatorActive(){
		return elevatorActive;
	}
	
	public void setElevatorActive(Boolean a){
		elevatorActive = a;
	}
	
	public String getBorder(){
		return borderCenter;
	}
	
	public void setVanishedPlayers(List<String> a){
		vanishedPlayers = a;
	}
	
	public List<String> getVanishedPlayers(){
		return vanishedPlayers;
	}

	public void setMarketSigns(List<String> a){
		markkitSigns = a;
	}
	
	public Entity getPatrolCrystal(){
		return patrolCrystal;
	}
	
	public long getSheepStart(){
		return sheepStart;
	}
	
	public void setSheepStart(long a){
		sheepStart = a;
	}
	
	public Location getPatrolHotSpot(){
		return hotSpot;
	}
	
	public List<Integer> getSheepTasks(){
		return sheepTasks;
	}
	
	public void setSheepTasks(List<Integer> a){
		sheepTasks = a;
	}
	
	public int getPatrolDiff(){
		return diff;
	}
	
	public int getPatrolKills(){
		return kills;
	}
	
	public int getPatrolCheckTask(){
		return checkTask;
	}
	
	public int getPatrolHealthTimerTask(){
		return healthTimerTask;
	}
	
	public List<Location> getPatrolHotSpotAreas(){
		return hotSpotAreas;
	}
	
	public List<String> getPatrolHotSpotParticipants(){
		return participants;
	}
	
	public List<ItemStack> getPatrolItems(){
		return items;
	}
	
	public List<LivingEntity> getPatrolEnts(){
		return ents;
	}
	
	public void setPatrolHotSpot(Location a){
		hotSpot = a;
	}
	
	public void setPatrolDiff(int a){
		diff = a;
	}
	
	public void setPatrolKills(int a){
		kills = a;
	}
	
	public void setPatrolItems(List<ItemStack> a){
		items = a;
	}
	
	public void setPatrolEnts(List<LivingEntity> a){
		ents = a;
	}
	
	public void setPatrolParticipants(List<String> a){
		participants = a;
	}
	
	public void setPatrolCheckTask(int a){
		checkTask = a;
	}
	
	public void setPatrolHealthTimerTask(int a){
		healthTimerTask = a;
	}
	
	public void setPatrolHotSpotAreas(List<Location> a){
		hotSpotAreas = a;
	}
	
	public List<Location> getTeleportPads(){
		return teleportPads;
	}
	
	public void setTeleportPads(List<Location> a){
		teleportPads = a;
	}
	
	public void setPatrolCrystal(Entity a){
		patrolCrystal = a;
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