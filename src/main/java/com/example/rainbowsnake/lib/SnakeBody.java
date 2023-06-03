package com.example.rainbowsnake.lib;

import org.bukkit.Material;
import org.bukkit.block.data.BlockData;
import java.util.ArrayList;
import java.util.List;

public class SnakeBody {
    private final ArrayList<BlockData> bodyBlocks;

    public SnakeBody(){
        bodyBlocks = new ArrayList<>(List.of(
                Material.RED_STAINED_GLASS.createBlockData(),
                Material.ORANGE_STAINED_GLASS.createBlockData(),
                Material.YELLOW_STAINED_GLASS.createBlockData(),
                Material.GREEN_STAINED_GLASS.createBlockData(),
                Material.BLUE_STAINED_GLASS.createBlockData(),
                Material.PURPLE_STAINED_GLASS.createBlockData(),
                Material.PINK_STAINED_GLASS.createBlockData()
        ));
    }

    public ArrayList<BlockData> getBodyBlocks() {
        return bodyBlocks;
    }
}
