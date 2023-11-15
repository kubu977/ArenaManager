package org.arenamanager.arenamanager;

import org.arenamanager.arenamanager.Commands.ArenaManagerCommands.Commands;
import org.arenamanager.arenamanager.Commands.ArenaManagerCommands.CommandsManager;
import org.arenamanager.arenamanager.Commands.OtherCommands.HelpCommand;
import org.arenamanager.arenamanager.Configs.ConfigManager;
import org.arenamanager.arenamanager.Langs.LangManager;
import org.arenamanager.arenamanager.TabComplete.TabComplete;
import org.bukkit.plugin.java.JavaPlugin;

public final class ArenaManager extends JavaPlugin {

    private ConfigManager configManager;
    private CommandsManager commandsManager;
    private LangManager langManager;

    @Override
    public void onEnable() {
        //Config
        this.configManager = new ConfigManager(this);

        //Register classes
        this.commandsManager = new CommandsManager(this);

        this.langManager = new LangManager(this.getLangManager());

        //Commands
        this.getCommand("help").setExecutor(new HelpCommand());
        this.getCommand("am").setExecutor(new Commands(this));

        //TabCompleter
        this.getCommand("am").setTabCompleter(new TabComplete());

    }

    @Override
    public void onDisable() {
        //Config
        this.configManager.saveConfig();
    }

    public ConfigManager getConfigManager() {
        return this.configManager;
    }

    public CommandsManager getCommandsManager(){
        return this.commandsManager;
    }

    public LangManager getLangManager(){
        return this.langManager;
    }
}
