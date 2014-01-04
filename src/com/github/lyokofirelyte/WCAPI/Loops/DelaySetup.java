package com.github.lyokofirelyte.WCAPI.Loops;

import java.lang.reflect.Method;

import org.bukkit.plugin.Plugin;

import com.github.lyokofirelyte.WCAPI.WCAPI;

public class DelaySetup {

	WCAPI pl;
	
	public DelaySetup(WCAPI i){
		pl = i;
	}
	
	public void callDelay(Method m, Class<?> c, final Plugin pl){
		
		DelayControl l = new DelayControl(this.pl);
		l.callDelay(m, c, pl);
	}
}
