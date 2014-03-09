package com.github.lyokofirelyte.WCAPI.Command;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

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
    								Player p = ((Player)sender);
    								WCCommand anno = m.getAnnotation(WCCommand.class);
    								if (p.hasPermission(anno.perm())){
    									if (args.length > anno.max() || args.length < anno.min()){
    										WCUtils.s(p, anno.help());
    										return true;
    									}     
    									if (anno.name().equals("none")){
    										m.invoke(obj, p, args);
    									} else {
    										m.invoke(obj, p, args, label);
    									}
    								} else {
    									WCUtils.s(p, "&4No permission!");
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