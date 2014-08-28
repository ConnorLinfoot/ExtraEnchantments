package com.connorlinfoot.extraenchantments.Tools;


import com.connorlinfoot.extraenchantments.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Smeltery {
    public static ItemStack getTool(Material material, Integer level){
        ItemStack is = new ItemStack(material);
        return getTool(is,level);
    }

    public static ItemStack getTool(ItemStack is, Integer level){
        is.addUnsafeEnchantment(Main.ench, 1);
        ItemMeta im = is.getItemMeta();
        ArrayList<String> lore = new ArrayList<String>();
        if( level == 2 ){
            lore.add(ChatColor.DARK_GRAY + "Smeltery II");
        } else if( level == 3 ){
            lore.add(ChatColor.DARK_GRAY + "Smeltery III");
        } else {
            lore.add(ChatColor.DARK_GRAY + "Smeltery I");
        }
        im.setLore(lore);
        is.setItemMeta(im);
        return is;
    }
}