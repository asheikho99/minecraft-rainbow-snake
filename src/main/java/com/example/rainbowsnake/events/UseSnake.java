package com.example.rainbowsnake.events;

import com.example.rainbowsnake.lib.SnakeBody;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.Objects;

public class UseSnake implements Listener {

    private final Plugin plugin;
    private final SnakeBody snakeBody;
    private final int COOLDOWN_TICKS = 100;

    public UseSnake(Plugin plugin, SnakeBody snakeBody){
        this.plugin = plugin;
        this.snakeBody = snakeBody;
    }

    @EventHandler
    public void onUseSnake(PlayerInteractEvent event) {

        Action action = event.getAction();
        if(action.equals(Action.RIGHT_CLICK_AIR)) {
            Player player = event.getPlayer();
            ItemStack itemInHand = event.getItem();
            boolean itemCoolDown = player.hasCooldown(Material.FEATHER);

            assert itemInHand != null;
            if (itemInHand.getType().equals(Material.FEATHER) && !itemCoolDown) {

                if (Objects.requireNonNull(itemInHand.getItemMeta()).getDisplayName().equalsIgnoreCase("Rainbow Snake")) {

                    World world = player.getWorld();
                    Location playerLocation = player.getLocation();
                    Vector playerDirection = player.getFacing().getDirection().setY(1);

                    player.setCooldown(Material.FEATHER, COOLDOWN_TICKS);
                    new BukkitRunnable() {
                        int tickCount = 0;
                        @Override
                        public void run() {

                            FallingBlock fb = world.spawnFallingBlock(playerLocation, snakeBody.getBodyBlocks().get((int) (Math.random() * snakeBody.getBodyBlocks().size())));
                            fb.setVelocity(playerDirection);
                            fb.setDropItem(false);

                            if(tickCount == 0) fb.addPassenger(player);

                            tickCount++;
                            if(tickCount == 20) this.cancel();
                        }
                    }.runTaskTimer(plugin, 0,1);
                }
            }

        }
    }
}
