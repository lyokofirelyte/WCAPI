package com.github.lyokofirelyte.WCAPI;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

import com.github.lyokofirelyte.WCAPI.Command.WCRegistry;
import com.github.lyokofirelyte.WCAPI.JSON.JSONChatMessage;
import com.github.lyokofirelyte.WCAPI.Loops.LoopSetup;
import com.github.lyokofirelyte.WCAPI.Manager.FileManager;
import com.github.lyokofirelyte.WCAPI.Manager.InventoryManager;
import com.github.lyokofirelyte.WCAPI.Manager.RebootManager;
import com.github.lyokofirelyte.WCAPI.Manager.WCMessageType;

public class WCAPI extends JavaPlugin implements PluginMessageListener {
        
        public Map <String, WCPlayer> wcPlayers = new HashMap<>();
        public Map <String, WCAlliance> wcAlliances = new HashMap<>();
        public Map <String, WCSystem> wcSystem = new HashMap<>();
        public Map <String, WCPatrol> wcPatrols = new HashMap<>();
        public Map <String, List<JSONChatMessage>> latestMessages = new HashMap<>();
        public static Map <List<String>, Object> commandMap = new HashMap<>();
        
        File systemFile;
        YamlConfiguration systemYaml;
        
        int users = 0;
        
        public InventoryManager invManager;
        public WCManager wcm;
        public WCRegistry reg;
        public FileManager fm;
        public LoopSetup ls;

        public void onEnable(){
        	
            getServer().getMessenger().registerOutgoingPluginChannel(this, "WCNAPI");
            getServer().getMessenger().registerIncomingPluginChannel(this, "WCNAPI", this);
                
        	systemFile = new File("./plugins/WaterCloset/system.yml");
        	systemYaml = YamlConfiguration.loadConfiguration(systemFile);
                
        	getLogger().log(Level.INFO, "Loading all users and all alliances...");
                
        	new RebootManager(this).scheduleReboot();
        	wcm = new WCManager(this);
        	invManager = new InventoryManager(this);
        	reg = new WCRegistry(this);
        	ls = new LoopSetup(this);
        	fm = new FileManager(this);
                
        	getServer().getPluginManager().registerEvents(wcm, this);
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
        
        public void sendMessage(String message) {
        	
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            DataOutputStream out = new DataOutputStream(stream);
            
            try {
				out.writeUTF(message);
			} catch (IOException e) {
				e.printStackTrace();
			}
     
            getServer().getOnlinePlayers()[0].sendPluginMessage(this, "WCNAPI", stream.toByteArray());
        }
     
        @Override
        public void onPluginMessageReceived(String channel, Player player, byte[] bytes) {
        	
            if (!channel.equals("WCNAPI")) {
                return;
            }
       
            ByteArrayInputStream stream = new ByteArrayInputStream(bytes);
            DataInputStream in = new DataInputStream(stream);
            
            try {
				readData(in.readUTF());
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
        
        public void readData(String data){
        	
    		// ORIGIN_SERVER %s% CHANNEL %s% USER %s% MESSAGE     or, if not global/staff channel,
    		// ORIGIN_SERVER %s% CHANNEL %s% MESSAGE
    		
    		String[] datas = data.split("%s%");
    		String svr = datas[0];
    		String channel = datas[1];
    		
    		if (svr.equals(getServer().getName())){
    			return;
    		}
    		
    		switch (channel){
    		
    			case "Global":
    				
    				for (Player p : Bukkit.getOnlinePlayers()){
    					WCUtils.s2(p, "&5WC &" + WCUtils.getServerColor(svr) + " // &7" + datas[2] + "&f: " + datas[3]);
    				}
    				
    			break;
    			
    			case "ChangeChannel":
    				
    				wcm.getWCPlayer(datas[2]).setChannel(datas[3]);
    				
    			break;
    		}
        }
}