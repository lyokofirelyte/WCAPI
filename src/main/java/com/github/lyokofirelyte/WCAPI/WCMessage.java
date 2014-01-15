package com.github.lyokofirelyte.WCAPI;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.github.lyokofirelyte.WCAPI.Events.WCPluginMessageEvent;
import com.github.lyokofirelyte.WCAPI.JSON.JSONChatMessage;

public class WCMessage extends WCLink implements Listener {

	public WCMessage(WCAPI i) {
		super(i);
	}

	@EventHandler
	public void onMessageOut(WCPluginMessageEvent e){
		
		if (e.isCancelled()){
			return;
		}
		
		Player p = e.getPlayer();
		
		switch (e.getMessageType()){
		
			case PLAYER:

				pl.latestMessages.get(p).add(e.getJsonMessage());
				p.sendMessage(e.getMessage());
				cleanList(p);
				break;
				
			case CONSOLE:
				
				Bukkit.getConsoleSender().sendMessage(e.getMessage());
				break;
				
			case BROADCAST:
				
				for (Player p2 : Bukkit.getOnlinePlayers()){		
					pl.latestMessages.get(p2).add(e.getJsonMessage());
					cleanList(p2);
				}
				
				Bukkit.broadcastMessage(e.getMessage());
				break;
				
			case JSON_PLAYER:
				
				pl.latestMessages.get(p).add(e.getJsonMessage());
				e.getJsonMessage().sendToPlayer(p);
				cleanList(p);
				break;
				
			case JSON_BROADCAST:
				
				for (Player p2 : Bukkit.getOnlinePlayers()){		
					pl.latestMessages.get(p2).add(e.getJsonMessage());
					e.getJsonMessage().sendToPlayer(p2);
					cleanList(p2);
				}
				
				break;
		}
	}
	
	public void cleanList(Player p){
		
		if (pl.latestMessages.get(p).size() >= 500){
			List<JSONChatMessage> a = new ArrayList<JSONChatMessage>();
			for (int x = pl.latestMessages.get(p).size()-1; x >= pl.latestMessages.get(p).size() - 51; x--){
				a.add(pl.latestMessages.get(p).get(x));
			}
			pl.latestMessages.put(p, a);
		}
	}
}