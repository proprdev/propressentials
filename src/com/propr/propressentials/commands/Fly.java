package com.propr.propressentials.commands;

import ProprEssentials;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player)sender;

            ProprEssentials.logCommand(player, label, args);

            if (player.isFlying()) {
                player.setFlying(false);
                player.setAllowFlight(false);
                player.sendMessage(ChatColor.GREEN + "You are no longer flying");
            } else if (!player.isFlying()) {
                player.setAllowFlight(true);
                player.setFlying(true);
                player.sendMessage(ChatColor.GREEN + "You are now flying");
            }

        }

        return true;
    }
}
