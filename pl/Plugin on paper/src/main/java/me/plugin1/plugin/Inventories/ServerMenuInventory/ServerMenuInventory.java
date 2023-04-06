package me.plugin1.plugin.Inventories.ServerMenuInventory;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ServerMenuInventory {
    public Inventory inventory = Bukkit.createInventory(new ServerMenuInventoryHolder(), 45, "Выбор сервера");

    public ServerMenuInventory() {
        inventory.setItem(11, new ItemStack(Material.BLUE_WOOL));

        ItemStack surv = new ItemStack(Material.ACACIA_SAPLING);

        ItemMeta survMeta = surv.getItemMeta();

        survMeta.displayName(Component.text("Выживание"));

        surv.setItemMeta(survMeta);

        inventory.setItem(13, surv);
    }
}
