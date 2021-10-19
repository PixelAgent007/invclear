package org.pixel.invclear.listener;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.pixel.invclear.Main;
import org.pixel.invclear.config.ConfigHandler;

import java.util.List;

public class DeathListener implements Listener {
    private final Main main;
    public DeathListener(Main main) {
        this.main = main;
    }

    @EventHandler
    public void onEvent(PlayerRespawnEvent event) {
        final ConfigHandler ch = new ConfigHandler(this.main);
        YamlConfiguration config = ch.getConfig();

        if (config.getBoolean("enabled") || config.getList("worlds") != null) {
            Player player = event.getPlayer();
            String world = player.getWorld().getName();
            List worlds = config.getList("worlds");

            if (worlds.contains(world)) {
                player.getInventory().clear();
            }
        }
    }
}

