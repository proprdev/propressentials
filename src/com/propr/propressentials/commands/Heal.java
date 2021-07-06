package com.propr.propressentials.commands;

import com.propr.propressentials.ProprEssentials;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Heal implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            ProprEssentials.logCommand(player, label, args);

            if (player.hasPermission("propressentials.heal")) {
                player.setHealth(20);
                player.setFoodLevel(20);
                player.sendMessage(ChatColor.GREEN + "Healed and fed");
            } else {
                player.sendMessage("You do not have permission to run this command");
            }

        }
            return true;
    }
}
