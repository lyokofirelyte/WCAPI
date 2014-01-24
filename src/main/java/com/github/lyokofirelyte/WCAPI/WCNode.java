package com.github.lyokofirelyte.WCAPI;

import org.bukkit.plugin.java.JavaPlugin;

public abstract class WCNode extends JavaPlugin {
	
	/* Represents a plugin hooking into the API */
	
	WCAPI api;

	public WCAPI getAPI(){	
		
		if (api == null){
			api = (WCAPI) getServer().getPluginManager().getPlugin("WCAPI");
		}
		
		return api;
	}
}