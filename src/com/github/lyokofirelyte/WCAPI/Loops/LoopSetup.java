package com.github.lyokofirelyte.WCAPI.Loops;

import java.lang.reflect.Method;

import org.bukkit.plugin.Plugin;

import com.github.lyokofirelyte.WCAPI.WCAPI;

public class LoopSetup {

	WCAPI pl;
	
	public LoopSetup(WCAPI i){
		pl = i;
	}
	
	public void callLoop(Method m, Class<?> c, Plugin pl){
		
		LoopControl l = new LoopControl(this.pl);
		l.callLoop(m, c, pl);
	}
	
	public void callDelay(Method m, Class<?> c, Plugin pl){
	
		DelayControl d = new DelayControl(this.pl);
		d.callDelay(m, c, pl);
	}
}
