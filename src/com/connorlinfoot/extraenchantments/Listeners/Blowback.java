package com.connorlinfoot.extraenchantments.Listeners;

import com.connorlinfoot.extraenchantments.Main;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class Blowback implements Listener {
    @EventHandler
    public void onPlayerHit( EntityDamageByEntityEvent e ){
        if( e.getEntity() instanceof Player ) {
            Player p = (Player) e.getEntity();
            if( e.getDamager() instanceof LivingEntity ) {
                if (p.getInventory().getChestplate() != null) {
                    if (String.valueOf(p.getInventory().getChestplate().getItemMeta().getLore()).contains("Blowback III")) {
                        // 40% Chance damager takes half your damage
                        if (Main.randInt(0, 100) <= 40) {
                            e.setDamage(e.getDamage() / 2);
                            LivingEntity le = (LivingEntity) e.getDamager();
                            le.setHealth(le.getHealth() - (e.getDamage() / 2));
                        }
                    } else if (String.valueOf(p.getInventory().getChestplate().getItemMeta().getLore()).contains("Blowback II")) {
                        // 20% Chance damager takes half your damage
                        if (Main.randInt(0, 100) <= 20) {
                            e.setDamage(e.getDamage() / 2);
                            LivingEntity le = (LivingEntity) e.getDamager();
                            le.setHealth(le.getHealth() - (e.getDamage() / 2));
                        }
                    } else if (String.valueOf(p.getInventory().getChestplate().getItemMeta().getLore()).contains("Blowback I")) {
                        // 10% Chance damager takes half your damage
                        if (Main.randInt(0, 100) <= 10) {
                            e.setDamage(e.getDamage() / 2);
                            LivingEntity le = (LivingEntity) e.getDamager();
                            le.setHealth(le.getHealth() - (e.getDamage() / 2));
                        }
                    }
                }
            }
        }
    }
}