package com.github.cal.ScaledMaps;

import org.bukkit.Material;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;

import org.bukkit.event.server.MapInitializeEvent;
import org.bukkit.map.MapView;
import org.bukkit.map.MapView.Scale;

import java.lang.Math;

public class ScaledMapsListener implements Listener {

    @EventHandler
    public void MapInitializeEvent(MapInitializeEvent event) {
//      Bukkit.getServer().broadcastMessage("MapInitializeEvent, map:" + map.getId());
        event.getMap().setScale(newScale(event.getMap()));
    }

// CLOSEST = (0), CLOSE = (1), NORMAL = (2), FAR = (3), FARTHEST = (4) 

    public Scale newScale(MapView newMap) {
        Scale newScale = Scale.FARTHEST;
        short mapId = 0;

        while (mapId < newMap.getId()) {
            MapView oldMap = Bukkit.getServer().getMap(mapId);

            if (oldMap.getScale().ordinal() <= newScale.ordinal()
                && newMap.getCenterX() > (oldMap.getCenterX() - (mapWidth(oldMap.getScale()) / 2))
                && newMap.getCenterX() < (oldMap.getCenterX() + (mapWidth(oldMap.getScale()) / 2))
                && newMap.getCenterZ() > (oldMap.getCenterZ() - (mapWidth(oldMap.getScale()) / 2))
                && newMap.getCenterZ() < (oldMap.getCenterZ() + (mapWidth(oldMap.getScale()) / 2))
            ) {
                newScale = nextScale(oldMap.getScale());
            }

            mapId++;
        }

        return newScale;
    }

    public int mapWidth(Scale s) {
        return (int) Math.pow(2, (s.ordinal() + 7));
    }

    public Scale nextScale(Scale oldScale) {
        return oldScale.ordinal() > 0
         ? Scale.values()[oldScale.ordinal() - 1]
         : Scale.CLOSEST;
     }
}
