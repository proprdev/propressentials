package com.propr.propressentials.commands.teleport;

import com.propr.propressentials.ProprEssentials;
import com.sun.istack.internal.NotNull;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class tphere implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, @NotNull String[] args) {
        if (sender instanceof Player) {

            Player host = (Player)sender;
            Player guest;

            ProprEssentials.logCommand(host, label, args);

            if (host.hasPermission("propressentials.tphere")) {

                if (args.length == 1) {
                    if (Bukkit.getPlayer(args[0]) != null) {
                        guest = Bukkit.getPlayer(args[0]);
                        if (guest == null) throw new AssertionError();
                        guest.teleport(host.getLocation());
                        host.sendMessage("Teleported " + guest.getName() + " to you");
                    } else {
                        host.sendMessage(ChatColor.RED + args[0] + " is not online!");
                    }
                } else {
                    host.sendMessage(ChatColor.RED + Bukkit.getPluginCommand("tphere").getUsage());
                }

            } else {
                host.sendMessage("You do not have permission to run this command");
            }

        }

        return true;
    }
}
