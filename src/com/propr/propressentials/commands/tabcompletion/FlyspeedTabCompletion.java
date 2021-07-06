package com.propr.propressentials.commands.tabcompletion;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlyspeedTabCompletion implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) {
            return Stream.of("default", "1", "-1", "0.5", "-0.5", "0.1").collect(Collectors.toList());
        }
        else { return null; }
    }
}
