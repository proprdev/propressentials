package com.propr.propressentials.commands;

import ProprEssentials;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Smite implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        ProprEssentials.logCommand((Player) sender, label, args);

        if (args.length == 0) {
            sender.sendMessage(ChatColor.RED + Bukkit.getPluginCommand("smite").getUsage());
        } else {
            if (Bukkit.getPlayer(args[0]) != null) {

                Player idiot = Bukkit.getPlayer(args[0]);

                if (idiot == null) {
                    sender.sendMessage(ChatColor.RED + args[0] + "is not online!");
                    return true;
                }
                idiot.getWorld().strikeLightning(idiot.getLocation());
                sender.sendMessage(ChatColor.DARK_RED + idiot.getName() + " has been smited!");
            }
        }

        return true;
    }
}
