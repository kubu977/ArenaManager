package org.arenamanager.arenamanager.Commands.OtherCommands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelpCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;

        p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&c--------- &fArena Manager help &c---------"));
        p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&6/am create <name>: &fcreates arena."));
        p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&6/am delete <name>: &fdeletes arena."));
        p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&6/am reload: &freloads config.yml."));
        p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&6/am list: &fshows arenas."));

        return false;
    }
}
