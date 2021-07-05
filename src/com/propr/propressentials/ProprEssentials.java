package com.propr.propressentials;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import com.propr.propressentials.commands.*;
import com.propr.propressentials.commands.teleport.*;

import java.io.*;

public class ProprEssentials extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {

        getLogger().info("[proprEssentials] Starting Plugin...");
        Bukkit.getPluginManager().registerEvents(this, this);
        this.getCommand("heal").setExecutor(new heal());
        this.getCommand("tphere").setExecutor(new tphere());
        this.getCommand("tp").setExecutor(new tp());
        this.getCommand("fly").setExecutor(new fly());
        this.getCommand("motd").setExecutor(new motd());
    }

    @Override
    public void onDisable() {
        getLogger().info("[proprEssentials] Disabling Plugin...");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        Bukkit.dispatchCommand(player, "motd");
    }

    public static String getServerName() throws IOException {
        FileInputStream fstream = new FileInputStream(Bukkit.getServer().getWorldContainer().getAbsolutePath() + "/server.properties");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String line;

        while ((line = br.readLine()) != null) {
            if (line.startsWith("server-name")) {
                return line.split("=")[1];
            }
        }

        fstream.close();

        return "No server-name";
    }

    public static void logCommand(Player player, String label, String[] args) {
        String fullCommand;

        if (args.length > 0) {
            StringBuilder sb = new StringBuilder();

            for (String arg : args) {
                StringBuilder append = sb.append(arg).append(" ");
            }

            String realArgs = sb.toString();

            fullCommand = "/" + label + " " + realArgs;
        } else {
            fullCommand = "/" + label;
        }

        Bukkit.broadcastMessage(player.getName() + " used command " + fullCommand);
    }

}
