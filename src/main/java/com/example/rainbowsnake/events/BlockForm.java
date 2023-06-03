package com.example.rainbowsnake.events;

import com.example.rainbowsnake.lib.SnakeBody;
import org.bukkit.block.data.BlockData;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;

public class BlockForm implements Listener {

    private final SnakeBody snakeBody;

    public BlockForm(SnakeBody snakeBody){
        this.snakeBody = snakeBody;
    }

    @EventHandler
    public void onBlockForm(EntityChangeBlockEvent event){
        for (BlockData blockData : snakeBody.getBodyBlocks()) {
            if (event.getTo().name().equalsIgnoreCase(blockData.getMaterial().name())) {
                event.setCancelled(true);
            }
        }
    }
}
