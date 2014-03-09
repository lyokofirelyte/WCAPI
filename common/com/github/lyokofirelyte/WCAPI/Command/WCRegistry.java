package com.github.lyokofirelyte.WCAPI.Command;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.SimplePluginManager;

import com.github.lyokofirelyte.WCAPI.WCAPI;
import com.github.lyokofirelyte.WCAPI.WCLink;
import com.github.lyokofirelyte.WCAPI.WCUtils;

public class WCRegistry extends WCLink implements CommandExecutor {
          
        public WCRegistry(WCAPI i) {
        	super(i);
        }
        
        public static void args(Object clazz, CommandSender s, String cmd, String[] args){
    		
    		for (int i = 0; i < args.length; i++){
    			
    			args[i] = args[i].toLowerCase();
    			
    		}
    		
    		try {
    			
    			boolean triggered = false;
    			
    			for (Method m : clazz.getClass().getMethods()){
    				
    				WCArg anno = m.getAnnotation(WCArg.class);
    				
    				if (anno != null){
    					
    					for (String arg : anno.refs()){
    						
    						if (arg.equalsIgnoreCase(args[0])){
    							
    							if (s.hasPermission(anno.perm())){
    								
    								triggered = true;
    								
    								if (anno.player()){
    									
    									if (s instanceof Player){
    										
    										m.invoke(clazz, (Player) s, args);
    										
    									} else {
    										
    										WCUtils.s(s, "&cConsole players cannot run this command!");
    										
    									}
    									
    								} else {
    									
    									m.invoke(clazz, s, args);
    									
    								}
    								
    							} else {
    								
    								WCUtils.s(s, "&cYou don't have permission for that!");
    								
    							}
    							
    						}
    						
    					}
    					
    				}
    				
    			}
    			
    			if (!(triggered)){
    				
    				WCUtils.s(s, "&cUnknown argument! Try &6/mm ?&c.");
    				
    			}
    			
    		} catch (Exception e){
    			
    			Bukkit.getLogger().log(Level.SEVERE, "An internal error has occured involving the command '" + cmd + "'!");
    			e.printStackTrace();
    			
    		}
    		
    	}

		public void registerCommands(List<Object> classes){
                
                //SimplePluginManager spm = (SimplePluginManager) Bukkit.getServer().getPluginManager();
                Field f = null;
                CommandMap scm = null;
                
                try {
                        f = SimplePluginManager.class.getDeclaredField("commandMap");
                        f.setAccessible(true);
                        scm = (CommandMap) f.get(Bukkit.getPluginManager());
                } catch (Exception e1) {
                        e1.printStackTrace();
                }
                
                for (Object obj : classes){
                    for (Method method : obj.getClass().getMethods()) {
                        if (method.getAnnotation(WCCommand.class) != null){
                                WCCommand anno = method.getAnnotation(WCCommand.class);
                            try {
                                    WCCmd command = new WCCmd(anno.aliases()[0]);
                                    command.setUsage(anno.help());
                                    command.setAliases(Arrays.asList(anno.aliases()));
                                    command.setDescription(anno.desc());
                                    if (scm.getCommand(anno.aliases()[0]) != null){
                                    	scm.getCommand(anno.aliases()[0]).unregister(scm);
                                    }
                                    scm.register("wc", command);
                                    command.setExecutor(this);
                                    WCAPI.commandMap.put(Arrays.asList(anno.aliases()), obj);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
        }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

    	for (List<String> cmdList : WCAPI.commandMap.keySet()){
    		if (cmdList.contains(label)){
    			for (String command : cmdList){
    				if (command.equals(label)){
    					Object obj = WCAPI.commandMap.get(cmdList);
    					for (Method m : obj.getClass().getMethods()){
    						if (m.getAnnotation(WCCommand.class) != null && Arrays.asList(m.getAnnotation(WCCommand.class).aliases()).contains(command)){
    							try {
    								WCCommand anno = m.getAnnotation(WCCommand.class);
    								if (sender.hasPermission(anno.perm())){
    									if (args.length > anno.max() || args.length < anno.min()){
    										WCUtils.s(sender, anno.help());
    										return true;
    									}     
    									if (anno.name().equals("none")){
    										
    										if (anno.player()){
    											
    											m.invoke(obj, (Player) sender, args);
    											
    										} else {
    											
    											m.invoke(obj, sender, args);
    											
    										}
    										
    									} else {
    										
    										if (anno.player()){
    											
    											m.invoke(obj, (Player) sender, args, label);
    											
    										} else {
    											
    											m.invoke(obj, sender, args, label);
    											
    										}
    										
    									}
    								} else {
    									WCUtils.s(sender, "&4No permission!");
    								}
    							} catch (Exception e) {
    								e.printStackTrace();
    							}
    						}
    					}
    				}
    			}
    		}
    	}
    	return true;
    }
}