package com.github.lyokofirelyte.WCAPI;

import java.util.ArrayList;
import java.util.List;

public class WCAlliance {

	String name;

	public WCAlliance(String name) {
	this.name = name;
	}
	
	List<String> chatUsers = new ArrayList<>();
	List<String> chatBanList = new ArrayList<>();
	List<String> chatAdminList = new ArrayList<>();
	List<String> users = new ArrayList<>();
	
	Boolean created = false;
	Boolean disbanded = false;
	Boolean approved = false;
	Boolean doorLocks = false;
	Boolean mobSpawn = false;
	Boolean changedColors = false;
	
	String leader;
	String color1;
	String color2;
	String completedColors;
	String coords;
	
	int tier = 0;
	int bank = 0;
	int memberCount = 0;
	int radius = 0;
	
	public List<String> getChatUsers(){
		return chatUsers;
	}
	
	public List<String> getUsers(){
		return users;
	}
	
	public List<String> getChatAdmins(){
		return chatAdminList;
	}
	
	public List<String> getBanList(){
		return chatBanList;
	}
	
	public Boolean getMobSpawn(){
		return mobSpawn;
	}
	
	public Boolean changedColors(){
		return changedColors;
	}
	
	public Boolean getDoorLocks(){
		return doorLocks;
	}
	
	public Boolean getCreated(){
		return created;
	}
	
	public Boolean getDisbanded(){
		return disbanded;
	}
	
	public Boolean getApproved(){
		return approved;
	}
	
	public String getLeader(){
		return leader;
	}
	
	public String getColor1(){
		return color1;
	}
	
	public String getColor2(){
		return color2;
	}
	
	public String getCompletedColors(){
		return completedColors;
	}
	
	public String getCoords(){
		return coords;
	}
	
	public int getTier(){
		return tier;
	}
	
	public int getBank(){
		return bank;
	}
	
	public int getMemberCount(){
		return memberCount;
	}
	
	public int getChatUserCount(){
		return chatUsers.size();
	}
	
	public int getRadius(){
		return radius;
	}
	
	
	
	public void setDoorLocks(Boolean a){
		doorLocks = a;
	}
	
	public void setMobSpawn(Boolean a){
		mobSpawn = a;
	}

	public void setCreated(Boolean a){
		created = a;
	}
	
	public void setDisbanded(Boolean a){
		disbanded = a;
	}
	
	public void setApproved(Boolean a){
		approved = a;
	}
	
	public void setChangedColors(Boolean a){
		changedColors = a;
	}
	
	public void setColor1(String a){
		color1 = a;
	}
	
	public void addChatUser(String a){
		chatUsers.add(a);
	}
	
	public void remChatUser(String a){
		chatUsers.remove(a);
	}
	
	public void setCoords(String a){
		coords = a;
	}
	
	public void setColor2(String a){
		color2 = a;
	}
	
	public void setLeader(String a){
		leader = a;
	}
		
	public void setCompletedColors(String a){
		completedColors = a;
	}
	
	public void addBan(String a){
		chatBanList.add(a);
	}
	
	public void remBan(String a){
		chatBanList.remove(a);
	}
	
	public void setColors(String a, String b){
		color1 = a;
		color2 = b;
	}
	
	public void setBank(int a){
		bank = a;
	}
	
	public void setTier(int a){
		tier = a;
	}
	
	public void setRadius(int a){
		radius = a;
	}
	
	public void setMemberCount(int a){
		memberCount = a;
	}

	public void addMember(String a){
		memberCount = memberCount + 1;
		users.add(a);
	}
	
	public void remMember(String a){
		memberCount = memberCount - 1;
		users.remove(a);
	}
	
	public void addChatAdmin(String a){
		chatAdminList.add(a);
	}
	
	public void remChatAdmin(String a){
		chatAdminList.remove(a);
	}
	
	public void setBanList(List<String> a){
		chatBanList = a;
	}
	
	public void setChatAdminList(List<String> a){
		chatAdminList = a;
	}
	
	public void setChatUsers(List<String> a){
		chatUsers = a;
	}
	
	public void setMembers(List<String> a){
		users = a;
	}
}
