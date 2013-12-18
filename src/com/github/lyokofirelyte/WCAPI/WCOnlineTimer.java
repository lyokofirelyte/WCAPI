package com.github.lyokofirelyte.WCAPI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class WCOnlineTimer implements Listener {
	
	WCAPI pl;
	
	public WCOnlineTimer(WCAPI instance){
		pl = instance;
	}
	
    String url;
    String table;
    String username;
    String password;
    Boolean init = false;

    Map <String, Long> playerTime = new HashMap<>();
    
    public void init(){
    	
        url = pl.systemYaml.getString("TimerURL");
        table = pl.systemYaml.getString("TimerTable");
        username = pl.systemYaml.getString("TimerUser");
        password = pl.systemYaml.getString("TimerPass");
    }
    
    @EventHandler(priority = EventPriority.NORMAL)
    public void onLogin(PlayerJoinEvent e){
    	
    	if (!init){
    		init();
    		init = true;
    	}
    	
    	playerTime.put(e.getPlayer().getName(), (System.currentTimeMillis() / 1000L));
    }
    
    @EventHandler(priority=EventPriority.MONITOR)
    public void onPlayerQuit(PlayerQuitEvent e) {
    	
	    if (!init){
	    	init();
	    	init = true;
	    }
    	
	    String name = e.getPlayer().getName();

	    if (playerTime.containsKey(name)) {
    	  
	        long login = (playerTime.get(name));
	        long logout = System.currentTimeMillis() / 1000L;
	
	        int time = ((int)(logout - login));
	
	        playerTime.remove(name);
	
	        runTask(name, time);
	    }
    }
    	
    protected void runTask(String name, int time){

    	try {
    		
          Connection conn = DriverManager.getConnection(url, username, password);
          String query = "INSERT INTO " + table + "(Username, Time0, Time1) VALUES(?, ?, ?) ON DUPLICATE KEY UPDATE Time0=Time0+VALUES(Time0), Time1=Time1+VALUES(Time1)";
          PreparedStatement pst = conn.prepareStatement(query);

          pst.setString(1, name);
          pst.setInt(2, time);
          pst.setInt(3, time);
          pst.executeUpdate();
          pst.close();
          conn.close();
          
        } catch (SQLException e) {
          e.printStackTrace();
        }
    }
}
