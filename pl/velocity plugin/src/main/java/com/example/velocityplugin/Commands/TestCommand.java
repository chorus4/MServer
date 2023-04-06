package com.example.velocityplugin.Commands;

import com.velocitypowered.api.command.CommandSource;
import com.velocitypowered.api.command.SimpleCommand;
import com.velocitypowered.api.proxy.ConnectionRequestBuilder;
import com.velocitypowered.api.proxy.Player;
import com.velocitypowered.api.proxy.ProxyServer;
import com.velocitypowered.api.proxy.server.RegisteredServer;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class TestCommand implements SimpleCommand {

//    @Inject
    private final ProxyServer proxy;

    @Inject
    public TestCommand(ProxyServer proxy) {
        this.proxy = proxy;
    }

    @Override
    public void execute(Invocation invocation) {
        CommandSource source = invocation.source();
        Player player = (Player) source;
        // Get the arguments after the command alias
        String[] args = invocation.arguments();

//        source.sendMessage(Component.text("This is what you written: " + args[0]).color(NamedTextColor.AQUA));

//        if (args[0].equalsIgnoreCase("con")) {
            Optional<RegisteredServer> server = proxy.getServer("main");
            ConnectionRequestBuilder offer =  player.createConnectionRequest(server.get());
            offer.connect();
//            source.sendMessage(Component.text(Boolean.toString(server.get() instanceof RegisteredServer)));
//            server.get() instanceof RegisteredServer
//        }
    }

    @Override
    public CompletableFuture<List<String>> suggestAsync(final Invocation invocation) {
        List<String> list = new ArrayList<String>();

        list.add("con");
//        list.add("anything");
//        list.add("what");
//        list.add("you");
//        list.add("want");

        return CompletableFuture.completedFuture(list);
    }
}
