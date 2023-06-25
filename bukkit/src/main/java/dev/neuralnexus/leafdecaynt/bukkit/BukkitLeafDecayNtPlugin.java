package dev.neuralnexus.leafdecaynt.bukkit;

import dev.neuralnexus.leafdecaynt.bukkit.listeners.world.BukkitLeafDecayListener;
import dev.neuralnexus.leafdecaynt.common.LeafDecayNtPlugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import static dev.neuralnexus.leafdecaynt.common.Utils.getBukkitServerType;

/**
 * The LeafDecayNt Bukkit plugin.
 */
public class BukkitLeafDecayNtPlugin extends JavaPlugin implements LeafDecayNtPlugin {
    /**
     * @inheritDoc
     */
    @Override
    public Object pluginLogger() {
        return getLogger();
    }

    /**
     * @inheritDoc
     */
    @Override
    public String pluginConfigPath() {
        return "plugins";
    }

    /**
     * @inheritDoc
     */
    @Override
    public String getServerType() {
        return getBukkitServerType();
    }

    /**
     * @inheritDoc
     */
    @Override
    public void registerHooks() {}

    /**
     * @inheritDoc
     */
    @Override
    public void registerEventListeners() {
        PluginManager pluginManager = getServer().getPluginManager();
        pluginManager.registerEvents(new BukkitLeafDecayListener(), this);
    }

    /**
     * @inheritDoc
     */
    @Override
    public void registerCommands() {}

    /**
     * @inheritDoc
     */
    @Override
    public void onEnable() {
        pluginStart();
    }

    /**
     * @inheritDoc
     */
    @Override
    public void onDisable() {
        pluginStop();
    }
}
