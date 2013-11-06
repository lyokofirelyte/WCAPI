package com.github.lyokofirelyte.WCAPI;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.lyokofirelyte.WCAPI.Manager.InventoryManager;
import com.github.lyokofirelyte.WCAPI.Manager.RebootManager;


public class WCAPI extends JavaPlugin {
	
	public Map <String, WCPlayer> wcPlayers = new HashMap<>();
	public Map <String, WCAlliance> wcAlliances = new HashMap<>();
	public Map <String, WCSystem> wcSystem = new HashMap<>();
	
	File usersFile;
	File systemFile;
	YamlConfiguration usersYaml;
	YamlConfiguration systemYaml;
	
	List<String> users;
	
	public RebootManager r;
	public InventoryManager invManager;
	public WCManager wcm;

	public void onEnable(){
		
		getLogger().log(Level.INFO, "Loading all users and all alliances...");
		
		r = new RebootManager(this);
		wcm = new WCManager(this);
		invManager = new InventoryManager(this);
		
		r.scheduleReboot();
		
		usersFile = new File("./plugins/WaterCloset/datacore.yml");
		systemFile = new File("./plugins/WaterCloset/system.yml");
		
		usersYaml = YamlConfiguration.loadConfiguration(usersFile);
		systemYaml = YamlConfiguration.loadConfiguration(systemFile);
		
		users = systemYaml.getStringList("TotalUsers");
		
		for (String user : users){
			wcm.setupPlayer(user);
		}
		
		wcm.setupSystem(systemYaml);
		wcm.setupAlliances();
		
		Bukkit.broadcastMessage("§dWC §5// §aWCAPI IS ENABLED! §2Loaded " + users.size() + " §2users!");
		getLogger().log(Level.INFO, "Loaded " + users.size() + " users!");
	}

	public void onDisable(){
		
		getLogger().log(Level.INFO, "WCAPI has been disabled. Saving all users and alliances...");
		
		users = systemYaml.getStringList("TotalUsers");
		
		for (String user : users){
			try {
				wcm.savePlayer(user);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		Bukkit.broadcastMessage("§dWC §5// §4WCAPI IS DISABLED! §cSaved " + users.size() + " §cusers!");
		
		try {
			wcm.saveAlliances();
			wcm.saveSystem(systemYaml, systemFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
