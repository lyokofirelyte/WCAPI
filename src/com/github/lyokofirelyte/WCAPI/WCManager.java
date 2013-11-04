package com.github.lyokofirelyte.WCAPI;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;

import org.bukkit.configuration.file.YamlConfiguration;


public class WCManager {
	
	WCAPI pl;
    
	public WCManager(WCAPI instance){
	pl = instance;
	}
	

	public void addAlliance(WCAlliance wca, String name) throws IOException{
		
		File listFile = new File("./plugins/WaterCloset/Alliances/list.yml");
		File allianceFile = new File("./plugins/WaterCloset/Alliances/" + name + ".yml");
		
			if (!allianceFile.exists()){
				allianceFile.createNewFile();
			} else {
				return;
			}
			
	    YamlConfiguration listYaml = YamlConfiguration.loadConfiguration(listFile);
	    YamlConfiguration allianceYaml = YamlConfiguration.loadConfiguration(allianceFile);
	    
	    List<String> alliances = listYaml.getStringList("Alliances");
	    alliances.add(name);
	    listYaml.set("Alliances", alliances);
	    listYaml.save(listFile);
	    
	    allianceYaml.set("Created", wca.getCreated());
	    allianceYaml.set("Leader", wca.getLeader());
	    allianceYaml.set("Color1", wca.getColor1());
	    allianceYaml.set("Color2", wca.getColor2());
	    allianceYaml.set("CompletedColors", wca.getCompletedColors());
	    allianceYaml.set("Disbanded", wca.getDisbanded());
	    allianceYaml.set("Bank", wca.getBank());
	    allianceYaml.set("Tier", wca.getTier());
	    allianceYaml.set("ChatAdminList", wca.getChatAdmins());
	    allianceYaml.set("BanList", wca.getBanList());
	    allianceYaml.set("ChatUsers", wca.getChatUsers());
	    allianceYaml.set("Coords", wca.getCoords());
	    allianceYaml.set("DoorLocks", wca.getDoorLocks());
	    allianceYaml.set("MobSpawn", wca.getMobSpawn());
	    allianceYaml.set("Radius", wca.getRadius());
	    allianceYaml.set("ChangedColors", wca.changedColors());
	    allianceYaml.set("Members", wca.getUsers());
	    allianceYaml.set("MemberCount", wca.getMemberCount());
	    allianceYaml.save(allianceFile);
	    pl.wcAlliances.put(name, wca);
	}
	
	public void remAlliance(String name) throws IOException{
		
		File listFile = new File("./plugins/WaterCloset/Alliances/list.yml");
		File allianceFile = new File("./plugins/WaterCloset/Alliances/" + name + ".yml");

	    YamlConfiguration listYaml = YamlConfiguration.loadConfiguration(listFile);
	    
	    List<String> alliances = listYaml.getStringList("Alliances");
	    alliances.remove(name);
	    listYaml.set("Alliances", alliances);
	    listYaml.save(listFile);
	    allianceFile.delete();
	    pl.wcAlliances.remove(name);
	}
	

	public void setupAlliances(){
		
		File file = new File("./plugins/WaterCloset/Alliances/list.yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(file);
		List<String> alliances = yaml.getStringList("Alliances");
			for (String a : alliances){
				WCAlliance wca = new WCAlliance(a);
				
				File aFile = new File("./plugins/WaterCloset/Alliances/" + a + ".yml");
				YamlConfiguration ayaml = YamlConfiguration.loadConfiguration(aFile);
				
				wca.setCreated(ayaml.getBoolean("Created"));
				wca.setLeader(ayaml.getString("Leader"));
				wca.setCompletedColors(ayaml.getString("CompletedColors"));
				wca.setDisbanded(ayaml.getBoolean("Disbanded"));
				wca.setColors(ayaml.getString("Color1"), ayaml.getString("Color2"));
				wca.setBank(ayaml.getInt("Bank"));
				wca.setTier(ayaml.getInt("Tier"));
				wca.setBanList(ayaml.getStringList("BanList"));
				wca.setChatAdminList(ayaml.getStringList("ChatAdminList"));
				wca.setChatUsers(ayaml.getStringList("ChatUsers"));
				wca.setCoords(ayaml.getString("Coords"));
				wca.setDoorLocks(ayaml.getBoolean("DoorLocks"));
				wca.setMobSpawn(ayaml.getBoolean("MobSpawn"));
				wca.setRadius(ayaml.getInt("Radius"));
				wca.setChangedColors(ayaml.getBoolean("ChangedColors"));
				wca.setMemberCount(ayaml.getInt("MemberCount"));
				wca.setMembers(ayaml.getStringList("Members"));
				pl.wcAlliances.put(a, wca);
			}
		pl.getLogger().log(Level.INFO,  alliances.size() + " alliances loaded!");
		pl.getLogger().log(Level.INFO, "Waiting two minutes to schedule reboot!");
	}
	
	public void saveAlliances() throws IOException {
		
		File file = new File("./plugins/WaterCloset/Alliances/list.yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(file);
		List<String> alliances = yaml.getStringList("Alliances");
			for (String a : alliances){
				WCAlliance wca = pl.wcAlliances.get(a);
				
				File aFile = new File("./plugins/WaterCloset/Alliances/" + a + ".yml");
				YamlConfiguration ayaml = YamlConfiguration.loadConfiguration(aFile);
				
				ayaml.set("Created", wca.getCreated());
				ayaml.set("Leader", wca.getLeader());
				ayaml.set("Color1", wca.getColor1());
				ayaml.set("Color2", wca.getColor2());
				ayaml.set("CompletedColors", wca.getCompletedColors());
				ayaml.set("Disbanded", wca.getDisbanded());
				ayaml.set("Bank", wca.getBank());
				ayaml.set("Tier", wca.getTier());
				ayaml.set("ChatAdminList", wca.getChatAdmins());
				ayaml.set("BanList", wca.getBanList());
				ayaml.set("ChatUsers", wca.getChatUsers());
				ayaml.set("Coords", wca.getCoords());
				ayaml.set("DoorLocks", wca.getDoorLocks());
				ayaml.set("MobSpawn", wca.getMobSpawn());
				ayaml.set("Radius", wca.getRadius());
				ayaml.set("ChangedColors", wca.changedColors());
				ayaml.set("MemberCount", wca.getMemberCount());
				ayaml.set("Members", wca.getUsers());
				ayaml.save(aFile);
			}
		yaml.save(file);
	}
	
	public void setupPlayer(String p) {
		
		WCPlayer wcp = new WCPlayer(p);
		File file = new File("./plugins/WaterCloset/Users/" + p + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(file);
		
		wcp.setHomes(yaml.getStringList("HomeList"));
		wcp.setChat(yaml.getBoolean("Chat.TimeCode"), yaml.getString("Chat.GlobalColor"), yaml.getString("Chat.PMColor"));
		wcp.setHistory(yaml.getStringList("History"));
		wcp.setEvac(yaml.getBoolean("PartyEvac"));
		wcp.setHomeSounds(yaml.getBoolean("HomeSounds"));
		wcp.setNick(yaml.getString("Nick"));
		wcp.setInChat(yaml.getBoolean("InChat"));
		wcp.setDisHandle(yaml.getBoolean("DisHandle"));
		wcp.setChatGuest(yaml.getBoolean("ChatGuest"));
		wcp.setHasInvite(yaml.getBoolean("HasInvite"));
		wcp.setWCOP(yaml.getBoolean("IsWCOp"));
		wcp.setBlocksMined(yaml.getInt("BlocksMined"));
		wcp.setAllianceColor(yaml.getString("AllianceColor"));
		wcp.setAllianceRank(yaml.getString("AllianceRank"));
		wcp.setAllianceRank2(yaml.getString("AllianceRank2"));
		wcp.setInvite(yaml.getString("Invite"));
		wcp.setInviter(yaml.getString("Inviter"));
		wcp.setParagonLevel(yaml.getInt("ParagonLevel"));
		wcp.setCurrentChat(yaml.getString("CurrentChat"));
		wcp.setDeathCount(yaml.getInt("DeathCount"));
		wcp.setLastChat(yaml.getString("LastChat"));
		wcp.setItemThrow(yaml.getBoolean("ItemThrow"));
		wcp.setPVP(yaml.getBoolean("PVP"));
		wcp.setInAlliance(yaml.getBoolean("InAlliance"));
		wcp.setAlliance(yaml.getString("Alliance"));
		wcp.setHasNick(yaml.getBoolean("HasNick"));
		wcp.setFireworks(yaml.getBoolean("Fireworks"));
	    wcp.setAllowPokes(yaml.getBoolean("Pokes"));
	    wcp.setEmotes(yaml.getBoolean("Emotes"));
	    wcp.setExp(yaml.getInt("Exp"));
	    wcp.setBalance(yaml.getInt("Balance"));
	    wcp.setDepositExp(yaml.getBoolean("DepositExp"));
	    wcp.setScoreboard(yaml.getBoolean("Scoreboard"));
		pl.wcPlayers.put(p, wcp);
	}

	public void savePlayer(String p) throws IOException{
		
		WCPlayer wcp = getWCPlayer(p);
		File file = new File("./plugins/WaterCloset/Users/" + p + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(file);
		
		yaml.set("History", wcp.getHistory());
		yaml.set("HomeList", wcp.getHomes());
		yaml.set("Chat.TimeCode", wcp.getTimeCode());
		yaml.set("Chat.GlobalColor", wcp.getGlobalColor());
		yaml.set("Chat.PMColor", wcp.getPMColor());
		yaml.set("PartyEvac", wcp.getEvac());
		yaml.set("Inviter", wcp.getInviter());
		yaml.set("Invite", wcp.getInvite());
		yaml.set("AllianceRank2", wcp.getAllianceRank2());
		yaml.set("AllianceRank", wcp.getAllianceRank());
		yaml.set("AllianceColor", wcp.getAllianceColor());
		yaml.set("IsWCOp", wcp.isWCOp());
		yaml.set("HasInvite", wcp.hasInvite());
		yaml.set("ChatGuest", wcp.getChatGuest());
		yaml.set("DisHandle", wcp.getDisHandle());
		yaml.set("InChat", wcp.getInChat());
		yaml.set("Nick", wcp.getNick());
		yaml.set("ParagonLevel", wcp.getParagonLevel());
		yaml.set("HomeSounds", wcp.getHomeSounds());
		yaml.set("Emotes", wcp.getEmotes());
		yaml.set("CurrentChat", wcp.getCurrentChat());
		yaml.set("DeathCount", wcp.getDeathCount());
		yaml.set("LastChat", wcp.getLastChat());
		yaml.set("ItemThrow", wcp.itemThrow());
		yaml.set("PVP", wcp.getPVP());
		yaml.set("InAlliance", wcp.getInAlliance());
		yaml.set("Alliance", wcp.getAlliance());
		yaml.set("Fireworks", wcp.getFireworks());
		yaml.set("Pokes", wcp.getAllowPokes());
		yaml.set("HasNick", wcp.hasNick());
		yaml.set("Scoreboard", wcp.getScoreboard());
		yaml.set("Exp", wcp.getExp());
		yaml.set("BlocksMined", wcp.getBlocksMined());
		yaml.set("Balance", wcp.getBalance());
		yaml.set("DepositExp", wcp.getExpDeposit());
		yaml.save(file);
		pl.wcPlayers.remove(p);
	}

	public WCPlayer getWCPlayer(String player){
		if (pl.wcPlayers.containsKey(player)){
			return pl.wcPlayers.get(player);
		} else {
			pl.getLogger().log(Level.SEVERE, "NO PLAYER MAP FOUND FOR " + player + "!");
			return null;
		}
	}
	
	public WCAlliance getWCAlliance(String name){
		if (pl.wcAlliances.containsKey(name)){
			return pl.wcAlliances.get(name);
		} 
		return null;
	}
	
	public String getCompleted(String name, String c1, String c2){
		int midpoint = name.length() / 2;
        String firstHalf = name.substring(0, midpoint);
        String secondHalf = name.substring(midpoint);
		String completed = "&" + c1 + firstHalf + "&" + c2 + secondHalf;
		return completed;
	}
	
	public String getCompleted2(String name, String c1, String c2){
		int midpoint = name.length() / 2;
        String firstHalf = name.substring(0, midpoint);
        String secondHalf = name.substring(midpoint);
		String completed = "§" + c1 + firstHalf + "§" + c2 + secondHalf;
		return completed;
	}
	
	public void foreverAlone() throws IOException{
		
		WCAlliance fA = new WCAlliance("ForeverAlone");
		
		File listFile = new File("./plugins/WaterCloset/Alliances/list.yml");
		File allianceFile = new File("./plugins/WaterCloset/Alliances/ForeverAlone.yml");
		
			if (!allianceFile.exists()){
				allianceFile.createNewFile();
			} else {
				return;
			}
			
	    YamlConfiguration listYaml = YamlConfiguration.loadConfiguration(listFile);
	    YamlConfiguration allianceYaml = YamlConfiguration.loadConfiguration(allianceFile);
	    
	    allianceYaml.set("Color1", "7");
	    allianceYaml.set("Color2", "8");
	    allianceYaml.save(allianceFile);
	    pl.wcAlliances.put("ForeverAlone", fA);
	    
	    List<String> alliances = listYaml.getStringList("Alliances");
	    alliances.add("ForeverAlone");
	    listYaml.set("Alliances", alliances);
	    listYaml.save(listFile);
	}
	
	public void updateAllianceMap(String name, WCAlliance wcm){
		pl.wcAlliances.put(name, wcm);
	}
	
	public void updatePlayerMap(String name, WCPlayer wcp){
		pl.wcPlayers.put(name, wcp);
	}
}
