package com.github.lyokofirelyte.WCAPI;

import org.bukkit.plugin.java.JavaPlugin;

public abstract class WCNode extends JavaPlugin {
	
	/* Represents a plugin hooking into the API */
	
	public static String name;
	
	public WCNode(){
		
		name = "WC";
		
	}
	
	WCAPI api;

	public WCAPI getAPI(){	
		
		if (api == null){
			api = (WCAPI) getServer().getPluginManager().getPlugin("WCAPI");
		}
		
		return api;
	}
	
	public void setTitle(String name){
		
		this.name = name;
		
	}
	
}