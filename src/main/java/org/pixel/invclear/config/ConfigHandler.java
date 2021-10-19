package org.pixel.invclear.config;

import org.bukkit.configuration.file.YamlConfiguration;
import org.pixel.invclear.Main;

import java.io.File;

public class ConfigHandler {
    private final Main main;
    public ConfigHandler(Main main) {
        this.main = main;
    }

    private File getConfigAsFile() {
        return new File(this.main.getDataFolder(), "config.yml");
    }

    public YamlConfiguration getConfig() {
        return YamlConfiguration.loadConfiguration(this.getConfigAsFile());
    }

    public void saveConfig() {
        try {
            this.getConfig().save(this.getConfigAsFile());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
