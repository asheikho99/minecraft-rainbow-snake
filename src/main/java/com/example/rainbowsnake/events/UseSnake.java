package com.example.rainbowsnake.events;

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

    public UseSnake(Plugin plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onUseSnake(PlayerInteractEvent event) {

        Action action = event.getAction();
        if(action.equals(Action.RIGHT_CLICK_AIR)) {

            ItemStack itemInHand = event.getItem();

            assert itemInHand != null;
            if (itemInHand.getType().equals(Material.FEATHER)) {

                if (Objects.requireNonNull(itemInHand.getItemMeta()).getDisplayName().equalsIgnoreCase("Rainbow Snake")) {

                    Player player = event.getPlayer();
                    player.sendMessage("Used Rainbow Snake!!");
                    new BukkitRunnable() {
                        int tickCount = 0;
                        @Override
                        public void run() {
                            World world = player.getWorld();
                            FallingBlock fb = world.spawnFallingBlock(new Location(world, 0, 80, 0), Material.BLUE_STAINED_GLASS.createBlockData());
                            fb.setVelocity(new Vector(1, 1, 0));
                            fb.setDropItem(false);

                            tickCount++;
                            if(tickCount == 20) this.cancel();
                        }
                    }.runTaskTimer(plugin, 0,5);
                }
            }

        }
    }
}
