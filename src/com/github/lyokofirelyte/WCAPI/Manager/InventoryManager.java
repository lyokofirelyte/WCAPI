package com.github.lyokofirelyte.WCAPI.Manager;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.github.lyokofirelyte.WCAPI.WCAPI;

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
}