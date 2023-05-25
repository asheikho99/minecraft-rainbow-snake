package com.example.rainbowsnake;

import com.example.rainbowsnake.commands.CommandSnake;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        Objects.requireNonNull(this.getCommand("snake")).setExecutor(new CommandSnake());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
