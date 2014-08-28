package com.connorlinfoot.extraenchantments.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class Resistance implements Listener {
    @EventHandler
    public void onPlayerHit( EntityDamageByEntityEvent e ){
        if( e.getEntity() instanceof Player ) {
            Player p = (Player) e.getEntity();
            if (p.getItemInHand() != null) {
                if (p.isBlocking() && String.valueOf(p.getItemInHand().getItemMeta().getLore()).contains("Resistance V")) {
                    e.setDamage(0);
                } else if (p.isBlocking() && String.valueOf(p.getItemInHand().getItemMeta().getLore()).contains("Resistance IV")) {
                    e.setDamage(e.getDamage() / 5);
                } else if (p.isBlocking() && String.valueOf(p.getItemInHand().getItemMeta().getLore()).contains("Resistance III")) {
                    e.setDamage(e.getDamage() / 4);
                } else if (p.isBlocking() && String.valueOf(p.getItemInHand().getItemMeta().getLore()).contains("Resistance II")) {
                    e.setDamage(e.getDamage() / 3);
                } else if (p.isBlocking() && String.valueOf(p.getItemInHand().getItemMeta().getLore()).contains("Resistance I")) {
                    e.setDamage(e.getDamage() / 2);
                }
            }
        }
    }
}
