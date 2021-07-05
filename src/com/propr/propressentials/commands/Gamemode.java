package com.propr.propressentials.commands;

import com.propr.propressentials.ProprEssentials;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gamemode implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            ProprEssentials.logCommand(player, label, args);

            if (player.hasPermission("propressentials.gamemode")) {
                if (args.length == 0) { player.sendMessage(ChatColor.RED + "No arguments supplied"); }
                else if (args.length == 1) {
                    switch (args[0].toLowerCase()) {
                        case "s": case "survival": case "0":
                            player.setGameMode(GameMode.SURVIVAL);
                            player.sendMessage(ChatColor.GREEN + "Set gamemode to survival");
                            break;
                        case "c": case "creative": case "1":
                            player.setGameMode(GameMode.CREATIVE);
                            player.sendMessage(ChatColor.GREEN + "Set gamemode to creative");
                            break;
                        case "a": case "adventure": case "2":
                            player.setGameMode(GameMode.ADVENTURE);
                            player.sendMessage(ChatColor.GREEN + "Set gamemode to adventure");
                            break;
                        case "sp": case "spectator": case "3":
                            player.setGameMode(GameMode.SPECTATOR);
                            player.sendMessage(ChatColor.GREEN + "Set gamemode to spectator");
                            break;
                    }
                }
                else if (args.length == 2) {

                    Player guest = Bukkit.getPlayer(args[1]);

                    if (guest != null) {
                        switch (args[0].toLowerCase()) {
                            case "s":
                            case "survival":
                            case "0":
                                guest.setGameMode(GameMode.SURVIVAL);
                                player.sendMessage(ChatColor.GREEN + "Set " + guest.getName() + "'s gamemode to survival");
                                break;
                            case "c":
                            case "creative":
                            case "1":
                                guest.setGameMode(GameMode.CREATIVE);
                                guest.sendMessage(ChatColor.GREEN + "Set " + guest.getName() + "'s to creative");
                                break;
                            case "a":
                            case "adventure":
                            case "2":
                                guest.setGameMode(GameMode.ADVENTURE);
                                player.sendMessage(ChatColor.GREEN + "Set " + guest.getName() + "'s adventure");
                                break;
                            case "sp":
                            case "spectator":
                            case "3":
                                guest.setGameMode(GameMode.SPECTATOR);
                                player.sendMessage(ChatColor.GREEN + "Set " + guest.getName() + "'s spectator");
                                break;
                        }
                    }
                }
            } else {
                player.sendMessage("You do not have permission to run this command");
            }

        }

        return true;
    }
}
