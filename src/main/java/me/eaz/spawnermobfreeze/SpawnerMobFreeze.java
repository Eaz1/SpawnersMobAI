package me.eaz.spawnermobfreeze;

import org.bukkit.entity.Creeper;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Spider;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class SpawnerMobFreeze extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("SpawnerMobFreeze enabled!");
    }

    @EventHandler
    public void onMobSpawn(CreatureSpawnEvent event) {
        // Do nothing - all mobs keep their normal AI.
    }

    @EventHandler
    public void onCreeperExplode(EntityExplodeEvent event) {
        if (event.getEntity() instanceof Creeper) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onSpiderTarget(EntityTargetEvent event) {
        if (event.getEntity() instanceof Spider) {
            event.setCancelled(true);
        }
    }
}
