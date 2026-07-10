package me.eaz.spawnermobfreeze;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.EnumSet;
import java.util.Set;

public class SpawnerMobFreeze extends JavaPlugin implements Listener {

    private static final Set<EntityType> HOSTILE_MOBS = EnumSet.of(
            EntityType.ZOMBIE,
            EntityType.HUSK,
            EntityType.ZOMBIE_VILLAGER,
            EntityType.SKELETON,
            EntityType.STRAY,
            EntityType.WITHER_SKELETON,
            EntityType.ENDERMAN,
            EntityType.WITCH,
            EntityType.BLAZE,
            EntityType.GHAST,
            EntityType.SLIME,
            EntityType.MAGMA_CUBE,
            EntityType.GUARDIAN,
            EntityType.ELDER_GUARDIAN,
            EntityType.SILVERFISH,
            EntityType.ENDERMITE,
            EntityType.VINDICATOR,
            EntityType.EVOKER,
            EntityType.VEX
    );

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("SpawnerMobFreeze enabled!");
    }

    @EventHandler
    public void onMobSpawn(CreatureSpawnEvent event) {
        if (event.getSpawnReason() != CreatureSpawnEvent.SpawnReason.SPAWNER) {
            return;
        }

        LivingEntity mob = event.getEntity();

        if (!HOSTILE_MOBS.contains(mob.getType())) {
            return;
        }

        mob.setAI(false);
    }
}
