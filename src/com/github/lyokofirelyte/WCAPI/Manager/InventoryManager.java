package com.github.lyokofirelyte.WCAPI.Manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.github.lyokofirelyte.WCAPI.WCAPI;
import com.github.lyokofirelyte.WCAPI.WCManager;

public class InventoryManager {
	
	WCAPI pl;
	
	public InventoryManager(WCAPI instance){
	pl = instance;
	}
	
	ItemStack i;
	ItemMeta iMeta;
	List<String> loreSplit;
	
	public ItemStack makeItem(String dispName, String lore, Boolean e, Enchantment enchant, int amplifier, int itemType, Material mat, int itemAmount){
		
		i = new ItemStack(mat, itemAmount, (short) itemType);
        iMeta = i.getItemMeta();
    	List<String> loreList = new ArrayList<>();
    	loreList.add(lore);
        
        if (e){
        	iMeta.addEnchant(enchant, amplifier, true);
        }

        iMeta.setDisplayName(dispName);
        iMeta.setLore(loreList);
        i.setItemMeta(iMeta);
		
		return i;
	}
	
	public static ItemStack createItem(String display, String[] lore, Material mat, int... data){
		
		ItemStack item = null;
		
		switch (data.length){
		
		default:
			
			item = new ItemStack(mat, 1);
			break;
			
		case 1:
			
			item = new ItemStack(mat, data[0]);
			break;
			
		case 2:
			
			item = new ItemStack(mat, data[0], (short) data[1]);
			break;
			
		}
		
		ItemMeta meta = item.getItemMeta();
		lore = WCManager.AS(lore);
		List<String> loreL = Arrays.asList(lore);
		
		meta.setDisplayName(WCManager.AS(display));
		meta.setLore(loreL);
		item.setItemMeta(meta);
		
		return item;
		
	}
	
	public static ItemStack createItem(String display, String[] lore, short durability, Material mat, int... data){
		
		ItemStack item = createItem(display, lore, mat, data);
		item.setDurability(durability);
		
		return item;
		
	}
	
	public static ItemStack createItem(String display, String[] lore, Enchantment enchant, int amp, Material mat, int... data){
		
		ItemStack item = createItem(display, lore, mat, data);
		ItemMeta meta = item.getItemMeta();
		
		meta.addEnchant(enchant, amp, true);
		item.setItemMeta(meta);
		
		return item;
		
	}
	
	public static ItemStack createItem(String display, String[] lore, Enchantment enchant, int amp, short durability, Material mat, int... data){
		
		ItemStack item = createItem(display, lore, durability, mat, data);
		ItemMeta meta = item.getItemMeta();
		
		meta.addEnchant(enchant, amp, true);
		item.setItemMeta(meta);
		
		return item;
		
	}
	
}