package com.propr.propressentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Vanish implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            player.setInvisible(!player.isInvisible());
            player.sendMessage(ChatColor.GREEN + "Poof");
        } else {
            Bukkit.getLogger().info("only players can run this command");
        }

        return true;
    }
}
