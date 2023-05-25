package com.example.rainbowsnake;

import com.example.rainbowsnake.commands.CommandSnake;
import com.example.rainbowsnake.events.SnakeEventListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        Objects.requireNonNull(this.getCommand("snake")).setExecutor(new CommandSnake());
        getServer().getPluginManager().registerEvents(new SnakeEventListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
