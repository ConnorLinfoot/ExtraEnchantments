package com.connorlinfoot.extraenchantments.Commands;

import com.connorlinfoot.extraenchantments.Tools.Blowback;
import com.connorlinfoot.extraenchantments.Tools.LifeTouch;
import com.connorlinfoot.extraenchantments.Tools.Resistance;
import com.connorlinfoot.extraenchantments.Tools.Smeltery;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class EE implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        String prefix = ChatColor.GRAY + "[" + ChatColor.AQUA + "Extra Enchantments" + ChatColor.GRAY + "] ";
        if( !(sender instanceof Player) ){
            sender.sendMessage(prefix + ChatColor.RED + "Command must be ran as a player!");
            return false;
        }
        Player p = (Player) sender;
        if( args.length > 0 ){
            if( args[0].equalsIgnoreCase("list") ){
                sender.sendMessage(prefix + "Blowback");
                sender.sendMessage(prefix + "LifeTouch");
                sender.sendMessage(prefix + "Resistance");
                sender.sendMessage(prefix + "Smeltery");
                return false;
            } else if( args[0].equalsIgnoreCase("enchant") ){
                if( args.length == 3 ){

                    ItemStack is = p.getItemInHand();
                    if( is.getType() == null || is.getType() == Material.AIR ){
                        sender.sendMessage(prefix + ChatColor.RED + "No item in hand!");
                        return false;
                    }

                    if( args[1].equalsIgnoreCase("blowback") ){
                        if( args[2].equalsIgnoreCase("1") ){
                            Blowback.getTool(is,1);
                        } else if( args[2].equalsIgnoreCase("2") ){
                            Blowback.getTool(is,2);
                        } else if( args[2].equalsIgnoreCase("3") ){
                            Blowback.getTool(is,3);
                        } else {
                            sender.sendMessage(prefix + ChatColor.RED + "The blowback enchantment only supports level 1-3");
                            return false;
                        }
                        sender.sendMessage(prefix + "Enchantment Added!");
                        return false;
                    } else if( args[1].equalsIgnoreCase("lifetouch") ){
                        if( args[2].equalsIgnoreCase("1") ){
                            LifeTouch.getTool(is, 1);
                        } else if( args[2].equalsIgnoreCase("2") ){
                            LifeTouch.getTool(is,2);
                        } else if( args[2].equalsIgnoreCase("3") ){
                            LifeTouch.getTool(is,3);
                        } else {
                            sender.sendMessage(prefix + ChatColor.RED + "The LifeTouch enchantment only supports level 1-3");
                            return false;
                        }
                        sender.sendMessage(prefix + "Enchantment Added!");
                        return false;
                    } else if( args[1].equalsIgnoreCase("resistance") ){
                        if( args[2].equalsIgnoreCase("1") ){
                            Resistance.getTool(is, 1);
                        } else if( args[2].equalsIgnoreCase("2") ){
                            Resistance.getTool(is, 2);
                        } else if( args[2].equalsIgnoreCase("3") ){
                            Resistance.getTool(is,3);
                        } else {
                            sender.sendMessage(prefix + ChatColor.RED + "The Resistance enchantment only supports level 1-3");
                            return false;
                        }
                        sender.sendMessage(prefix + "Enchantment Added!");
                        return false;
                    } else if( args[1].equalsIgnoreCase("smeltery") ){
                        if( args[2].equalsIgnoreCase("1") ){
                            Smeltery.getTool(is, 1);
                        } else if( args[2].equalsIgnoreCase("2") ){
                            Smeltery.getTool(is, 2);
                        } else if( args[2].equalsIgnoreCase("3") ){
                            Smeltery.getTool(is,3);
                        } else {
                            sender.sendMessage(prefix + ChatColor.RED + "The Smeltery enchantment only supports level 1-3");
                            return false;
                        }
                        sender.sendMessage(prefix + "Enchantment Added!");
                        return false;
                    }
                }
                sender.sendMessage(prefix + ChatColor.RED + "Correct Usage: /ee enchant <enchant> <level>");
                return false;
            }
        }

        sender.sendMessage(prefix + ChatColor.RED + "Correct Usage: /ee <enchant/list>");


        return false;
    }

}
