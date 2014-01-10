package com.github.lyokofirelyte.WCAPI.Loops;

import java.lang.reflect.Method;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import com.github.lyokofirelyte.WCAPI.WCAPI;

public class DelayControl {

	WCAPI pl;
	
	public DelayControl(WCAPI i){
		pl = i;
	}
	
	int x = 0;
	int task = 0;
	
	public int getTask(){
		return task;
	}
	
	public void setTask(int a){
		task = a;
	}
	
	public void callDelay(Plugin plugin, final Object clazz, final String method, final Object... args){
		
		Class<?> c = clazz.getClass();
		
		try {
			
			Class<?>[] types = new Class<?>[args.length];
			
			for (int i = 0; i < args.length; i++){
				
				types[i] = args[i].getClass();
				System.out.println(types[i].getName());
				
			}
			
			final Method m = c.getMethod(method, types);
			
			if (m.getAnnotation(WCDelay.class) != null){
				
				WCDelay anno = m.getAnnotation(WCDelay.class);
				
				setTask(Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
					
					public void run(){
						
						try {
							
							m.invoke(clazz, args);
							
						} catch (Exception e){
							
							Bukkit.getLogger().severe("An error occured calling the delay method '" + method + "'!");
							
						}
						
					}
					
				}, anno.time()));
				
			} else {
				
				Bukkit.getLogger().severe("The method '" + method + "' does not have the WCDelay annotation!");
				
			}
			
		} catch (Exception e){
			
			Bukkit.getLogger().severe("An error occured calling the delay method '" + method + "'!");
			e.printStackTrace();
			
		}
		
	}
	
}