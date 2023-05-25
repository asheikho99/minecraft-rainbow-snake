package com.example.rainbowsnake.events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class SnakeEventListener implements Listener {
    @EventHandler
    public void onUseSnake(PlayerInteractEvent event) {

        Action action = event.getAction();
        if(action.equals(Action.RIGHT_CLICK_AIR)) {

            System.out.println(event.getAction());
            ItemStack itemInHand = event.getItem();

            assert itemInHand != null;
            if (itemInHand.getType().equals(Material.FEATHER)) {

                if (Objects.requireNonNull(itemInHand.getItemMeta()).getDisplayName().equalsIgnoreCase("Rainbow Snake")) {
                    event.getPlayer().sendMessage("Used Rainbow Snake!");
                }
            }

        } else {
            event.setCancelled(true);
        }
    }
}
