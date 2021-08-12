package com.propr.propressentials;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.plugin.java.JavaPlugin;
import com.propr.propressentials.commands.*;
import com.propr.propressentials.commands.teleport.*;
import com.propr.propressentials.commands.tabcompletion.*;

import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProprEssentials extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {

        getLogger().info("[proprEssentials] Starting Plugin...");

        Bukkit.getPluginManager().registerEvents(this, this);

        this.getCommand("heal").setExecutor(new Heal());
        this.getCommand("tphere").setExecutor(new tphere());
        this.getCommand("tp").setExecutor(new tp());
        this.getCommand("fly").setExecutor(new Fly());
        this.getCommand("motd").setExecutor(new Motd());
        this.getCommand("gamemode").setExecutor(new Gamemode());
        this.getCommand("smite").setExecutor(new Smite());
        this.getCommand("flyspeed").setExecutor(new FlySpeed());
        this.getCommand("vanish").setExecutor(new Vanish());

        this.getCommand("gamemode").setTabCompleter(new GamemodeTabCompletion());
        this.getCommand("flyspeed").setTabCompleter(new FlyspeedTabCompletion());

        this.getCommand("tp").setAliases(Stream.of("teleport").collect(Collectors.toList()));
        this.getCommand("flyspeed").setAliases(Stream.of("flightspeed").collect(Collectors.toList()));

        this.getCommand("gamemode").setPermission("propressentials.gamemode");
        this.getCommand("tp").setPermission("propressentials.tp");
        this.getCommand("tphere").setPermission("propressentials.tphere");
        this.getCommand("fly").setPermission("propressentials.fly");
        this.getCommand("flyspeed").setPermission("propressentials.flyspeed");
        this.getCommand("heal").setPermission("propressentials.heal");
        this.getCommand("smite").setPermission("propressentials.smite");
    }

    @Override
    public void onDisable() {
        getLogger().info("[proprEssentials] Disabling Plugin...");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        Bukkit.dispatchCommand(player, "motd");
        Bukkit.dispatchCommand(player, "plugins");
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        event.setFormat("{prefix}%s{suffix}: %s");
    }

    @EventHandler
    public void onRain(WeatherChangeEvent event) {
        if (event.toWeatherState()) {
            event.setCancelled(true);
        }
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

        return "No server-name in server.properties";
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