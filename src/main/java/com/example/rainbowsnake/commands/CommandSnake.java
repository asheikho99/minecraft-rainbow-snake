package com.example.rainbowsnake.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CommandSnake implements CommandExecutor {

    // This method is called, when somebody uses our command
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            ItemStack feather = new ItemStack(Material.FEATHER);

            ItemMeta featherMeta = feather.getItemMeta();

            assert featherMeta != null;
            featherMeta.setDisplayName("Rainbow Snake");
            feather.setItemMeta(featherMeta);

            player.getInventory().addItem(feather);
        }

        // If the player (or console) uses our command correct, we can return true
        return true;
    }
}