package com.github.lyokofirelyte.WCAPI;

public abstract class WCLink {
	
	public WCAPI pl;
	
	public WCLink(WCAPI i){
		pl = i;
	}

	/* Represents a link to the API that can be accessed from other plugins */
	/* Extending this gives a constructor for the main API class. */
}
