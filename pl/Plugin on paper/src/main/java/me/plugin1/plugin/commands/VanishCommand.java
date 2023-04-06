package me.plugin1.plugin.commands;

import me.plugin1.plugin.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

public class VanishCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;

        for (Player players : Bukkit.getOnlinePlayers()) {
            players.hidePlayer(player);
        }

        // Permission test

//        if (player.hasPermission("permisseion.gug")) player.sendMessage("heh");
//        else player.sendMessage("huh");
//
//        PermissionAttachment attachment = player.addAttachment(Main.getPlugin(), "permisseion.gug", true);
//
//        if (player.hasPermission("permisseion.gug")) player.sendMessage("heh");
//        else player.sendMessage("huh");
//
//        new BukkitRunnable() {
//
//            @Override
//            public void run() {
//                if (player.hasPermission("permisseion.gug")) player.sendMessage("heh");
//                else player.sendMessage("huh");
////                attachment.remove();
//                player.addAttachment(Main.getPlugin(), "permisseion.gug", false);
//                if (player.hasPermission("permisseion.gug")) player.sendMessage("heh");
//                else player.sendMessage("huh");
//            }
//        }.runTaskTimerAsynchronously(Main.getPlugin(), 200, 1000000000);

        return true;
    }
}
