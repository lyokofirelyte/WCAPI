package com.github.lyokofirelyte.WCAPI.Loops;


import java.lang.reflect.Constructor;
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
	Object o;
	
	public int getTask(){
		return task;
	}
	
	public void setTask(int a){
		task = a;
	}
	
	public void setObject(Object o){
		this.o = o;
	}
	
	public Object getObject(){
		return o;
	}
	
	public void callDelay(final Method m, Class<?> c, final Plugin pl){
		
		if (m.getAnnotation(WCLoop.class) != null){
			
			final WCLoop anno = m.getAnnotation(WCLoop.class);
			setTask(0);		
			Constructor<?> cont = null;
			
			try {
				cont = Class.forName(c.getName()).getConstructor(pl.getClass());
				setObject(cont.newInstance(new Object[] { pl }));	
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			task = Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(pl, new Runnable(){
			public void run() { 
				
				try {
					m.invoke(getObject());
				} catch (Exception e) {
					e.printStackTrace();		
			} } }, anno.time());
		}
	}
}