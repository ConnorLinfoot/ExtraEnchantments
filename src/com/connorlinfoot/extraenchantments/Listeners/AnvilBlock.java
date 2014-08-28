package com.connorlinfoot.extraenchantments.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryType;

public class AnvilBlock implements Listener {

    @EventHandler
    public void itemClick( InventoryClickEvent e ){
        if( e.getCurrentItem() != null ){
            if (String.valueOf(e.getCurrentItem().getItemMeta().getLore()).contains("Smeltery I")) {
                if( e.getInventory().getType() == InventoryType.ANVIL ){
                    e.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void itemMove( InventoryMoveItemEvent e ){
        if( e.getItem() != null ){
            if (String.valueOf(e.getItem().getItemMeta().getLore()).contains("Smeltery I")) {
                if( e.getDestination().getType() == InventoryType.ANVIL ){
                    e.setCancelled(true);
                }
            }
        }
    }

}
