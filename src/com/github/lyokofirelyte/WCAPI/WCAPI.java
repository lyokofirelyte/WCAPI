package com.github.lyokofirelyte.WCAPI;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;


public class WCAPI extends JavaPlugin {
	
	public Map <String, WCPlayer> wcPlayers = new HashMap<>();
	public Map <String, WCAlliance> wcAlliances = new HashMap<>();
	
	private RebootManager r;
	public WCManager wcm;

	public void onEnable(){
		
		getLogger().log(Level.INFO, "Loading online users and all alliances...");
		
		r = new RebootManager(this);
		wcm = new WCManager(this);
		r.scheduleReboot();
		for (Player p : Bukkit.getOnlinePlayers()){
			wcm.setupPlayer(p.getName());
		}
		
		  try {
			wcm.foreverAlone();
		  } catch (IOException e) {
			e.printStackTrace();
		  }

		wcm.setupAlliances();

	}

	public void onDisable(){
		getLogger().log(Level.INFO, "WCAPI has been disabled.");
		for (Player p : Bukkit.getOnlinePlayers()){
			try {
				wcm.savePlayer(p.getName());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			wcm.saveAlliances();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public RebootManager getRebootManager() {
		return r;
	}
	
}
