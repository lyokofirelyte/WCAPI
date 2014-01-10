package com.github.lyokofirelyte.WCAPI;

import org.bukkit.plugin.java.JavaPlugin;

public abstract class WCNode extends JavaPlugin {
	
	/* Represents a plugin hooking into the API */

	public WCAPI getAPI(){	
		return (WCAPI) getServer().getPluginManager().getPlugin("WCAPI");
	}
}