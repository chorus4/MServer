package com.example.velocityplugin.Commands;

import com.velocitypowered.api.command.CommandSource;
import com.velocitypowered.api.command.SimpleCommand;
import com.velocitypowered.api.proxy.Player;
import com.velocitypowered.api.proxy.ServerConnection;
import net.kyori.adventure.text.Component;
import org.geysermc.cumulus.form.CustomForm;
import org.geysermc.cumulus.form.ModalForm;
import org.geysermc.geyser.api.GeyserApi;

public class RegisterCommand implements SimpleCommand {
    @Override
    public void execute(Invocation invocation) {
        CommandSource source = invocation.source();
        Player player = (Player) source;
        String[] args = invocation.arguments();

        ServerConnection playerServer = player.getCurrentServer().get();

//        if (!playerServer.getServerInfo().getName().equals("nano")) return;


        if (args[0].isEmpty()) {
            source.sendMessage(Component.text("Использование команды: /register {ваш пароль}"));
            return;
        }

        // TODO: do a check if the player registered

        // Register logic

        source.sendMessage(Component.text("Registered..."));

        GeyserApi.api().sendForm(player.getUniqueId(),
                CustomForm.builder()
                        .title("Title")
                        .dropdown("Text", "Option 1", "Option 2")
                        .input("Input", "placeholder")
                        .toggle("Toggle")
                        .slider("Text", 0, 10, 1, 5)

        );
    }
}
