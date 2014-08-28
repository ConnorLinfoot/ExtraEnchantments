package com.connorlinfoot.extraenchantments.Listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class Smeltery implements Listener {

    @EventHandler
    public void onBlockBreak( BlockBreakEvent e ){
        if( e.getPlayer().getItemInHand() != null || e.getPlayer().getItemInHand().getType() == Material.AIR ) {
            if (e.getBlock().getType() == Material.IRON_ORE) {
                Player p = e.getPlayer();
                ItemStack item = p.getItemInHand();
                if( e.getBlock().getDrops().isEmpty() ) return;
                if (String.valueOf(item.getItemMeta().getLore()).contains("Smeltery III")) {
                    item.setDurability((short) 1);
                    e.getBlock().getDrops().clear();
                    e.getBlock().setType(Material.AIR);
                    e.getBlock().getWorld().dropItem(e.getBlock().getLocation(), new ItemStack(Material.IRON_INGOT));
                    e.getBlock().getWorld().dropItem(e.getBlock().getLocation(), new ItemStack(Material.EXP_BOTTLE));
                } else if (String.valueOf(item.getItemMeta().getLore()).contains("Smeltery II")) {
                    item.setDurability((short) 1);
                    e.getBlock().getDrops().clear();
                    e.getBlock().setType(Material.AIR);
                    e.getBlock().getWorld().dropItem(e.getBlock().getLocation(), new ItemStack(Material.IRON_INGOT));
                    e.getBlock().getWorld().dropItem(e.getBlock().getLocation(), new ItemStack(Material.EXP_BOTTLE));
                } else if (String.valueOf(item.getItemMeta().getLore()).contains("Smeltery I")) {
                    item.setDurability((short) 1);
                    e.getBlock().getDrops().clear();
                    e.getBlock().setType(Material.AIR);
                    e.getBlock().getWorld().dropItem(e.getBlock().getLocation(), new ItemStack(Material.IRON_INGOT));
                }
            } else if (e.getBlock().getType() == Material.GOLD_ORE) {
                Player p = e.getPlayer();
                ItemStack item = p.getItemInHand();
                if( e.getBlock().getDrops().isEmpty() ) return;
                if (String.valueOf(item.getItemMeta().getLore()).contains("Smeltery III")) {
                    item.setDurability((short) 1);
                    e.getBlock().getDrops().clear();
                    e.getBlock().setType(Material.AIR);
                    e.getBlock().getWorld().dropItem(e.getBlock().getLocation(), new ItemStack(Material.GOLD_INGOT));
                    e.getBlock().getWorld().dropItem(e.getBlock().getLocation(), new ItemStack(Material.EXP_BOTTLE));
                } else if (String.valueOf(item.getItemMeta().getLore()).contains("Smeltery II")) {
                    item.setDurability((short) 1);
                    e.getBlock().getDrops().clear();
                    e.getBlock().setType(Material.AIR);
                    e.getBlock().getWorld().dropItem(e.getBlock().getLocation(), new ItemStack(Material.GOLD_INGOT));
                    e.getBlock().getWorld().dropItem(e.getBlock().getLocation(), new ItemStack(Material.EXP_BOTTLE));
                } else if (String.valueOf(item.getItemMeta().getLore()).contains("Smeltery I")) {
                    item.setDurability((short) 1);
                    e.getBlock().getDrops().clear();
                    e.getBlock().setType(Material.AIR);
                    e.getBlock().getWorld().dropItem(e.getBlock().getLocation(), new ItemStack(Material.GOLD_INGOT));
                }
            }
        }
    }

}
