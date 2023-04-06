package com.example.velocityplugin.Commands;

import com.velocitypowered.api.command.CommandSource;
import com.velocitypowered.api.command.SimpleCommand;
import com.velocitypowered.api.proxy.ConnectionRequestBuilder;
import com.velocitypowered.api.proxy.Player;
import com.velocitypowered.api.proxy.ProxyServer;
import com.velocitypowered.api.proxy.ServerConnection;
import com.velocitypowered.api.proxy.server.RegisteredServer;
import net.kyori.adventure.text.Component;

import javax.inject.Inject;
import java.util.Optional;

public class LoginCommand implements SimpleCommand {

    private final ProxyServer proxy;

    @Inject
    public LoginCommand(ProxyServer proxy) {
        this.proxy = proxy;
    }

    @Override
    public void execute(Invocation invocation) {
        CommandSource source = invocation.source();
        Player player = (Player) source;
        String[] args = invocation.arguments();

        Optional<RegisteredServer> lobbyServer = proxy.getServer("lobby");
        ConnectionRequestBuilder connection = player.createConnectionRequest(lobbyServer.get());

        // Check if player in login server

//        Optional<RegisteredServer> authServer = proxy.getServer("nano");
        ServerConnection playerServer = player.getCurrentServer().get();

        if (!playerServer.getServerInfo().getName().equals("nano")) return;


        if (args[0].isEmpty()) {
            source.sendMessage(Component.text("Использование команды: /login {ваш пароль}"));
            return;
        }

        // Login logic

        if (args[0].equals("parol")) {
            connection.connect();
        }
    }
}
