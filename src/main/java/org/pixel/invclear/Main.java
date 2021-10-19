package org.pixel.invclear;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.PluginManager;
import org.pixel.invclear.config.ConfigHandler;
import org.pixel.invclear.listener.DeathListener;

import java.util.ArrayList;
import java.util.List;

public class Main extends JavaPlugin {

    // Instancing Classes
    private final ConfigHandler ch = new ConfigHandler(this);
    private final DeathListener dl = new DeathListener(this);

    // Getting config
    private YamlConfiguration config = ch.getConfig();

    @Override
    public void onEnable() {
        // Config defaults
        if(!config.contains("enabled")) {config.set("enabled", "true");}
        if(!config.contains("world")) {
            List worlds = new ArrayList();
            worlds.add("pvp");
            worlds.add("someworld");
            config.set("worlds", worlds);
        }
        ch.saveConfig();

        // Registering listeners
        PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvents(dl, this);
    }

    @Override
    public void onDisable() {}
}
