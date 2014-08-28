package com.connorlinfoot.extraenchantments;

import com.connorlinfoot.extraenchantments.Tools.Blowback;
import com.connorlinfoot.extraenchantments.Tools.LifeTouch;
import com.connorlinfoot.extraenchantments.Tools.Resistance;
import com.connorlinfoot.extraenchantments.Tools.Smeltery;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Test implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerJoin( PlayerJoinEvent e ){
        e.getPlayer().getInventory().addItem(Resistance.getTool(Material.DIAMOND_SWORD, 5));
        e.getPlayer().getInventory().addItem(Smeltery.getTool(Material.DIAMOND_PICKAXE, 2));
        e.getPlayer().getInventory().addItem(Blowback.getTool(Material.DIAMOND_CHESTPLATE, 3));
        e.getPlayer().getInventory().addItem(LifeTouch.getTool(Material.DIAMOND_CHESTPLATE,3));
    }

}
