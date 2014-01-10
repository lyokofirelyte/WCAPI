package com.github.lyokofirelyte.WCAPI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.inventory.Inventory;


public class WCPlayer {
	
	String name;

	public WCPlayer(String name) {
	this.name = name;
	}

	Inventory patrolActives;
	
	public List <String> homeList = new ArrayList<String>();
	public List <String> history = new ArrayList<String>();
	public List <String> mail = new ArrayList<String>();
	public List <String> patrolAchievements = new ArrayList<String>();
	public List <String> quickCommands = new ArrayList<String>();
	public List <String> powertools = new ArrayList<String>();
	
	public Map<String, Integer> skills = new HashMap<String, Integer>();
	
	public Location lastLocation;
	
	public Boolean timeCode = false;
	public Boolean homeSounds = false;
	public Boolean partyEvac = false;
	public Boolean hasNick = false;
	public Boolean inAlliance = false;
	public Boolean inChat = false;
	public Boolean disHandle = false;
	public Boolean chatGuest = false;
	public Boolean hasInvite = false;
	public Boolean isWCOp = false;
	public Boolean itemThrow = false;
	public Boolean pvp = false;
	public Boolean fireworks = true;
	public Boolean pokes = true;
	public Boolean emotes = true;
	public Boolean depositExp = false;
	public Boolean scoreboard = true;
	public Boolean rootShortCut = true;
	public Boolean namePlate = true;
	public Boolean scoreboardCoords = false;
	public Boolean paragonMarket = false;
	public Boolean transfered = false;
	public Boolean paragonSpecialHomeSet = false;
	public Boolean paragonMoney = false;
	public Boolean patrolFormCmd = false;
	public Boolean canSoar = true;
	public Boolean markkitEditMode = false;
	public Boolean allowDeathLocation = true;
	
	public String globalColor = "f";
	public String pmColor = "d";
	public String allianceColor = "b";
	public String allianceRank = "Guest";
	public String allianceRank2 = "Guest";
	public String nick;
	public String invite;
	public String inviter;
	public String alliance = "ForeverAlone";
	public String currentChat;
	public String lastChat;
	public String patrol;
	public String joinMessage = "Joined!";
	public String quitMessage = "Left!";
	public String rank = "Guest";
	public String creativeRank = "&7Guest";
	public String tpaRequest = "none";
	public String tpahereRequest = "none";
	public String lastLoginLocation = "none";
	public String currentMarkkitEdit = "none";
	
	public Location selChest;
	public Location paragonSpecialHome;
	
	public int paragonLevel = 0;
	public int paragonCount = 0;
	public int paragonTempTotal = 0;
	public int paragonReqLevel = 0;
	public int deathCount = 0;
	public int exp = 0;
	public int blocksMined;
	public int balance;
	public int messageCount = 0;
	public int paragonBacks = 0;
	public int paragonTps = 0;
	public int patrolLevel = 0;
	public int patrolExp = 0;
	
	public long canSoarTimer = 0;
	public long soarTimer = 0;
	public long mineTimer = 0;
	
	public float lastLogin = 0;
	
	public double patrolHeal = 0;
	
	public Map<String, Integer> skills(){
		return skills;
	}
	
	public void skills(Map<String, Integer> a){
		skills = a;
	}
	
	public long getCanSoarTimer(){
		return canSoarTimer;
	}
	
	public long getSoarTimer(){
		return soarTimer;
	}
	
	public long getMineTimer(){
		return mineTimer;
	}
	
	public float getLastLogin(){
		return lastLogin;
	}
	
	public double getPatrolHeal(){
		return patrolHeal;
	}
	
	public List<String> getPowertools(){
		return powertools;
	}

	public List<String> getMail(){
		return mail;
	}
	
	public List<String> getPatrolAchievements(){
		return patrolAchievements;
	}
	
	public Inventory getPatrolActives(){
		return patrolActives;
	}
	
	public List<String> getHistory(){
		return history;
	}
	
	public List<String> getHomes(){
		return homeList;
	}
	
	public List<String> getQuickCommands(){
		return quickCommands;
	}
	
	@Deprecated
	public Location getSelChest(){
		return selChest;
	}
	
	public Location getLastLocation(){
		return lastLocation;
	}
	
	
	public Location getParagonSpecialHome(){
		return paragonSpecialHome;
	}
	
	public Boolean getEvac(){
		return partyEvac;
	}
	
	public Boolean getScoreboardCoords(){
		return scoreboardCoords;
	}
	
	public Boolean getPatrolFormCmd(){
		return patrolFormCmd;
	}
	
	public Boolean getNamePlate(){
		return namePlate;
	}
	
	public Boolean getParagonMarket(){
		return paragonMarket;
	}

	public Boolean getParagonSpecialHomeSet(){
		return paragonSpecialHomeSet;
	}
	
	public Boolean getRootShortCut(){
		return rootShortCut;
	}
	
	public Boolean getMarkkitEditMode(){
		return markkitEditMode;
	}
	
	public Boolean getFireworks(){
		return fireworks;
	}
	
	public Boolean getEmotes(){
		return emotes;
	}
	
	public Boolean getAllowDeathLocation(){
		return allowDeathLocation;
	}
	
	public Boolean getCanSoar(){
		return canSoar;
	}
	
	public Boolean getScoreboard(){
		return scoreboard;
	}
	
	public Boolean getPVP(){
		return pvp;
	}
	
	public Boolean isWCOp(){
		return isWCOp;
	}
	
	public Boolean getAllowPokes(){
		return pokes;
	}
	
	public Boolean itemThrow(){
		return itemThrow;
	}
	
	public Boolean hasInvite(){
		return hasInvite;
	}
	
	public Boolean getChatGuest(){
		return chatGuest;
	}
	
	public Boolean getDisHandle(){
		return disHandle;
	}
	
	public Boolean hasNick(){
		return hasNick;
	}
	
	public Boolean getExpDeposit(){
		return depositExp;
	}
	
	public Boolean getHomeSounds(){
		return homeSounds;
	}
	
	public Boolean getParagonMoney(){
		return paragonMoney;
	}
	
	public Boolean getInAlliance(){
		return inAlliance;
	}
	
	public Boolean getInChat(){
		return inChat;
	}
	
	public Boolean getTransfered(){
		return transfered;
	}
	
	public Boolean getTimeCode(){
		return timeCode;
	}
	
	public String getInvite(){
		return invite;
	}
	
	public String getAlliance(){
		return alliance;
	}
	
	public String getInviter(){
		return inviter;
	}
	
	public String getCurrentChat(){
		return currentChat;
	}
	
	public String getRank(){
		return rank;
	}
	
	public String getTpaRequest(){
		return tpaRequest;
	}
	
	public String getCreativeRank(){
		return creativeRank;
	}
	
	public String getTpahereRequest(){
		return tpahereRequest;
	}
	
	public String getLastLoginLocation(){
		return lastLoginLocation;
	}
	
	public String getGlobalColor(){
		return globalColor;
	}
	
	public String getCurrentMarkkitEdit(){
		return currentMarkkitEdit;
	}
	
	public String getJoinMessage(){
		return joinMessage;
	}
	
	public String getQuitMessage(){
		return quitMessage;
	}
	
	public String getPMColor(){
		return pmColor;
	}
	
	public String getPatrol(){
		return patrol;
	}
	
	public String getAllianceColor(){
		return allianceColor;
	}
	
	public String getAllianceRank2(){
		return allianceRank2;
	}
	
	public String getAllianceRank(){
		return allianceRank;
	}

	public String getNick(){
		return nick;
	}
	
	public String getLastChat(){
		return lastChat;
	}
	
	public int getParagonLevel(){
		return paragonLevel;
	}
	
	public int getPatrolLevel(){
		return patrolLevel;
	}
	
	public int getParagonReqLevel(){
		return paragonReqLevel;
	}
	
	public int getParagonTempTotal(){
		return paragonTempTotal;
	}
	
	public int getParagonTps(){
		return paragonTps;
	}
	
	public int getPatrolExp(){
		return patrolExp;
	}
	
	public int getParagonCount(){
		return paragonCount;
	}
	
	public int getDeathCount(){
		return deathCount;
	}
	
	public int getMessageCount(){
		return messageCount;
	}
	
	public int getExp(){
		return exp;
	}

	public int getBlocksMined(){
		return blocksMined;
	}
	
	public int getBalance(){
		return balance;
	}
	
	public int getParagonBacks(){
		return paragonBacks;
	}
	
	public void setLastLocation(Location a){
		lastLocation = a;
	}
	
	@Deprecated
	public void setSelChest(Location a){
		selChest = a;
	}
	
	public void setParagonSpecialHome(Location a){
		paragonSpecialHome = a;
	}
	
	public void setDisHandle(Boolean a){
		disHandle = a;
	}
	
	public void setParagonMoney(Boolean a){
		paragonMoney = a;
	}
	
	public void setParagonSpecialHomeSet(Boolean a){
		paragonSpecialHomeSet = a;
	}
	
	public void setScoreboard(Boolean a){
		scoreboard = a;
	}
	
	public void setNamePlate(Boolean a){
		namePlate = a;
	}
	
	public void setPatrolFormCmd(Boolean a){
		patrolFormCmd = a;
	}
	
	public void setAllowDeathLocation(Boolean a){
		allowDeathLocation = a;
	}
	
	public void setParagonMarket(Boolean a){
		paragonMarket = a;
	}
	
	public void setMarkkitEditMode(Boolean a){
		markkitEditMode = a;
	}
	
	public void setDepositExp(Boolean a){
		depositExp = a;
	}
	
	public void setScoreboardCoords(Boolean a){
		scoreboardCoords = a;
	}

	public void setInChat(Boolean a){
		inChat = a;
	}
	
	public void setWCOP(Boolean a){
		isWCOp = a;
	}
	
	public void setHasInvite(Boolean a){
		hasInvite = a;
	}
	
	public void setRootShortCut(Boolean a){
		rootShortCut = a;
	}
	
	public void setEmotes(Boolean a){
		emotes = a;
	}
	
	public void setChatGuest(Boolean a){
		chatGuest = a;
	}
	
	public void setItemThrow(Boolean a){
		itemThrow = a;
	}
	
	public void setInAlliance(Boolean a){
		inAlliance = a;
	}
	
	public void setFireworks(Boolean a){
		fireworks = a;
	}
	
	public void setAllowPokes(Boolean a){
		pokes = a;
	}
	
	public void setTimeCode(Boolean a){
		timeCode = a;
	}
	
	public void setCanSoar(Boolean a){
		canSoar = a;
	}
	
	public void setTransfered(Boolean a){
		transfered = a;
	}
	
	public void setEvac(Boolean a){
		partyEvac = a;
	}
	
	public void setHomeSounds(Boolean a){
		homeSounds = a;
	}
	
	public void setHasNick(Boolean a) {
		hasNick = a;
	}	
	
	public void setPVP(Boolean a){
		pvp = a;
	}
	
	public void setInvite(String a){
		invite = a;
	}
	
	public void setCurrentChat(String a){
		currentChat = a;
	}
	
	public void setAlliance(String a){
		alliance = a;
	}
	
	public void setInviter(String a){
		inviter = a;
	}
	
	public void setPatrol(String a){
		patrol = a;
	}
	
	public void setJoinMessage(String a){
		joinMessage = a;
	}
	
	public void setQuitMessage(String a){
		quitMessage = a;
	}
	
	public void setTpaRequest(String a){
		tpaRequest = a;
	}
	
	public void setCreativeRank(String a){
		creativeRank = a;
	}
	
	public void setTpahereRequest(String a){
		tpahereRequest = a;
	}
	
	public void setAllianceColor(String a){
		allianceColor = a;
	}
	
	public void setRank(String a){
		rank = a;
	}
	
	public void setGlobalColor(String a){
		globalColor = a;
	}
	
	public void setPMColor(String a){
		pmColor = a;
	}

	public void setNick(String a){
		nick = a;
	}
	
	public void setAllianceRank(String a){
		allianceRank = a;
	}
	
	public void setAllianceRank2(String a){
		allianceRank2 = a;
	}

	public void setLastChat(String a){
		lastChat = a;
	}
	
	public void addMail(String a){
		mail.add(a);
	}
	
	public void remMail(String a){
		mail.remove(a);
	}
	
	public void addHistory(String a){
		history.add(a);
	}
	
	public void remHistory(String a){
		history.remove(a);
	}
	
	public void addHome(String a){
		homeList.add(a);
	}
	
	public void remHome(String a){
		homeList.remove(a);
	}
	
	public void setCurrentMarkkitEdit(String a){
		currentMarkkitEdit = a;
	}
	
	public void setLastLoginLocation(String a){
		lastLoginLocation = a;
	}
	
	public void setHomes(List<String> a){
		homeList = a;
	}
	
	public void setHistory(List<String> a){
		history = a;
	}
	
	public void setMail(List<String> a){
		mail = a;
	}
	
	public void setPatrolActives(Inventory a){
		patrolActives = a;
	}
	
	public void setPatrolAchievements(List<String> a){
		patrolAchievements = a;
	}
	
	public void setQuickCommands(List<String> a){
		quickCommands = a;
	}
	
	public void setPowertools(List<String> a){
		powertools = a;
	}
	
	public void clearMail(){
		mail = new ArrayList<>();
	}
	
	public void setParagonLevel(int a){
		paragonLevel = a;
	}
	
	public void setBalance(int a){
		balance = a;
	}
	
	public void setPatrolLevel(int a){
		patrolLevel = a;
	}
	
	public void setMessageCount(int a){
		messageCount = a;
	}
	
	public void setDeathCount(int a){
		deathCount = a;
	}
	
	public void setBlocksMined(int a){
		blocksMined = a;
	}
	
	public void setPatrolExp(int a){
		patrolExp = a;
	}
	
	public void setParagonCount(int a){
		paragonCount = a;
	}
	
	public void setParagonTps(int a){
		paragonTps = a;
	}
	
	public void setParagonBacks(int a){
		paragonBacks = a;
	}
	
	public void setParagonTempTotal(int a){
		paragonTempTotal = a;
	}
	
	public void setParagonReqLevel(int a){
		paragonReqLevel = a;
	}
	
	public void setExp(int a){
		exp = a;
	}
	
	public void setPatrolHeal(double a){
		patrolHeal = a;
	}
	
	public void setLastLogin(float a){
		lastLogin = a;
	}
	
	public void setSoarTimer(long a){
		soarTimer = a;
	}
	
	public void setCanSoarTimer(long a){
		canSoarTimer = a;
	}
		
	public void setMineTimer(long a){
		mineTimer = a;
	}
	
	public void setChat(Boolean timecode, String globalcolor, String pmcolor){
		timeCode = timecode;
		globalColor = globalcolor;
		pmColor = pmcolor;
	}
}
