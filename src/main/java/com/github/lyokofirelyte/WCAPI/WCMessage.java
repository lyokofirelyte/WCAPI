package com.github.lyokofirelyte.WCAPI;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.github.lyokofirelyte.WCAPI.Events.WCPluginMessageEvent;
import com.github.lyokofirelyte.WCAPI.JSON.JSONChatClickEventType;
import com.github.lyokofirelyte.WCAPI.JSON.JSONChatExtra;
import com.github.lyokofirelyte.WCAPI.JSON.JSONChatHoverEventType;
import com.github.lyokofirelyte.WCAPI.JSON.JSONChatMessage;
import static com.github.lyokofirelyte.WCAPI.WCUtils.*;

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

				pl.latestMessages.get(p.getName()).add(e.getJsonMessage());
				
				if (pl.wcm.getWCPlayer(p.getName()).useChatBar()){
					callBar(p);
				} else {
					p.sendMessage(e.getMessage());
				}
				
				cleanList(p);
				break;
				
			case CONSOLE:
				
				Bukkit.getConsoleSender().sendMessage(e.getMessage());
				break;
				
			case BROADCAST:
				
				for (Player p2 : Bukkit.getOnlinePlayers()){	
					pl.latestMessages.get(p2.getName()).add(e.getJsonMessage());
					
					if (pl.wcm.getWCPlayer(p2.getName()).useChatBar()){
						callBar(p2);
					} else {
						p2.sendMessage(e.getMessage());
					}
					
					cleanList(p2);
				}
				
				break;
				
			case JSON_PLAYER:
				
				pl.latestMessages.get(p.getName()).add(e.getJsonMessage());
				
				if (pl.wcm.getWCPlayer(p.getName()).useChatBar()){
					callBar(p);
				} else {
					e.getJsonMessage().sendToPlayer(p);
				}
				
				cleanList(p);
				break;
				
			case JSON_BROADCAST:
				
				for (Player p2 : Bukkit.getOnlinePlayers()){
					pl.latestMessages.get(p2.getName()).add(e.getJsonMessage());
					
					if (pl.wcm.getWCPlayer(p2.getName()).useChatBar()){
						callBar(p2);
					} else {
						e.getJsonMessage().sendToPlayer(p2);
					}
					
					cleanList(p2);
				}
				
				break;
				
			case BAR:
				
				callBar(p);
				break;
		}
	}
	
	public void cleanList(Player p){
		
		if (pl.latestMessages.get(p.getName()).size() >= 300){
			List<JSONChatMessage> a = new ArrayList<JSONChatMessage>();
			for (int x = pl.latestMessages.get(p.getName()).size()-1; x >= pl.latestMessages.get(p.getName()).size() - 21; x--){
				a.add(pl.latestMessages.get(p.getName()).get(x));
			}
			pl.latestMessages.put(p.getName(), a);
		}
	}
	
	public void callBar(Player p){

		pl.wcm.recallMessages(p);
		
		new JSONChatMessage(AS(""), null, null).sendToPlayer(p);
		
		WCPlayer wcp = pl.wcm.getWCPlayer(p.getName());
		JSONChatMessage bar = new JSONChatMessage(AS("&3" + getTime().substring(0, 5)), null, null);
		JSONChatExtra extra;
		
		extra = new JSONChatExtra(AS(" &7[" + wcp.getMail().size() + "&7] "), null, null);
		extra.setClickEvent(JSONChatClickEventType.RUN_COMMAND, "/mail read");
		bar.addExtra(extra);
		
		extra = new JSONChatExtra(AS("&5[S]"), null, null);
		extra.setClickEvent(JSONChatClickEventType.RUN_COMMAND, "/spawn");
		bar.addExtra(extra);
		
		extra = new JSONChatExtra(AS("&5[R] "), null, null);
		extra.setClickEvent(JSONChatClickEventType.RUN_COMMAND, "/root");
		bar.addExtra(extra);
		
		for (int x = 1; x <= 4; x++){
			if (wcp.getHomes().size() >= x){
				String[] homes = wcp.getHomes().get(x-1).split(" ");
				extra = new JSONChatExtra(AS("&8[" + homes[0] + "]"), null, null);
				extra.setClickEvent(JSONChatClickEventType.RUN_COMMAND, "/home " + homes[0]);
			} else {
				extra = new JSONChatExtra(AS("&8[" + x + "]"), null, null);
			}
			bar.addExtra(extra);
		}
		
		extra = new JSONChatExtra(AS(" &4[X]"), null, null);
		extra.setClickEvent(JSONChatClickEventType.RUN_COMMAND, "/logoff");
		extra.setHoverEvent(JSONChatHoverEventType.SHOW_TEXT, "LEAVE GAME");
		bar.addExtra(extra);
		
		bar.sendToPlayer(p);
	}
}