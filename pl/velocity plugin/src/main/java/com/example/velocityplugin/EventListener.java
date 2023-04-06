package com.example.velocityplugin;

import com.velocitypowered.api.event.EventTask;
import com.velocitypowered.api.event.PostOrder;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.connection.LoginEvent;
import com.velocitypowered.api.event.connection.PluginMessageEvent;
import com.velocitypowered.api.proxy.ConnectionRequestBuilder;
import com.velocitypowered.api.proxy.LoginPhaseConnection;
import com.velocitypowered.api.proxy.Player;
import com.velocitypowered.api.proxy.ProxyServer;
import com.velocitypowered.api.proxy.server.RegisteredServer;
import org.geysermc.api.Geyser;
import org.geysermc.cumulus.form.Form;
import org.geysermc.cumulus.form.ModalForm;
import org.geysermc.geyser.api.GeyserApi;
import org.geysermc.geyser.api.connection.GeyserConnection;

import javax.inject.Inject;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class EventListener {

    private final ProxyServer proxy;

    @Inject
    public EventListener(ProxyServer proxy) {
        this.proxy = proxy;
    }

    @Subscribe(order = PostOrder.EARLY)
    public EventTask LoginEvent(LoginEvent e) {
        return EventTask.async(() -> {
            Player player = e.getPlayer();

            // Check if online mode
            if (player.isOnlineMode()) {
                return;
            }

//            Optional<RegisteredServer> authServer = proxy.getServer("nano");
//            ConnectionRequestBuilder connection = player.createConnectionRequest(authServer.get());
//
//            connection.connect();
//

//            proxy.getScheduler()
//                    .buildTask(VelocityTest.getPlugin(), () -> {
//                        // do stuff here
//
//                    })
//                    .delay(120L, TimeUnit.SECONDS)
//                    .schedule();


//
//            System.out.println("hello thats result");
//            System.out.println(bedrock);


        });
    }

    @Subscribe
    public void onPluginMessage(PluginMessageEvent e) {
        System.out.println("Hello");
        proxy.shutdown();
    }
}
