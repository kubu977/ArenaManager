package org.arenamanager.arenamanager.Commands.ArenaManagerCommands;

import org.arenamanager.arenamanager.ArenaManager;
import org.arenamanager.arenamanager.Configs.ConfigManager;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class CommandsManager {

    ArenaManager plugin;
    private final ConfigManager config;

    public CommandsManager(ArenaManager plugin) {
        this.plugin = plugin;
        this.config = this.plugin.getConfigManager();
    }

    public List<String> getWorldNames() {

        List<String> worldNames = new ArrayList<>();
        ConfigurationSection worlds = this.config.getConfig().getConfigurationSection("arenas");

        if (worlds != null) {
            for (String key : worlds.getKeys(false)) {
                worldNames.add(key);
            }
        }

        return worldNames;
    }

}
