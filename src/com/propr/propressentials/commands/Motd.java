package com.propr.propressentials.commands;

import ProprEssentials;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class Motd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        ArrayList<String> commands = new ArrayList<>();

        for (Map.Entry<String, java.util.Map<String, Object>> entry : Bukkit.getPluginManager().getPlugin("ProprEssentials").getDescription().getCommands().entrySet()) {
            commands.add(entry.getKey());
        }

        StringBuilder motd = new StringBuilder();
        ChatColor[] colors = new ChatColor[]{ChatColor.AQUA, ChatColor.BLUE, ChatColor.BLACK, ChatColor.DARK_AQUA, ChatColor.DARK_BLUE, ChatColor.DARK_GRAY, ChatColor.DARK_GREEN, ChatColor.DARK_PURPLE, ChatColor.DARK_RED, ChatColor.GOLD, ChatColor.GRAY, ChatColor.GREEN, ChatColor.LIGHT_PURPLE, ChatColor.RED, ChatColor.WHITE, ChatColor.YELLOW};

        try {
            motd.append(ChatColor.AQUA + "Welcome to " + ProprEssentials.getServerName() + "\nCommands:");
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String commandName : commands) {
            int element = new Random().nextInt(colors.length);
            motd.append(colors[element] + "\nCommand name: /" + commandName + " | Usage: " + Bukkit.getPluginCommand(commandName).getUsage() + " | Permissions: " + Bukkit.getPluginCommand(commandName).getPermission());
        }

        sender.sendMessage(motd.toString());

        return true;
    }
}
