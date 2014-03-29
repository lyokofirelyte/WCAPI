package com.github.lyokofirelyte.WCAPI.Loops;

import org.bukkit.plugin.Plugin;

import com.github.lyokofirelyte.WCAPI.WCAPI;
import com.github.lyokofirelyte.WCAPI.WCLink;

public class LoopSetup extends WCLink {

	public LoopSetup(WCAPI i) {
		super(i);
	}

	public void callLoop(String method, final Object clazz, final Object... args){
		
		LoopControl l = new LoopControl(this.pl);
		l.callLoop(clazz, method, args);
	}
	
	@Deprecated
	public void callLoop(Plugin plugin, final Object clazz, String method, final Object... args){
		
		callLoop(method, clazz, args);
	}
	
	public void callDelay(String method, final Object clazz, final Object... args){
		
		DelayControl dl = new DelayControl(this.pl);
		dl.callDelay(clazz, method, args);
	}
	
	@Deprecated
	public void callDelay(Plugin plugin, final Object clazz, String method, final Object... args){
		
		callDelay(method, clazz, args);
	}
}