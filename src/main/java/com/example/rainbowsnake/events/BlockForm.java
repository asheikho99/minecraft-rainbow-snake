package com.example.rainbowsnake.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;

public class BlockForm implements Listener {

    @EventHandler
    public void onBlockForm(EntityChangeBlockEvent event){
        Bukkit.broadcastMessage(event.getTo().name());

        if(event.getTo().name().equalsIgnoreCase("BLUE_STAINED_GLASS")){
            event.setCancelled(true);
        }
    }
}
