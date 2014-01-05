package com.github.lyokofirelyte.WCAPI.Loops;

import java.lang.reflect.Method;

import org.bukkit.plugin.Plugin;

import com.github.lyokofirelyte.WCAPI.WCAPI;

public class LoopSetup {

	WCAPI pl;
	
	public LoopSetup(WCAPI i){
		pl = i;
	}
	
	public void callLoop(Method m, Class<?> c, final Plugin pl){
		
		LoopControl l = new LoopControl(this.pl);
		l.callLoop(m, c, pl);
	}
	
	public void callDelay(Method m, Class<?> c, Plugin pl){
		
		DelayControl dl = new DelayControl(this.pl);
		dl.callDelay(m, c, pl);
	}
}