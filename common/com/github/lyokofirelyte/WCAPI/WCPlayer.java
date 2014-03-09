package com.github.lyokofirelyte.WCAPI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.Inventory;

import com.github.lyokofirelyte.WCAPI.Manager.SkillAbility;

public class WCPlayer {
	
	private String name;
	
	private List<String> homeList;
	private List<String> history;
	private List<String> mail;
	private List<String> patrolAchievements;
	private List<String> quickCommands;
	private List<String> powertools;
	
	private Map<String, Integer> skills;
	private Map<String, Integer> skillExp;
	private Map<SkillAbility, Long> skillCooldowns;
	private Map<EntityType, Integer> slayerAssignment;
	
	private LivingEntity pet;
	private LivingEntity target;
	private LivingEntity targetHit;
	
	private Inventory offlineInventory;
	private Inventory patrolActives;
	
	private Location lastLocation;
	private Location selChest;
	private Location paragonSpecialHome;
	private Location afkSpot;
	
	private boolean timeCode;
	private boolean ridingPet;
	private boolean homeSounds;
	private boolean partyEvac;
	
	private boolean hasNick;
	private boolean inAlliance;
	private boolean inChat;
	private boolean disHandle;
	
	private boolean chatGuest;
	private boolean hasInvite;
	private boolean isWCOp;
	private boolean itemThrow;
	
	private boolean pvp;
	private boolean fireworks;
	private boolean pokes;
	private boolean emotes;
	
	private boolean depositExp;
	private boolean scoreboard;
	private boolean rootShortCut;
	private boolean namePlate;
	
	private boolean scoreboardCoords;
	private boolean paragonMarket;
	private boolean transfered;
	private boolean paragonSpecialHomeSet;
	
	private boolean paragonMoney;
	private boolean patrolFormCmd;
	private boolean canSoar;
	private boolean markkitEditMode;
	
	private boolean allowDeathLocation;
	private boolean isDoubleJumping;
	private boolean isTreeFelling;
	private boolean followMode;
	
	private boolean usingInstaKill;
	private boolean chatBar;
	private boolean patrolAware;
	private boolean superAfk;
	
	private boolean afkFreeze;
	private boolean website;
	
	private String globalColor;
	private String pmColor;
	private String allianceColor;
	private String allianceRank;
	
	private String allianceRankTemp;
	private String nick;
	private String invite;
	private String inviter;
	
	private String alliance;
	private String currentChat;
	private String lastChat;
	private String patrol;
	
	private String joinMessage;
	private String quitMessage;
	private String rank;
	private String creativeRank;
	
	private String tpaRequest;
	private String tpahereRequest;
	private String lastLoginLocation;
	private String currentMarkkitEdit;
	
	private String websiteCode;
	
	private int paragonLevel;
	private int paragonCount;
	private int paragonTempTotal;
	private int paragonReqLevel;
	
	private int deathCount;
	private int exp;
	private int blocksMined;
	private int balance;
	
	private int messageCount;
	private int paragonBacks;
	private int paragonTps;
	private int patrolLevel;
	
	private int patrolExp;
	private int lastSkillExp;
	
	private float lastLogin;
	
	private long canSoarTimer;
	private long soarTimer;
	private long mineTimer;
	private long doubleJumpTimer;
	
	private double patrolHeal;
	
	public WCPlayer(String name){
		
		this.name = name;
		
		homeList = new ArrayList<String>();
		history = new ArrayList<String>();
		mail = new ArrayList<String>();
		patrolAchievements = new ArrayList<String>();
		quickCommands = new ArrayList<String>();
		powertools = new ArrayList<String>();

		skills = new HashMap<String, Integer>();
		skillExp = new HashMap<String, Integer>();
		skillCooldowns = new HashMap<SkillAbility, Long>();
		slayerAssignment = new HashMap<EntityType, Integer>();
		
		timeCode = false;
		ridingPet = false;
		homeSounds = false;
		partyEvac = false;
		
		hasNick = false;
		inAlliance = false;
		inChat = false;
		disHandle = false;
		
		chatGuest = false;
		hasInvite = false;
		isWCOp = false;
		itemThrow = false;
		
		pvp = false;
		fireworks = true;
		pokes = true;
		emotes = true;
		
		depositExp = false;
		scoreboard = true;
		rootShortCut = true;
		namePlate = true;
		
		scoreboardCoords = false;
		paragonMarket = false;
		transfered = false;
		paragonSpecialHomeSet = false;
		
		paragonMoney = false;
		patrolFormCmd = false;
		canSoar = true;
		markkitEditMode = false;
		
		allowDeathLocation = true;
		isDoubleJumping = false;
		isTreeFelling = false;
		followMode = false;
		
		usingInstaKill = false;
		chatBar = false;
		patrolAware = false;
		superAfk = false;
		
		afkFreeze = false;
		website = false;
		
		globalColor = "f";
		pmColor = "d";
		allianceColor = "b";
		allianceRank = "Guest";
		
		allianceRankTemp = "Guest";
		alliance = "ForeverAlone";
		joinMessage = "Joined!";
		quitMessage = "Left!";
		
		rank = "Guest";
		creativeRank = "&7Guest";
		tpaRequest = "none";
		tpahereRequest = "none";
		
		lastLoginLocation = "none";
		currentMarkkitEdit = "none";
		websiteCode = "none";
		
		paragonLevel = 0;
		paragonCount = 0;
		paragonTempTotal = 0;
		paragonReqLevel = 0;
		
		deathCount = 0;
		exp = 0;
		blocksMined = 0;
		balance = 0;
		
		messageCount = 0;
		paragonBacks = 0;
		paragonTps = 0;
		patrolLevel = 0;
		
		patrolExp = 0;
		lastSkillExp = 0;
		
		lastLogin = 0;
		
		canSoarTimer = 0;
		soarTimer = 0;
		mineTimer = 0;
		doubleJumpTimer = 0;
		
		patrolHeal = 0;
		
	}
	
	public String getName(){
		
		return name;
		
	}
	
	public Map<EntityType, Integer> getSlayerAssignment(){
		return slayerAssignment;
	}
	
	public Map<String, Integer> skillExp(){
		return skillExp;
	}
	
	public Map<String, Integer> skills(){
		return skills;
	}
	
	public Map<SkillAbility, Long> skillCooldowns(){
		return skillCooldowns;
	}
	
	public LivingEntity getPet(){
		return pet;
	}
	
	public LivingEntity getTarget(){
		return target;
	}
	
	public LivingEntity getTargetHit(){
		return targetHit;
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
	
	public long getDoubleJumpTimer(){
		return doubleJumpTimer;
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
	
	public Inventory getOfflineInventory(){
		
		if (offlineInventory == null){
			return Bukkit.createInventory(null, 9, "NO INVENTORY FOUND");
		}
		return offlineInventory;
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
	
	public Location getAfkSpot(){
		return afkSpot;
	}
	
	public Location getParagonSpecialHome(){
		return paragonSpecialHome;
	}
	
	
	public boolean cooldownDone(SkillAbility sa){
		
		if (skillCooldowns.get(sa) == null){
			skillCooldowns.put(sa, 0L);
		}
		
		if (skillCooldowns().get(sa) <= System.currentTimeMillis()){
			return true;
		}
		
		return false;
	}
	
	public boolean getEvac(){
		return partyEvac;
	}
	
	public boolean websiteRegistered(){
		return website;
	}
	
	public boolean getAfkFreeze(){
		return afkFreeze;
	}
	
	public boolean useChatBar(){
		return chatBar;
	}
	
	public boolean isPatrolAware(){
		return patrolAware;
	}
	
	public boolean getFollowMode(){
		return followMode;
	}
	
	public boolean isRidingPet(){
		return ridingPet;
	}
	
	public boolean isSuperAfk(){
		return superAfk;
	}
	
	public boolean isUsingInstaKill(){
		return usingInstaKill;
	}
	
	public boolean isTreeFelling(){
		return isTreeFelling;
	}
	
	public boolean getScoreboardCoords(){
		return scoreboardCoords;
	}
	
	public boolean getPatrolFormCmd(){
		return patrolFormCmd;
	}
	
	public boolean getNamePlate(){
		return namePlate;
	}
	
	public boolean getParagonMarket(){
		return paragonMarket;
	}

	public boolean getParagonSpecialHomeSet(){
		return paragonSpecialHomeSet;
	}
	
	public boolean getRootShortCut(){
		return rootShortCut;
	}
	
	public boolean getMarkkitEditMode(){
		return markkitEditMode;
	}
	
	public boolean isDoubleJumping(){
		return isDoubleJumping;
	}
	
	public boolean getFireworks(){
		return fireworks;
	}
	
	public boolean getEmotes(){
		return emotes;
	}
	
	public boolean getAllowDeathLocation(){
		return allowDeathLocation;
	}
	
	public boolean getCanSoar(){
		return canSoar;
	}
	
	public boolean getScoreboard(){
		return scoreboard;
	}
	
	public boolean getPVP(){
		return pvp;
	}
	
	public boolean isWCOp(){
		return isWCOp;
	}
	
	public boolean getAllowPokes(){
		return pokes;
	}
	
	public boolean itemThrow(){
		return itemThrow;
	}
	
	public boolean hasInvite(){
		return hasInvite;
	}
	
	public boolean getChatGuest(){
		return chatGuest;
	}
	
	public boolean getDisHandle(){
		return disHandle;
	}
	
	public boolean hasNick(){
		return hasNick;
	}
	
	public boolean getExpDeposit(){
		return depositExp;
	}
	
	public boolean getHomeSounds(){
		return homeSounds;
	}
	
	public boolean getParagonMoney(){
		return paragonMoney;
	}
	
	public boolean getInAlliance(){
		return inAlliance;
	}
	
	public boolean getInChat(){
		return inChat;
	}
	
	public boolean getTransfered(){
		return transfered;
	}
	
	public boolean getTimeCode(){
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
		return allianceRankTemp;
	}
	
	public String getWebsiteCode(){
		return websiteCode;
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
	
	public int getLastSkillExp(){
		return lastSkillExp;
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
	
	public void setAfkSpot(Location a){
		afkSpot = a;
	}
	
	public void setLastLocation(Location a){
		lastLocation = a;
	}
	
	public void setSlayerAssignment(Map<EntityType, Integer> a){
		slayerAssignment = a;
	}
	
	@Deprecated
	public void setSelChest(Location a){
		selChest = a;
	}
	
	public void setParagonSpecialHome(Location a){
		paragonSpecialHome = a;
	}
	
	public void setDisHandle(boolean a){
		disHandle = a;
	}
	
	public void setTreeFelling(boolean a){
		isTreeFelling = a;
	}
	
	public void setParagonMoney(boolean a){
		paragonMoney = a;
	}
	
	public void setParagonSpecialHomeSet(boolean a){
		paragonSpecialHomeSet = a;
	}
	
	public void setWebsiteRegistered(boolean a){
		website = a;
	}
	
	public void setUsingInstaKill(boolean a){
		usingInstaKill = a;
	}
	
	public void setAfkFreeze(boolean a){
		afkFreeze = a;
	}
	
	public void setScoreboard(boolean a){
		scoreboard = a;
	}
	
	public void setRidingPet(boolean a){
		ridingPet = a;
	}
	
	public void setSuperAfk(boolean a){
		superAfk = a;
	}
	
	public void setPatrolAware(boolean a){
		patrolAware = a;
	}
	
	public void setFollowMode(boolean a){
		followMode = a;
	}
	
	public void setNamePlate(boolean a){
		namePlate = a;
	}
	
	public void setPatrolFormCmd(boolean a){
		patrolFormCmd = a;
	}
	
	public void setAllowDeathLocation(boolean a){
		allowDeathLocation = a;
	}
	
	public void setParagonMarket(boolean a){
		paragonMarket = a;
	}
	
	public void setMarkkitEditMode(boolean a){
		markkitEditMode = a;
	}
	
	public void setDepositExp(boolean a){
		depositExp = a;
	}
	
	public void setScoreboardCoords(boolean a){
		scoreboardCoords = a;
	}
	
	public void setDoubleJumping(boolean a){
		isDoubleJumping = a;
	}

	public void setInChat(boolean a){
		inChat = a;
	}
	
	public void setWCOP(boolean a){
		isWCOp = a;
	}
	
	public void setChatBar(boolean a){
		chatBar = a;
	}
	
	public void setHasInvite(boolean a){
		hasInvite = a;
	}
	
	public void setRootShortCut(boolean a){
		rootShortCut = a;
	}
	
	public void setEmotes(boolean a){
		emotes = a;
	}
	
	public void setChatGuest(boolean a){
		chatGuest = a;
	}
	
	public void setItemThrow(boolean a){
		itemThrow = a;
	}
	
	public void setInAlliance(boolean a){
		inAlliance = a;
	}
	
	public void setFireworks(boolean a){
		fireworks = a;
	}
	
	public void setAllowPokes(boolean a){
		pokes = a;
	}
	
	public void setTimeCode(boolean a){
		timeCode = a;
	}
	
	public void setCanSoar(boolean a){
		canSoar = a;
	}
	
	public void setTransfered(boolean a){
		transfered = a;
	}
	
	public void setEvac(boolean a){
		partyEvac = a;
	}
	
	public void setHomeSounds(boolean a){
		homeSounds = a;
	}
	
	public void setHasNick(boolean a) {
		hasNick = a;
	}	
	
	public void setPVP(boolean a){
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
	
	public void setWebsiteCode(String a){
		websiteCode = a;
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
		allianceRankTemp = a;
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
	
	public void setOfflineInventory(Inventory a){
		offlineInventory = a;
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
	
	public void setLastSkillExp(int a){
		lastSkillExp = a;
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
	
	public void setDoubleJumpTimer(long a){
		doubleJumpTimer = a;
	}
	
	public void skills(Map<String, Integer> a){
		skills = a;
	}
	
	public void setPet(LivingEntity a){
		pet = a;
	}
	
	public void setTarget(LivingEntity a){
		target = a;
	}
	
	public void setTargetHit(LivingEntity a){
		targetHit = a;
	}
	
	public void skillExp(Map<String, Integer> a){
		skillExp = a;
	}
	
	public void setChat(boolean timecode, String globalColor, String pmColor){
		timeCode = timecode;
		this.globalColor = globalColor;
		this.pmColor = pmColor;
	}
	
}
