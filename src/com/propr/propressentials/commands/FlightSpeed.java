package com.propr.propressentials.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlightSpeed implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player)sender;
            if (args[0].equals("default")) {
                player.setFlySpeed(0.1f);
            } else {
                if (!(Float.parseFloat(args[0]) < -1) || !(Float.parseFloat(args[0]) > 1)) {
                    player.setFlySpeed(Float.parseFloat(args[0]));
                } else {
                    player.sendMessage("Speed must be between -1 and 1");
                }
            }
        }

        return true;
    }
}
