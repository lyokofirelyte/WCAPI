package com.github.lyokofirelyte.WCAPI;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.plugin.Plugin;

public interface WCMap {

	/* Map to store all WCPlayer information */
	public Map <String, WCPlayer> wcPlayers = new HashMap<>();
	
	/* Map to store all WCAlliance information */
	public Map <String, WCAlliance> wcAlliances = new HashMap<>();
	
	/* Map to store general system information */
	public Map <String, WCSystem> wcSystem = new HashMap<>();
	
	/* Map to store all WCPatrol information */
	public Map <String, WCPatrol> wcPatrols = new HashMap<>();
	
	/* Map to store commands to be registered later */
	public static Map <List<String>, Class<?>> commandMap = new HashMap<>();
	
	/* Map to store the connection between commands and plugins */
	public static Map<String, Plugin> commandAssignments = new HashMap<>();
}
