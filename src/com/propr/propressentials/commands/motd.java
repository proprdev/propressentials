package com.propr.propressentials.commands;

import com.propr.propressentials.ProprEssentials;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import java.io.IOException;

public class motd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        try {
            sender.sendMessage(ChatColor.AQUA + "Welcome to " + ProprEssentials.getServerName() + "\nCommands:" +
                    ChatColor.GOLD + "\nCommand name: /heal | Usage: " + Bukkit.getPluginCommand("heal").getUsage() + " | Permissions: " + Bukkit.getPluginCommand("heal").getPermission() +
                    ChatColor.RED + "\nCommand name: /tp | Usage: " + Bukkit.getPluginCommand("tp").getUsage() + " | Permissions: " + Bukkit.getPluginCommand("tp").getPermission() +
                    ChatColor.GREEN + "\nCommand name: /tphere | Usage: " + Bukkit.getPluginCommand("tphere").getUsage() + " | Permissions: " + Bukkit.getPluginCommand("tphere").getPermission() +
                    ChatColor.BLUE + "\nCommand name: /fly | Usage: " + Bukkit.getPluginCommand("fly").getUsage() + " | Permissions: " + Bukkit.getPluginCommand("fly").getPermission() +
                    ChatColor.GRAY + "\nCommand name: /motd | Usage: " + Bukkit.getPluginCommand("motd").getUsage() + " | Permissions: " + Bukkit.getPluginCommand("motd").getPermission());
        } catch (IOException e) {
            Bukkit.getServer().broadcastMessage(ChatColor.RED + "Shit fucked up");
        }

        return true;
    }
}
