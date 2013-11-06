package com.github.lyokofirelyte.WCAPI;

import java.util.ArrayList;
import java.util.List;


public class WCPlayer {
	
	String name;

	public WCPlayer(String name) {
	this.name = name;
	}

	public List <String> homeList;
	public List <String> history;
	public List <String> mail;
	
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
	
	public int paragonLevel = 0;
	public int paragonCount = 0;
	public int paragonTempTotal = 0;
	public int paragonReqLevel = 0;
	public int deathCount = 0;
	public int exp = 0;
	public int blocksMined;
	public int balance;
	
	@Deprecated
	public List<String> getMail(){
		return mail;
	}
	
	public List<String> getHistory(){
		return history;
	}
	
	public List<String> getHomes(){
		return homeList;
	}
	
	public Boolean getEvac(){
		return partyEvac;
	}
	
	public Boolean getFireworks(){
		return fireworks;
	}
	
	public Boolean getEmotes(){
		return emotes;
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
	
	public Boolean getInAlliance(){
		return inAlliance;
	}
	
	public Boolean getInChat(){
		return inChat;
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
	
	public String getGlobalColor(){
		return globalColor;
	}
	
	public String getPMColor(){
		return pmColor;
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
	
	public int getParagonReqLevel(){
		return paragonReqLevel;
	}
	
	public int getParagonTempTotal(){
		return paragonTempTotal;
	}
	
	public int getParagonCount(){
		return paragonCount;
	}
	
	public int getDeathCount(){
		return deathCount;
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
	
	public void setDisHandle(Boolean a){
		disHandle = a;
	}
	
	public void setScoreboard(Boolean a){
		scoreboard=  a;
	}
	
	public void setDepositExp(Boolean a){
		depositExp = a;
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
	
	public void setAllianceColor(String a){
		allianceColor = a;
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
	
	@Deprecated
	public void addMail(String a){
		mail.add(a);
	}
	
	@Deprecated
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
	
	public void setHomes(List<String> a){
		homeList = a;
	}
	
	public void setHistory(List<String> a){
		history = a;
	}
	
	@Deprecated
	public void setMail(List<String> a){
		mail = a;
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
	
	public void setDeathCount(int a){
		deathCount = a;
	}
	
	public void setBlocksMined(int a){
		blocksMined = a;
	}
	
	public void setParagonCount(int a){
		paragonCount = a;
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
		
	public void setChat(Boolean timecode, String globalcolor, String pmcolor){
		timeCode = timecode;
		globalColor = globalcolor;
		pmColor = pmcolor;
	}
}
