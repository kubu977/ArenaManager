package org.arenamanager.arenamanager.TabComplete;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class TabComplete implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {

            if (command.getName().equalsIgnoreCase("am"))
            {
                List<String> argList = new ArrayList<>();

                if (args.length == 1)
                {
                    argList.add("create");
                    argList.add("delete");
                    argList.add("list");
                    argList.add("reload");
                    argList.add("list");
                }
                return argList;
            }
            return null;
        }
    }