package com.example.rainbowsnake;

import com.example.rainbowsnake.commands.CommandSnake;
import com.example.rainbowsnake.events.UseSnake;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        Objects.requireNonNull(this.getCommand("snake")).setExecutor(new CommandSnake());
        getServer().getPluginManager().registerEvents(new UseSnake(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
