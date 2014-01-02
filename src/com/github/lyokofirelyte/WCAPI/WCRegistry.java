package com.github.lyokofirelyte.WCAPI;

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
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.SimplePluginManager;

import static com.github.lyokofirelyte.WCAPI.WCAPI.commandAssignments;
import static com.github.lyokofirelyte.WCAPI.WCAPI.commandMap;

public class WCRegistry implements CommandExecutor {
	
	WCAPI pl;
	WCRegistry(WCAPI i){
		pl = i;
	}
	
	public void registerCommands(List<Class<?>> cls, Plugin plugin){
		
		SimplePluginManager spm = (SimplePluginManager) Bukkit.getServer().getPluginManager();
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
		            	WCCmd command = new WCCmd(Arrays.asList(anno.aliases()).get(0));
		            	command.setUsage(anno.help());
		            	command.setAliases(Arrays.asList(anno.aliases()));
		            	command.setDescription(anno.desc());
		            	if (spm.getPermission(anno.perm()) == null){
		            		Permission perm = new Permission(anno.perm());
		            		spm.addPermission(perm);
		            	}
		            	scm.register("wc", command);
		            	command.setExecutor(this);
		            	commandMap.put(c, Arrays.asList(anno.aliases()));
		            	for (String al : anno.aliases()){
		            		commandAssignments.put(al, plugin);
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

  	  for (Class<?> c : commandMap.keySet()){
  		  for (String command : commandMap.get(c)){
  			  if (label.equalsIgnoreCase(command)){
  				  for (Method m : c.getMethods()){
  					  if (m.getAnnotation(WCCommand.class) != null){
  						  try {
  							Player p = ((Player)sender);
  							if (p.hasPermission(m.getAnnotation(WCCommand.class).perm())){
  								Constructor<?> cont = null;
  								Object obj = null;
  		  						cont = Class.forName(c.getName()).getConstructor(commandAssignments.get(command).getClass());
  		  						obj = cont.newInstance(new Object[] { commandAssignments.get(command)});	
  		  						if (m.getAnnotation(WCCommand.class).name() == ""){
  		  							m.invoke(obj, p, Arrays.asList(args));
  		  						} else {
  		  							m.invoke(obj, p, Arrays.asList(args), cmd.getName());
  		  						}
  							}
  							return true;
  						} catch (Exception e) {
  							e.printStackTrace();
  						}
  					 }
  				  }
  			  }
  		  }
  	  }
  	  return true;
    }
}