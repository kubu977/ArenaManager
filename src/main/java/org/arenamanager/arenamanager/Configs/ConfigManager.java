package org.arenamanager.arenamanager.Configs;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class ConfigManager {

    private final JavaPlugin plugin;
    private FileConfiguration config;

    public ConfigManager(JavaPlugin plugin) {
        this.plugin = plugin;
        this.plugin.saveDefaultConfig();
        this.reloadConfig();
    }

    public void reloadConfig() {
        this.plugin.reloadConfig();
        this.config = this.plugin.getConfig();
    }

    public void saveConfig() {
        this.plugin.saveConfig();
    }

    public FileConfiguration getConfig() {
        return this.config;
    }

    public void set(String path, Object value) {
        this.config.set(path, value);
    }

    public void addWorldName(String worldName) {
        if (!this.config.contains("arenas")) {
            this.config.createSection("arenas");
        }
        int arenaCount = this.config.getConfigurationSection("arenas").getKeys(false).size();
        this.config.set("arenas.Arena" + (arenaCount + 1) + ".name", worldName);
        saveConfig();
    }

    public void deleteWorldName(String worldName) {
        if (this.config.contains("arenas")) {
            for (String key : this.config.getConfigurationSection("arenas").getKeys(false)) {
                if (this.config.getString("arenas." + key + ".name").equalsIgnoreCase(worldName)) {
                    this.config.set("arenas." + key, null);
                    saveConfig();
                    break;
                }
            }
        }
    }

    public boolean worldExists(String worldName) {
        if (this.config.contains("arenas")) {
            ConfigurationSection arenasSection = this.config.getConfigurationSection("arenas");
            if (arenasSection != null) {
                for (String key : arenasSection.getKeys(false)) {
                    String name = this.config.getString("arenas." + key + ".name");
                    if (name != null && name.equalsIgnoreCase(worldName)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}