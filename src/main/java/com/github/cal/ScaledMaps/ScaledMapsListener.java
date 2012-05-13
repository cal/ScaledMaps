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

public class ScaledMapsListener implements Listener {

    @EventHandler
    public void MapInitializeEvent(MapInitializeEvent event) {
//      MapView map = event.getMap();
//      Bukkit.getServer().broadcastMessage("MapInitializeEvent, map:" + map.getId());

        event.getMap().setScale(Scale.CLOSEST);
    }

/*
    @EventHandler(priority = EventPriority.MONITOR)
    public void CraftItemEvent(CraftItemEvent event) {
      Player player = (Player) event.getWhoClicked();
      ItemStack item = event.getCurrentItem();

      if (item.getType() == Material.MAP && event.isShiftClick() == false) {
        MaterialData data = item.getData();
        player.sendMessage("CraftItemEvent: " + item.getType() + " " + event.getResult() + " " + event.isCancelled() + " data: " + data);
      }

//    event.getWhoClicked().sendMessage("craft!");
//    ((CommandSender) event.getWhoClicked()).sendMessage("craft!");
//    ((Player) event.getWhoClicked()).sendMessage("craft!");
    }
*/

}
