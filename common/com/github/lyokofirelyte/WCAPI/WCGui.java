package com.github.lyokofirelyte.WCAPI;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public abstract class WCGui {
	
	public String title;
	public int slot;
	public ItemStack item;
	
	public InventoryClickEvent click;
	public InventoryDragEvent drag;
	public InventoryMoveItemEvent move;
	public InventoryInteractEvent interact;
	
	public String current;
	
	public Inventory inv;
	
	public WCGui(int slots, String title){
		
		this.inv = Bukkit.createInventory(null, slots, WCManager.AS(title));
		this.title = title;
		
	}
	
	public abstract void create();
	
	public abstract void actionPerformed(Player p);
	
	public Inventory getInv(){
		
		return inv;
		
	}
	
	public void setInv(Inventory a){
		inv = a;
	}
	
	protected void addButton(int slot, ItemStack item){
		
		inv.setItem(slot, item);
		
	}
	
}