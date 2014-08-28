package com.connorlinfoot.extraenchantments;

import com.connorlinfoot.extraenchantments.Commands.EE;
import com.connorlinfoot.extraenchantments.Listeners.Blowback;
import com.connorlinfoot.extraenchantments.Listeners.LifeTouch;
import com.connorlinfoot.extraenchantments.Listeners.Resistance;
import com.connorlinfoot.extraenchantments.Listeners.Smeltery;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Random;


public class Main extends JavaPlugin implements Listener {
    private static Plugin instance;
    public static CustomEnchantment ench = new CustomEnchantment(69);

    public void onEnable() {
        instance = this;
        getConfig().options().copyDefaults(true);
        saveConfig();
        Server server = getServer();
        ConsoleCommandSender console = server.getConsoleSender();

        if(getConfig().getString( "Send Stats" ).equals("enabled" ) ) {
            try {
                Metrics metrics = new Metrics(this);
                metrics.start();
                console.sendMessage("MC Stats (Metrics) is enabled!");
            } catch (IOException e) {
                // Failed to submit the stats :-( <-- Dat face doe
            }
        }

        console.sendMessage(ChatColor.GREEN + "======== ExtraEnchantments! ========");
        console.sendMessage(ChatColor.GREEN + "=========== VERSION: 0.1 ===========");
        console.sendMessage(ChatColor.GREEN + "======== BY CONNOR LINFOOT! ========");

        try{
            try {
                Field f = Enchantment.class.getDeclaredField("acceptingNew");
                f.setAccessible(true);
                f.set(null, true);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                Enchantment.registerEnchantment(ench);
            } catch (IllegalArgumentException e){
//if this is thrown it means the id is already taken.
            }
        }catch(Exception e){
            e.printStackTrace();
        }



        //Bukkit.getPluginManager().registerEvents(new Test(), this);
        Bukkit.getPluginManager().registerEvents(new Smeltery(), this);
        Bukkit.getPluginManager().registerEvents(new Resistance(), this);
        Bukkit.getPluginManager().registerEvents(new Blowback(), this);
        Bukkit.getPluginManager().registerEvents(new LifeTouch(), this);
        //Bukkit.getPluginManager().registerEvents(new AnvilBlock(), this);

        getCommand("ee").setExecutor(new EE());

    }

    public static int randInt(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    public void onDisable() {
        getLogger().info(getDescription().getName() + " has been disabled!");
    }

    public static Plugin getInstance() {
        return instance;
    }
}
