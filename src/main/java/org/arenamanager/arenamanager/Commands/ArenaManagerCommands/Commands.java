package org.arenamanager.arenamanager.Commands.ArenaManagerCommands;

import org.arenamanager.arenamanager.ArenaManager;
import org.arenamanager.arenamanager.Configs.ConfigManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Commands implements CommandExecutor {
    ArenaManager plugin;
    private final ConfigManager config;

    public Commands(ArenaManager plugin) {
        this.plugin = plugin;
        this.config = this.plugin.getConfigManager();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("am")) {

            if (args.length == 0) {
                sender.sendMessage("Type /help for Arena Manager commands.");
            }
            //CreateCommand
            else if (args.length >= 2 && args[0].equalsIgnoreCase("create")) {
                String worldName = args[1];

                if (this.config.worldExists(worldName)) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&4This world already exists."));
                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Arena created"));
                    this.config.addWorldName(worldName);
                    this.config.saveConfig();

                    //Create SWM world
                }
            }
            else if (args[0].equalsIgnoreCase("create")){
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&4You need to specify a world name. Usage: /am create <name>"));
            }
            //DeleteCommand
            else if (args.length >= 2 && args[0].equalsIgnoreCase("delete")) {
                String worldName = args[1];

                if (this.config.worldExists(worldName)) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Arena deleted"));
                    this.config.deleteWorldName(worldName);
                    this.config.saveConfig();

                    //Delete SWM world
                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&4This world does not exist."));
                }
            }
            else if (args[0].equalsIgnoreCase("delete")){
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4You need to specify a world name. Usage: /am delete <name>"));

            }
            //ReloadCommand
            else if (args.length == 1 && args[0].equalsIgnoreCase("reload"))
            {
                this.config.reloadConfig();
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&6Config Reloaded!"));
            }
            //Else lol
            else{
                sender.sendMessage(ChatColor.RED + "Invalid command. Type /help for Arena Manager commands.");
            }
        }
        return true;
    }
}