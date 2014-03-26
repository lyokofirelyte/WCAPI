package com.github.lyokofirelyte.WCAPI;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.BlockIterator;

import com.github.lyokofirelyte.WCAPI.Events.WCPluginMessageEvent;
import com.github.lyokofirelyte.WCAPI.JSON.JSONChatMessage;
import com.github.lyokofirelyte.WCAPI.Manager.WCMessageType;

public abstract class WCUtils {
	
	public static String WC = "§d" + WCNode.name + " §5// §d";
	
	public static void callChat(Player p, WCMessageType type, String message){
		Bukkit.getPluginManager().callEvent(new WCPluginMessageEvent(p, type, message));
	}
	
	public static void callChat(WCMessageType type, String message){
		Bukkit.getPluginManager().callEvent(new WCPluginMessageEvent(type, message));
	}
	
	public static void callChat(Player p, WCMessageType type, JSONChatMessage message){
		Bukkit.getPluginManager().callEvent(new WCPluginMessageEvent(p, type, message));
	}
	
	public static void callChat(WCMessageType type, JSONChatMessage message){
		Bukkit.getPluginManager().callEvent(new WCPluginMessageEvent(type, message));
	}
	
	public static void callChat(WCMessageType type, Player p){
		Bukkit.getPluginManager().callEvent(new WCPluginMessageEvent(p, type, ""));
	}
	
	public static void bc(String s){
		callChat(WCMessageType.BROADCAST, WC + AS(s));
	}
	
	public static void b(String s){
		callChat(WCMessageType.BROADCAST, WC + AS(s));
	}
	
	public static String getServerColor(String server){
		
		switch (server){
		
			case "WA":
				return "b";
			case "Mark":
				return "e";
			case "waOS":
				return "7";
			case "Platform":
				return "a";
		}
		
		return "f";
	}
	
	public static String[] AS(String[] s){
		
		for (int i = 0; i < s.length; i++){
			
			s[i] = AS(s[i]);
			
		}
		
		return s;
		
	}
	
	public static List<String> AS(List<String> s){
		
		List<String> toReturn = new ArrayList<String>();
		
		for (String ss : s){
			toReturn.add(AS(ss));
		}
		
		return toReturn;
		
	}
	
	public static void s(Player p, String[] s){
		
		p.sendMessage(AS(s));
		
	}
	
	

	public static void b(String[] s){
		
		for (String ss : s){
			
			callChat(WCMessageType.BROADCAST, AS(ss));
			
		}
		
	}
	
	public static void blankB(String s){
		
		callChat(WCMessageType.BROADCAST, s);
		
	}
	
	public static void blankB(String[] s){
		
		for (String ss : s){
			  
			blankB(ss);
			
		}
		
	}
	  
	public static void b2(String s){
		
		callChat(WCMessageType.BROADCAST, WC + AS(s));
		
	}
	
	public static Sound getRandomNote(){
		
		final List<Sound> sounds = Arrays.asList(Sound.NOTE_BASS, Sound.NOTE_BASS_DRUM, Sound.NOTE_BASS_GUITAR, Sound.NOTE_PIANO, Sound.NOTE_PLING, Sound.NOTE_SNARE_DRUM, Sound.NOTE_STICKS);
		
		Random rand = new Random();
		int nextInt = rand.nextInt(sounds.size()-1);
		return sounds.get(nextInt);
	}
	
    public static Boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public static String encrypt(String toEncrypt, String type){ 
    	
        try { 
            MessageDigest digest = MessageDigest.getInstance(type);               
            digest.update(toEncrypt.getBytes()); 
            byte[] bytes = digest.digest();       

            StringBuilder sb = new StringBuilder(); 

            for (int i = 0; i < bytes.length; i++) { 
                sb.append(String.format("%02X", bytes[i])); 
            } 

            return sb.toString().toLowerCase();
        } 
        catch (Exception exc) { return null; }
    }
	
	public static void s(Player p, String s){
		Bukkit.getPluginManager().callEvent(new WCPluginMessageEvent(p, WCMessageType.PLAYER, WC + AS(s)));
	}
	
	public static void s(CommandSender s, String message){
		
		s.sendMessage(AS(WC + message));
		
	}
	
	public static void s(CommandSender s, String[] message){
		
		s.sendMessage(AS(message));
		
	}
		  
	public static void s2(Player p, String s){
		Bukkit.getPluginManager().callEvent(new WCPluginMessageEvent(p, WCMessageType.PLAYER, AS(s)));
	}
	
	public static String getRandomChatColor(){
		
		final List<String> colors = Arrays.asList("&0", "&1", "&2", "&3", "&4", "&5", "&6", "&7", "&8", "&9", "&a", "&b", "&c", "&d", "&e", "&f");
		
		Random rand = new Random();
		int nextInt = rand.nextInt(colors.size()-1);
		return colors.get(nextInt);
	}
	
	public static Color getRandomColor(){
		
		final List<Color> colors = Arrays.asList(Color.SILVER, Color.RED, Color.WHITE, Color.BLUE, Color.ORANGE, Color.FUCHSIA, Color.AQUA, Color.PURPLE, Color.GREEN, Color.TEAL, Color.YELLOW);
	
		Random rand = new Random();
		int nextInt = rand.nextInt(colors.size()-1);
		return colors.get(nextInt);
	}
	
	public static DyeColor getRandomDyeColor(){
		
		final List<DyeColor> colors = Arrays.asList(DyeColor.RED, DyeColor.WHITE, DyeColor.BLUE, DyeColor.ORANGE, DyeColor.GREEN, DyeColor.BLACK, DyeColor.PURPLE, DyeColor.SILVER, DyeColor.YELLOW);
	
		Random rand = new Random();
		int nextInt = rand.nextInt(colors.size()-1);
		return colors.get(nextInt);
	}

	public static String getTime() {
	  	Calendar cal = Calendar.getInstance();
	  	cal.getTime();
	  	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	  	return ( sdf.format(cal.getTime()) );
	}
	
	public static String getTime(Long l) {
	  	Calendar cal = Calendar.getInstance();
	  	cal.setTimeInMillis(l);
	  	SimpleDateFormat sdf = new SimpleDateFormat("M.dd @ HH:mm");
	  	return ( sdf.format(cal.getTime()) );
	  }
	
    public static List<Location> circle (Location loc, Integer r, Integer h, Boolean hollow, Boolean sphere, int plus_y) {
        List<Location> circleblocks = new ArrayList<Location>();
        int cx = loc.getBlockX();
        int cy = loc.getBlockY();
        int cz = loc.getBlockZ();
        for (int x = cx - r; x <= cx +r; x++)
            for (int z = cz - r; z <= cz +r; z++)
                for (int y = (sphere ? cy - r : cy); y < (sphere ? cy + r : cy + h); y++) {
                    double dist = (cx - x) * (cx - x) + (cz - z) * (cz - z) + (sphere ? (cy - y) * (cy - y) : 0);
                    if (dist < r*r && !(hollow && dist < (r-1)*(r-1))) {
                        Location l = new Location(loc.getWorld(), x, y + plus_y, z);
                        circleblocks.add(l);
                        }
                    }
     
        return circleblocks;
    }
    
    public static boolean isInteger(String s) {
        try {
          Integer.parseInt(s);
        } catch (NumberFormatException e) {
          return false;
        }

        return true;
      }

      public static String createString(String[] args, int x) {
    	  
        StringBuilder sb = new StringBuilder();
        
        	for (int i = x; i < args.length; i++){
        		if ((i != x) && (i != args.length)){
        			sb.append(" ");
        		}
        		sb.append(args[i]);
        	}
        	return sb.toString();
      }
      
 	 public static Entity getTarget(final Player player) {
		 
	        BlockIterator iterator = new BlockIterator(player.getWorld(), player
	                .getLocation().toVector(), player.getEyeLocation()
	                .getDirection(), 0, 100);
	        Entity target = null;
	        while (iterator.hasNext()) {
	            Block item = iterator.next();
	            for (Entity entity : player.getNearbyEntities(100, 100, 100)) {
	                int acc = 2;
	                for (int x = -acc; x < acc; x++)
	                    for (int z = -acc; z < acc; z++)
	                        for (int y = -acc; y < acc; y++)
	                            if (entity.getLocation().getBlock()
	                                    .getRelative(x, y, z).equals(item)) {
	                                return target = entity;
	                            }
	            }
	        }
	        return target;
	    }

	public static String AS(String DecorativeToasterCozy){
		
		String FlutterShysShed = ChatColor.translateAlternateColorCodes('&', DecorativeToasterCozy);
		return FlutterShysShed;
		
	}
 	
	public static void effects(Location ll){
		
		List<Location> circleblocks = circle(ll, 3, 1, true, false, 0);
		List<Location> circleblocks2 = circle(ll, 3, 1, true, false, 1);
	
		for (Location l : circleblocks){
			ll.getWorld().playEffect(l, Effect.SMOKE, 0);
			ll.getWorld().playEffect(l, Effect.MOBSPAWNER_FLAMES, 0);
			ll.getWorld().playEffect(l, Effect.ENDER_SIGNAL, 0);
		}
			
		for (Location l : circleblocks2){
			ll.getWorld().playEffect(l, Effect.SMOKE, 0);
			ll.getWorld().playEffect(l, Effect.MOBSPAWNER_FLAMES, 0);
			ll.getWorld().playEffect(l, Effect.ENDER_SIGNAL, 0);
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void specialEffects(Location ll, Material m){
		
		List<Location> circleblocks = circle(ll, 3, 1, true, false, 0);
		List<Location> circleblocks2 = circle(ll, 3, 1, true, false, 1);
	
		for (Location l : circleblocks){
			ll.getWorld().playEffect(l, Effect.STEP_SOUND, m.getId());
		}
			
		for (Location l : circleblocks2){
			ll.getWorld().playEffect(l, Effect.STEP_SOUND, m.getId());
		}
	}
	
	public static void lowerEffects(Location ll){
		
		List<Location> circleblocks = circle(ll, 3, 1, true, false, 0);

		for (Location l : circleblocks){
			ll.getWorld().playEffect(l, Effect.ENDER_SIGNAL, 0);
		}
	}
 	
	public static void effects(Player q){
		
		List<Location> circleblocks = circle(q.getLocation(), 3, 1, true, false, 0);
		List<Location> circleblocks2 = circle(q.getLocation(), 3, 1, true, false, 1);
	
		for (Location l : circleblocks){
			q.getWorld().playEffect(l, Effect.SMOKE, 0);
			q.getWorld().playEffect(l, Effect.MOBSPAWNER_FLAMES, 0);
			q.getWorld().playEffect(l, Effect.ENDER_SIGNAL, 0);
		}
			
		for (Location l : circleblocks2){
			q.getWorld().playEffect(l, Effect.SMOKE, 0);
			q.getWorld().playEffect(l, Effect.MOBSPAWNER_FLAMES, 0);
			q.getWorld().playEffect(l, Effect.ENDER_SIGNAL, 0);
		}
	}
	
	public static Boolean dispName(ItemStack i, String s){
		if (i != null && i.hasItemMeta() && i.getItemMeta().hasDisplayName() && i.getItemMeta().getDisplayName().substring(2).equals(s) && i.getItemMeta().hasLore()){
			return true;
		}
		return false;
	}
	
	public static EntityType getRandomEntity(){
		List<EntityType> entities = new ArrayList<EntityType>();
		entities.add(EntityType.CREEPER);
		entities.add(EntityType.SPIDER);
		entities.add(EntityType.PIG_ZOMBIE);
		entities.add(EntityType.SKELETON);
		entities.add(EntityType.SILVERFISH);
		entities.add(EntityType.SPIDER);
		entities.add(EntityType.ZOMBIE);
		entities.add(EntityType.ZOMBIE);
		entities.add(EntityType.SKELETON);
		Random rand = new Random();
		int sel = rand.nextInt(entities.size());
		return entities.get(sel);
	}
	
}