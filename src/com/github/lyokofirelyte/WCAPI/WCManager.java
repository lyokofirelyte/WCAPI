package com.github.lyokofirelyte.WCAPI;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class WCManager {

	WCAPI pl;
	
	public WCManager(WCAPI instance){
	pl = instance;
	}
	
	public void addAlliance(WCAlliance wca, String name) throws IOException {
		
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
	    wcp.setParagonCount(yaml.getInt("ParagonCount"));
	    wcp.setParagonReqLevel(yaml.getInt("ParagonReqLevel"));
	    wcp.setParagonTempTotal(yaml.getInt("ParagonTempTotal"));
	    wcp.setRootShortCut(yaml.getBoolean("RootShortCut"));
	    wcp.setNamePlate(yaml.getBoolean("NamePlate"));
	    wcp.setPatrolAchievements(yaml.getStringList("Patrol.Achievements"));
	    wcp.setScoreboardCoords(yaml.getBoolean("ScoreboardCoords"));
	    wcp.setJoinMessage(yaml.getString("JoinMessage"));
	    wcp.setQuitMessage(yaml.getString("QuitMessage"));
	    wcp.setMessageCount(yaml.getInt("MessageCount"));
	    wcp.setParagonBacks(yaml.getInt("Paragon.Backs"));
	    wcp.setParagonTps(yaml.getInt("Paragon.Tps"));
	    wcp.setParagonSpecialHome(getSpecialHome(yaml.getString("Paragon.SpecialHome")));
	    wcp.setParagonMoney(yaml.getBoolean("Paragon.Money"));
	    wcp.setParagonSpecialHomeSet(yaml.getBoolean("Paragon.SpecialHomeSet"));
	    wcp.setPatrolLevel(yaml.getInt("Patrol.Level"));
	    wcp.setRank(yaml.getString("Rank"));
	    wcp.setTransfered(yaml.getBoolean("WCTRANSFER"));
	    wcp.setQuickCommands(yaml.getStringList("QuickCommands"));
	    wcp.setPatrolExp(yaml.getInt("Patrol.Exp"));
	    wcp.setPatrolActives(getActives(yaml));
	    wcp.setPowertools(yaml.getStringList("PowerTools"));
	    wcp.setLastLoginLocation(yaml.getString("LastLoginLocation"));
	    wcp.setLastLogin(yaml.getInt("LastLogin"));
	    wcp.setMail(yaml.getStringList("Mail"));
		pl.wcPlayers.put(p, wcp);
	}
	
	@SuppressWarnings("deprecation")
	public Inventory getActives(YamlConfiguration yaml){
		  Inventory inv = Bukkit.createInventory(null, 9, "§aACTIVE GEAR");
		  for (int x = 0; x < 10; x++){
			  if (yaml.getBoolean("PatrolItems.Item" + x + ".Full")){
				ItemStack i = new ItemStack(yaml.getInt("PatrolItems.Item" + x + ".ID"));
				ItemMeta im = i.getItemMeta();
				if (yaml.getBoolean("PatrolItems.Item" + x + ".Named")){
					im.setDisplayName(yaml.getString("PatrolItems.Item" + x + ".Name"));
				}
				if (yaml.getBoolean("PatrolItems.Item" + x + ".Enchanted")){
					im.addEnchant(Enchantment.DURABILITY, 10, true);
				}
				if (yaml.getBoolean("PatrolItems.Item" + x + ".HasLore")){
					im.setLore(yaml.getStringList("PatrolItems.Item" + x + ".Lore"));
				}
				if (im != null){
					i.setItemMeta(im);
				}
				inv.addItem(i);
			  }
		  }
		  return inv;
	}
	
	@SuppressWarnings("deprecation")
	public YamlConfiguration activeSorter(YamlConfiguration yaml, WCPlayer wcp){
		
		int x = 0;
		
		for (ItemStack i : wcp.getPatrolActives()){
			if (i != null){
				yaml.set("PatrolItems.Item" + x + ".Full", true);
				yaml.set("PatrolItems.Item" + x + ".ID", i.getType().getId());
				if (i.hasItemMeta()){
					if (i.getItemMeta().hasDisplayName()){
						yaml.set("PatrolItems.Item" + x + ".Named", true);
						yaml.set("PatrolItems.Item" + x + ".Name", i.getItemMeta().getDisplayName());
					}
					if (i.getItemMeta().hasLore()){
						yaml.set("PatrolItems.Item" + x + ".HasLore", true);
						yaml.set("PatrolItems.Item" + x + ".Lore", i.getItemMeta().getLore());
					}
					if (i.getItemMeta().getEnchants().size() > 0){
						yaml.set("PatrolItems.Item" + x + ".Enchanted", true);
					}
				}
			} else {
				yaml.set("PatrolItems.Item" + x + ".Full", false);
			}
			x++;
		}	
		return yaml;	
	}
	
	public Location getSpecialHome(String locText){
		if (locText != null){
			String[] locSplit = locText.split(" ");
			return new Location(Bukkit.getWorld(locSplit[0]), Double.parseDouble(locSplit[1]), Double.parseDouble(locSplit[2]), Double.parseDouble(locSplit[3]), Float.parseFloat(locSplit[4]), Float.parseFloat(locSplit[4]));
		}
		return new Location(Bukkit.getWorld("world"), 10, 10, 10);
	}
	
	public void savePlayer(String p) throws IOException {
		
		WCPlayer wcp = getWCPlayer(p);
		File file = new File("./plugins/WaterCloset/Users/" + p + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(file);
		
		yaml.set("Paragon.Backs", wcp.getParagonBacks());
		yaml.set("Paragon.Tps", wcp.getParagonTps());
		yaml.set("Paragon.Money", wcp.getParagonMoney());
		yaml.set("Paragon.SpecialHomeSet", wcp.getParagonSpecialHomeSet());
		if (wcp.getParagonSpecialHomeSet()){
			yaml.set("Paragon.SpecialHome", wcp.getParagonSpecialHome().getWorld().getName() + " " + wcp.getParagonSpecialHome().getX() + " " + wcp.getParagonSpecialHome().getY() + " " + wcp.getParagonSpecialHome().getZ() + " " + wcp.getParagonSpecialHome().getPitch() + " " + wcp.getParagonSpecialHome().getYaw());
		}
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
		yaml.set("ParagonCount", wcp.getParagonCount());
		yaml.set("ParagonReqLevel", wcp.getParagonReqLevel());
		yaml.set("ParagonTempTotal", wcp.getParagonTempTotal());
		yaml.set("RootShortCut", wcp.getRootShortCut());
		yaml.set("NamePlate", wcp.getNamePlate());
		yaml.set("Patrol.Achievements", wcp.getPatrolAchievements());
		yaml.set("ScoreboardCoords", wcp.getScoreboardCoords());
		yaml.set("JoinMessage", wcp.getJoinMessage());
		yaml.set("QuitMessage", wcp.getQuitMessage());
		yaml.set("MessageCount", wcp.getMessageCount());
		yaml.set("Patrol.Level", wcp.getPatrolLevel());
		yaml.set("Rank", wcp.getRank());
		yaml.set("WCTRANSFER", wcp.getTransfered());
		yaml.set("QuickCommands", wcp.getQuickCommands());
		yaml.set("Patrol.Exp", wcp.getPatrolExp());
		yaml.set("PowerTools", wcp.getPowertools());
		yaml.set("LastLogin", wcp.getLastLogin());
		yaml.set("LastLoginLocation", wcp.getLastLoginLocation());
		yaml.set("Mail", wcp.getMail());
		yaml = activeSorter(yaml, wcp);
		yaml.save(file);
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
		} else {
			pl.getLogger().log(Level.SEVERE, "NO ALLIANCE FOUND FOR " + name + "!");
			return null;
		}
	}
	
	public WCPatrol getWCPatrol(String name){
		
		if (pl.wcPatrols.containsKey(name)){
			return pl.wcPatrols.get(name);
		} else {
			return null;
		}
	}
	
	public WCSystem getWCSystem(String name){
		if (pl.wcSystem.containsKey(name)){
			return pl.wcSystem.get(name);
		} else {
			pl.getLogger().log(Level.SEVERE, "NO SYSTEM FILE FOUND FOR " + name + "!");
			return null;
		}
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
	
	public void updatePatrol(String name, WCPatrol wcpp){
		pl.wcPatrols.put(name, wcpp);
	}
	
	public void updateAllianceMap(String name, WCAlliance wcm){
		pl.wcAlliances.put(name, wcm);
	}
	
	public void updatePlayerMap(String name, WCPlayer wcp){
		pl.wcPlayers.put(name, wcp);
	}
	
	public void updateSystem(String name, WCSystem system){
		pl.wcSystem.put(name, system);
	}

	public void setupSystem(YamlConfiguration systemYaml) {	
		
		WCSystem wcs = new WCSystem("system");
		wcs.setParagonTotal(systemYaml.getInt("ParagonTotal"));	
		wcs.setParagonTier(systemYaml.getInt("ParagonTier"));
		wcs.setParagonNewListSize(systemYaml.getInt("ParagonNewListSize"));
		wcs.setEmotes(systemYaml.getStringList("EmotesList"), systemYaml.getStringList("EmoteActions"));
		wcs.setObelisks(systemYaml.getStringList("Obelisks"));
		wcs.setChests(systemYaml.getStringList("Chests"));
		wcs.setUsers(systemYaml.getStringList("TotalUsers"));
		wcs.setTeleportPads(getPads(systemYaml));
		wcs.setMarketSigns(systemYaml.getStringList("MarketSigns"));
		pl.wcSystem.put("system", wcs);
	}
	
	public List<Location> getPads(YamlConfiguration systemYaml){
		List<Location> locs = new ArrayList<>();
		for (String s : systemYaml.getStringList("TeleportPads")){
			String[] a = s.split(" ");
			locs.add(new Location(Bukkit.getWorld(a[0]), Double.parseDouble(a[1]), Double.parseDouble(a[2]), Double.parseDouble(a[3])));
		}
		return locs;
	}
	
	public List<String> getPads2(){
		WCSystem wcs = getWCSystem("system");
		List<String> locs = new ArrayList<>();
		for (Location l : wcs.getTeleportPads()){
			locs.add(l.getWorld().getName() + " " + l.getX() + " " + l.getY() + " " + l.getZ());
		}
		return locs;
	}
	
	public void saveSystem(YamlConfiguration systemYaml, File systemFile) throws IOException{
		
		WCSystem wcs = getWCSystem("system");
		systemYaml.set("ParagonTotal", wcs.getParagonTotal());
		systemYaml.set("ParagonTier", wcs.getParagonTier());
		systemYaml.set("ParagonNewListSize", wcs.getParagonNewListSize());
		systemYaml.set("EmotesList", wcs.getEmotes());
		systemYaml.set("EmoteActions", wcs.getEmoteActions());
		systemYaml.set("Obelisks", wcs.getObelisks());
		systemYaml.set("Chests", wcs.getChests());
		systemYaml.set("TotalUsers", wcs.getUsers());
		systemYaml.set("TeleportPads", getPads2());
		systemYaml.set("MarketSigns", wcs.getMarketSigns());
		systemYaml.save(systemFile);
	}
	
	public String getFullNick(String player){
		WCPlayer wcp = getWCPlayer(player);
		WCAlliance wca = getWCAlliance(wcp.getAlliance());
		return getCompleted(wcp.getNick(), wca.getColor1(), wca.getColor2());
	}
	
	  
	public void userCreate(Player p) {
			
		File file = new File("./plugins/WaterCloset/Users/" + p.getName() + ".yml");
		
		if (!file.exists() || !getWCSystem("system").getUsers().contains(p.getName())){
			
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
				
			pl.getLogger().log(Level.INFO, "New user file created for " + p.getName() + "!");
			YamlConfiguration yaml = YamlConfiguration.loadConfiguration(file);
				
			yaml.set("Chat.GlobalColor", "f");
			yaml.set("Chat.PMColor", "d");
			yaml.set("Inviter", "empty");
			yaml.set("Invite", "empty");
			yaml.set("AllianceRank2", "Guest");
			yaml.set("AllianceColor", "b");
			yaml.set("LastChat", "Hugh_Jasses");
			yaml.set("Alliance", "ForeverAlone");
			yaml.set("Pokes", true);
			yaml.set("Emotes", true);
			yaml.set("ItemThrow", true);
			yaml.set("Fireworks", true);
			yaml.set("Scoreboard", true);
			yaml.set("ScoreboardCoords", false);
			yaml.set("HomeSounds", true);
			yaml.set("RootShortCut", true);
			yaml.set("NamePlate", true);
			yaml.set("Nick", p.getName());
			yaml.set("JoinMessage", "Joined!");
			yaml.set("QuitMessage", "Left!");
			yaml.set("Rank", "Guest");
			yaml.set("Prefix", "");
			yaml.set("Transfered", true);
			
			WCSystem wcs = getWCSystem("system");
			List<String> users = wcs.getUsers();
			users.add(p.getName());
			wcs.setUsers(users);
			updateSystem("system", wcs);
				
			try {
				yaml.save(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
				
			setupPlayer(p.getName());			
			Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&6Welcome &7" + p.getDisplayName() + " &6to Worlds Apart! :)"));
		}
	}
}
