package com.github.cal.ScaledMaps;

import org.bukkit.plugin.java.JavaPlugin;

public class ScaledMaps extends JavaPlugin
{
    @Override
    public void onEnable()
    {
        getServer().getPluginManager().registerEvents(new ScaledMapsListener(), this);
    }

    @Override
    public void onDisable()
    {
    }
}
