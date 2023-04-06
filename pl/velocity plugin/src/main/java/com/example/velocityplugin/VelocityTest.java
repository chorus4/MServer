package com.example.velocityplugin;

import com.example.velocityplugin.Commands.LoginCommand;
import com.example.velocityplugin.Commands.RegisterCommand;
import com.example.velocityplugin.Commands.TestCommand;
import com.google.inject.Inject;
import com.velocitypowered.api.command.CommandManager;
import com.velocitypowered.api.command.CommandMeta;
import com.velocitypowered.api.command.SimpleCommand;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.ProxyServer;
import com.velocitypowered.api.proxy.messages.LegacyChannelIdentifier;
import com.velocitypowered.api.proxy.messages.MinecraftChannelIdentifier;
import org.slf4j.Logger;

import java.net.InetSocketAddress;

@Plugin(
        id = "velocityplugin",
        name = "VelocityPlugin",
        version = "1.0-SNAPSHOT"
)
public class VelocityTest {

    @Inject
    private Logger logger;
    private final ProxyServer proxy;

    private static VelocityTest plugin;

    @Inject
    public VelocityTest(ProxyServer proxy, Logger logger) {
        this.proxy = proxy;
        this.logger = logger;
    }
    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        plugin = this;

        CommandManager commandManager = proxy.getCommandManager();

        CommandMeta commandMeta = commandManager.metaBuilder("proxy")
                .aliases("vpn", "my-server")
                .plugin(this)
                .build();

        CommandMeta loginCommandMeta = commandManager.metaBuilder("login")
                .plugin(this)
                .build();

        CommandMeta registerCommandMeta = commandManager.metaBuilder("register")
                .aliases("reg")
                .plugin(this)
                .build();

        SimpleCommand command = new TestCommand(proxy);
        SimpleCommand loginCommand = new LoginCommand(proxy);
        SimpleCommand registerCommand = new RegisterCommand();

        commandManager.register(commandMeta, command);
        commandManager.register(loginCommandMeta, loginCommand);
        commandManager.register(registerCommandMeta, registerCommand);

        proxy.getEventManager().register(this, new EventListener(proxy));

        proxy.getChannelRegistrar().register(new LegacyChannelIdentifier("myChannel"));

        logger.info("hello");
    }

    public static VelocityTest getPlugin() {
        return plugin;
    }
}
