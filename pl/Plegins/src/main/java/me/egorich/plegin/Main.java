package me.egorich.plegin;

import me.egorich.plegin.commands.Shutdown;
import me.egorich.plegin.events.Events;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "Plugin successfully started so you can play! ⌘");
        Bukkit.getPluginManager().registerEvents(new Events(), this);

        getCommand("shutdown").setExecutor(new Shutdown());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
