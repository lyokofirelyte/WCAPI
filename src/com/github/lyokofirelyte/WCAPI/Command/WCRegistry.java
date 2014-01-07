package com.github.lyokofirelyte.WCAPI.Command;

import java.lang.reflect.Constructor;
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
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.SimplePluginManager;

import com.github.lyokofirelyte.WCAPI.WCAPI;
import com.github.lyokofirelyte.WCAPI.WCUtils;

public class WCRegistry implements CommandExecutor {
        
        WCAPI pl;
        public WCRegistry(WCAPI i){
                pl = i;
        }
        
        public void registerCommands(List<Class<?>> cls, Plugin plugin){
                
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
                
                for (Class<?> c : cls){
                    for (Method method : c.getMethods()) {
                        if (method.getAnnotation(WCCommand.class) != null){
                                WCCommand anno = method.getAnnotation(WCCommand.class);
                            try {
                                    WCCmd command = new WCCmd(anno.aliases()[0]);
                                    command.setUsage(anno.help());
                                    command.setAliases(Arrays.asList(anno.aliases()));
                                    command.setDescription(anno.desc());
                                    /*if (spm.getPermission(anno.perm()) == null){
                                            Permission perm = new Permission(anno.perm());
                                            spm.addPermission(perm);
                                    }*/
                                    scm.register("wc", command);
                                    command.setExecutor(this);
                                    WCAPI.commandMap.put(Arrays.asList(anno.aliases()), c);
                                    for (String al : anno.aliases()){
                                            WCAPI.commandAssignments.put(al, plugin);
                                    }
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
    					for (Method m : WCAPI.commandMap.get(cmdList).getMethods()){
    						if (m.getAnnotation(WCCommand.class) != null && Arrays.asList(m.getAnnotation(WCCommand.class).aliases()).contains(command)){
    							try {
    								Player p = ((Player)sender);
    								if (p.hasPermission(m.getAnnotation(WCCommand.class).perm())){
    									Constructor<?> cont = Class.forName(WCAPI.commandMap.get(cmdList).getName()).getConstructor(WCAPI.commandAssignments.get(command).getClass());
    									Object obj = cont.newInstance(new Object[] { WCAPI.commandAssignments.get(command)});        
    									if (m.getAnnotation(WCCommand.class).name().equals("none")){
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