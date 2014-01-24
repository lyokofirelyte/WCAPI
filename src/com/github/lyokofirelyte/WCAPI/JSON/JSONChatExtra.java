package com.github.lyokofirelyte.WCAPI.JSON;


import java.util.List;

public class JSONChatExtra {
	
    private JSONObject chatExtra;

    public JSONChatExtra(String text, JSONChatColor color, List<JSONChatFormat> formats) {
    	
        chatExtra = new JSONObject();
        chatExtra.put("text", text);
        
        if (color != null){
        	chatExtra.put("color", color.getColorString());
        }
        
        if (formats != null){
        	for (JSONChatFormat format : formats) {
        		chatExtra.put(format.getFormatString(), true);
        	}
        }
    }

    public void setClickEvent(JSONChatClickEventType action, String value) {
        JSONObject clickEvent = new JSONObject();
        clickEvent.put("action", action.getTypeString());
        clickEvent.put("value", value);
        chatExtra.put("clickEvent", clickEvent);
    }

    public void setHoverEvent(JSONChatHoverEventType action, String value) {
        JSONObject hoverEvent = new JSONObject();
        hoverEvent.put("action", action.getTypeString());
        hoverEvent.put("value", value);
        chatExtra.put("hoverEvent", hoverEvent);
    }

    public JSONObject toJSON() {
        return chatExtra;
    }
}