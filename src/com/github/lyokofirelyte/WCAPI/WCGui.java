package com.github.lyokofirelyte.WCAPI;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public abstract class WCGui {
	
	public String title;
	public int slot;
	
	private Inventory inv;
	
	public WCGui(int slots, String title){
		
		this.inv = Bukkit.createInventory(null, slots, WCManager.AS(title));
		this.title = title;
		
	}
	
	public abstract void create();
	
	public abstract void actionPerformed(Player p, InventoryClickEvent e);
	
	public Inventory getInv(){
		
		return inv;
		
	}
	
	protected void addButton(int slot, ItemStack item){
		
		inv.setItem(slot, item);
		
	}
	
}
