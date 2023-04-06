package me.egorich.plegin.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class Events implements Listener {

//    @EventHandler
//    public void onSpawn(EntitySpawnEvent e) {
//        e.setCancelled(true);
//    }

//    @EventHandler
//    public void onBroke(BlockBreakEvent e) {
//            e.setCancelled(true);
//    }

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        e.setDeathMessage("Loshara axaxaxaxaxaaxaxax)");
        Player player = e.getEntity();
        EntityDamageEvent damevent = player.getLastDamageCause();
        EntityDamageEvent.DamageCause damage = damevent.getCause();

//        Bukkit.getConsoleSender().sendMessage(String.valueOf(damage));
        if (damage == EntityDamageEvent.DamageCause.ENTITY_ATTACK){
            LivingEntity killer = player.getKiller();
            if (killer instanceof Player){
                Player pkiller = (Player) killer;
                e.setDeathMessage("Игрок " + player.getName() + " был убит игроком " + pkiller.getName());
            }else{
                e.setDeathMessage("Игрок " + player.getName() + " был убит " + killer.getType().toString());
            }
        }
    }

    @EventHandler
    public void onConnect(PlayerJoinEvent e) {
        e.getPlayer().sendMessage("Привет " + e.getPlayer().getName());
    }
}
