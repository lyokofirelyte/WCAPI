package com.github.lyokofirelyte.WCAPI.Loops;

import java.lang.reflect.Method;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import com.github.lyokofirelyte.WCAPI.WCAPI;

public class LoopControl {

	WCAPI pl;
	
	public LoopControl(WCAPI i){
		pl = i;
	}
	
	int x = 0;
	int task = 0;
	
	public int getX(){
		return x;
	}
	
	public void setX(int a){
		x = a;
	}
	
	public int getTask(){
		return task;
	}
	
	public void setTask(int a){
		task = a;
	}
	
	public void callLoop(Plugin plugin, final Object clazz, final String method, final Object... args){
		
		Class<?> c = clazz.getClass();
		
		try {
			
			Class<?>[] types = new Class<?>[args.length];
			
			for (int i = 0; i < args.length; i++){
				
				types[i] = args[i].getClass();
				
			}
			
			final Method m = c.getMethod(method, types);
			
			if (m.getAnnotation(WCLoop.class) != null){
				
				final WCLoop anno = m.getAnnotation(WCLoop.class);
				setX(0);
				
				setTask(Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable(){
					
					public void run(){
						
						try {
							
							m.invoke(clazz, args);
							setX(getX() + 1);
							
							if (getX() >= anno.repeats()){
								
								Bukkit.getServer().getScheduler().cancelTask(getTask());
								
							}
							
						} catch (Exception e){
							
							Bukkit.getLogger().severe("An error occured calling the loop method '" + method + "'!");
							
						}
						
					}
					
				}, anno.delay(), anno.time()));
				
			} else {
				
				Bukkit.getLogger().severe("The method '" + method + "' does not have the WCLoop annotation!");
				
			}
			
		} catch (Exception e){
			
			Bukkit.getLogger().severe("An error occured calling the loop method '" + method + "'!");
			e.printStackTrace();
			
		}
		
	}
	
}