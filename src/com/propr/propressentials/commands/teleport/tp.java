package com.propr.propressentials.commands.teleport;

import ProprEssentials;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class tp implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {

            Player host = (Player)sender;
            Player guest;

            ProprEssentials.logCommand(host, label, args);

            if (args.length == 1) {
                if (Bukkit.getPlayer(args[0]) != null) {
                    guest = Bukkit.getPlayer(args[0]);
                    if (guest == null) throw new AssertionError();
                    host.teleport(guest.getLocation());
                    host.sendMessage(ChatColor.GREEN + "Teleported you to " + args[0]);
                } else {
                    host.sendMessage(ChatColor.RED + args[0] + " is not online!");
                }
            } else if (args.length == 2) {
                if (Bukkit.getPlayer(args[0]) == null) {
                    host.sendMessage(ChatColor.RED + args[0] + " is not online!");
                } else if (Bukkit.getPlayer(args[1]) == null) {
                    host.sendMessage(ChatColor.RED + args[1] + " is not online!");
                } else {
                    guest = Bukkit.getPlayer(args[0]);
                    guest.teleport(host.getLocation());
                    host.sendMessage(ChatColor.GREEN + "Teleported " + args[0] + " to " + args[1]);
                }
            } else {
                host.sendMessage(ChatColor.RED + Bukkit.getPluginCommand("tp").getUsage());
            }
        }

        return true;
    }
}
