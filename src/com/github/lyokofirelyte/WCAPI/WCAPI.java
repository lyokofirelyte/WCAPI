package com.github.lyokofirelyte.WCAPI;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.lyokofirelyte.WCAPI.Manager.InventoryManager;
import com.github.lyokofirelyte.WCAPI.Manager.RebootManager;


public class WCAPI extends JavaPlugin {
	
	public Map <String, WCPlayer> wcPlayers = new HashMap<>();
	public Map <String, WCAlliance> wcAlliances = new HashMap<>();
	public Map <String, WCSystem> wcSystem = new HashMap<>();
	public Map <String, Inventory> wcParagonInventory = new HashMap<>();
	
	File systemFile;
	YamlConfiguration systemYaml;
	
	int users = 0;
	
	public RebootManager r;
	public InventoryManager invManager;
	public WCManager wcm;

	public void onEnable(){
		
		systemFile = new File("./plugins/WaterCloset/system.yml");
		systemYaml = YamlConfiguration.loadConfiguration(systemFile);
	
		Bukkit.getServer().getPluginManager().registerEvents(new WCOnlineTimer(this), this);
		
		getLogger().log(Level.INFO, "Loading all users and all alliances...");
		
		r = new RebootManager(this);
		wcm = new WCManager(this);
		invManager = new InventoryManager(this);
		
		r.scheduleReboot();
		
		wcm.setupSystem(systemYaml);
		
		for (String user : wcm.getWCSystem("system").getUsers()){
			wcm.setupPlayer(user);
			users++;
		}

		wcm.setupAlliances();
		
		Bukkit.broadcastMessage("§dWC §5// §aWCAPI IS ENABLED! §2Loaded " + users + " §2users!");
		getLogger().log(Level.INFO, "Loaded " + users + " users!");
	}

	public void onDisable(){
		
		users = 0;
		
		getLogger().log(Level.INFO, "WCAPI has been disabled. Saving all users and alliances...");
		
		for (String user : wcm.getWCSystem("system").getUsers()){
			try {
				wcm.savePlayer(user);
				users++;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		Bukkit.broadcastMessage("§dWC §5// §4WCAPI IS DISABLED! §cSaved " + users + " §cusers!");
		
		try {
			wcm.saveAlliances();
			wcm.saveSystem(systemYaml, systemFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
