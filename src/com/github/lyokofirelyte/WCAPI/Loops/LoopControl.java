package com.github.lyokofirelyte.WCAPI.Loops;


import java.lang.reflect.Constructor;
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
	Object o;
	
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
	
	public void setObject(Object o){
		this.o = o;
	}
	
	public Object getObject(){
		return o;
	}
	
	public void callLoop(final Method m, Class<?> c, final Plugin pl){
		
		if (m.getAnnotation(WCLoop.class) != null){
			
			final WCLoop anno = m.getAnnotation(WCLoop.class);
			setX(0);
			setTask(0);		
			Constructor<?> cont = null;
			
			try {
				cont = Class.forName(c.getName()).getConstructor(pl.getClass());
				setObject(cont.newInstance(new Object[] { pl }));	
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			task = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(pl, new Runnable(){
			public void run() { 
				
				try {
					m.invoke(getObject());
					setX(getX() + 1);
					if (getX() >= anno.repeats()){
						Bukkit.getServer().getScheduler().cancelTask(getTask());
					}
				} catch (Exception e) {
					e.printStackTrace();		
			} } }, anno.delay(), anno.time());
		}
	}
}