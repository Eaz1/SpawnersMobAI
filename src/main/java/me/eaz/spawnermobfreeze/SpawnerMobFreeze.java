package me.eaz.spawnermobfreeze;

import org.bukkit.World;
import org.bukkit.entity.CaveSpider;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Spider;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class SpawnerMobFreeze extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);

        new BukkitRunnable() {
            @Override
            public void run() {
                for (World world : getServer().getWorlds()) {
                    for (Entity entity : world.getEntities()) {

                        if (!(entity instanceof Spider) && !(entity instanceof CaveSpider)) {
                            continue;
                        }

                        if (entity.isOnGround()) {
                            continue;
                        }

                        Vector velocity = entity.getVelocity();
                        velocity.setY(-0.4);
                        entity.setVelocity(velocity);
                    }
                }
            }
        }.runTaskTimer(this, 1L, 1L);

        getLogger().info("SpawnerMobFreeze enabled!");
    }

    @EventHandler
    public void onCreeperExplode(EntityExplodeEvent event) {
        if (event.getEntity() instanceof Creeper) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onSpiderTarget(EntityTargetEvent event) {
        if (event.getEntity() instanceof Spider || event.getEntity() instanceof CaveSpider) {
            event.setCancelled(true);
        }
    }
}
