package com.connorlinfoot.extraenchantments.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class LifeTouch implements Listener {
    @EventHandler
    public void onPlayerInteract( PlayerInteractEvent e ){
        Player p = e.getPlayer();
        if( e.getItem() != null ){
            if( String.valueOf(e.getItem().getType()).toUpperCase().contains("CHESTPLATE") ) {
                if (String.valueOf(e.getItem().getItemMeta().getLore()).contains("Life Touch III")) {
                    p.setHealthScale(32);
                } else if (String.valueOf(e.getItem().getItemMeta().getLore()).contains("Life Touch II")) {
                    p.setHealthScale(28);
                } else if (String.valueOf(e.getItem().getItemMeta().getLore()).contains("Life Touch I")) {
                    p.setHealthScale(24);
                }
            }
        }
    }
    @EventHandler
    public void onInventoryClick( InventoryClickEvent e ){
        if( e.getSlot() == 38 ){
            if( e.getCurrentItem() != null){
                Player p = (Player) e.getWhoClicked();
                p.setHealthScale(20);
            }
        }
    }
    @EventHandler
    public void onInventoryClose( InventoryCloseEvent e ){
        Player p = (Player) e.getPlayer();
        if( p.getInventory().getChestplate() != null ){
            if (String.valueOf(p.getInventory().getChestplate().getItemMeta().getLore()).contains("Life Touch III")) {
                p.setHealthScale(32);
            } else if (String.valueOf(p.getInventory().getChestplate().getItemMeta().getLore()).contains("Life Touch II")) {
                p.setHealthScale(28);
            } else if (String.valueOf(p.getInventory().getChestplate().getItemMeta().getLore()).contains("Life Touch I")) {
                p.setHealthScale(24);
            }
        }
    }
    @EventHandler
    public void onPlayerDeath( PlayerDeathEvent e ){
        e.getEntity().setHealthScale(20);
    }
}
