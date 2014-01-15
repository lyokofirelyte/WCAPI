package com.github.lyokofirelyte.WCAPI;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.lyokofirelyte.WCAPI.Command.WCRegistry;
import com.github.lyokofirelyte.WCAPI.JSON.JSONChatMessage;
import com.github.lyokofirelyte.WCAPI.Loops.LoopSetup;
import com.github.lyokofirelyte.WCAPI.Manager.InventoryManager;
import com.github.lyokofirelyte.WCAPI.Manager.RebootManager;
import com.github.lyokofirelyte.WCAPI.Manager.WCMessageType;


public class WCAPI extends JavaPlugin {
        
        public Map <String, WCPlayer> wcPlayers = new HashMap<>();
        public Map <String, WCAlliance> wcAlliances = new HashMap<>();
        public Map <String, WCSystem> wcSystem = new HashMap<>();
        public Map <String, WCPatrol> wcPatrols = new HashMap<>();
        public Map <Player, List<JSONChatMessage>> latestMessages = new HashMap<>();
        public static Map <List<String>, Class<?>> commandMap = new HashMap<>();
        public static Map<String, Plugin> commandAssignments = new HashMap<>();
        
        File systemFile;
        YamlConfiguration systemYaml;
        
        int users = 0;
        
        public InventoryManager invManager;
        public WCManager wcm;
        public WCRegistry reg;
        public LoopSetup ls;

        public void onEnable(){ 
                
        	systemFile = new File("./plugins/WaterCloset/system.yml");
        	systemYaml = YamlConfiguration.loadConfiguration(systemFile);
                
        	getLogger().log(Level.INFO, "Loading all users and all alliances...");
                
        	new RebootManager(this).scheduleReboot();
        	wcm = new WCManager(this);
        	invManager = new InventoryManager(this);
        	reg = new WCRegistry(this);
        	ls = new LoopSetup(this);
                
        	getServer().getPluginManager().registerEvents(wcm, this);
        	getServer().getPluginManager().registerEvents(new WCOnlineTimer(this), this);
        	getServer().getPluginManager().registerEvents(new WCMessage(this), this);
        	wcm.setupSystem(systemYaml);
                
        	for (String user : wcm.getWCSystem("system").getUsers()){
        		wcm.setupPlayer(user);
        		users++;
        	}

        	wcm.setupAlliances();
                
        	WCUtils.callChat(WCMessageType.BROADCAST, "§dWC §5// §aWCAPI IS ENABLED! §2Loaded " + users + " §2users!");
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
                
        	WCUtils.callChat(WCMessageType.BROADCAST, "§dWC §5// §4WCAPI IS DISABLED! §cSaved " + users + " §cusers!");
                
        	try {
        		wcm.saveAlliances();
        		wcm.saveSystem(systemYaml, systemFile);
        	} catch (IOException e) {
        		e.printStackTrace();
        	}
        }
}