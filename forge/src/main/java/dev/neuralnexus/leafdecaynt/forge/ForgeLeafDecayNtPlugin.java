package dev.neuralnexus.leafdecaynt.forge;

import com.mojang.logging.LogUtils;
import dev.neuralnexus.leafdecaynt.common.LeafDecayNtPlugin;
import dev.neuralnexus.leafdecaynt.forge.listeners.world.ForgeLeafDecayListener;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.event.server.ServerStoppedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * The LeafDecayNt Forge plugin.
 */
@Mod("leafdecaynt")
public class ForgeLeafDecayNtPlugin implements LeafDecayNtPlugin {
    /**
     * @inheritDoc
     */
    @Override
    public Object pluginLogger() {
        return LogUtils.getLogger();
    }

    /**
     * @inheritDoc
     */
    @Override
    public String pluginConfigPath() {
        return "config";
    }

    /**
     * @inheritDoc
     */
    @Override
    public String getServerType() {
        return "Forge";
    }

    /**
     * @inheritDoc
     */
    @Override
    public void registerHooks() {}

    /**
     * Called when the server is starting.
     * @param event The event.
     */
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Register LuckPerms hook
//        if (ModList.get().isLoaded("luckperms")) {
//            useLogger("LuckPerms detected, enabling LuckPerms hook.");
//            Template.addHook(new LuckPermsHook());
//        }
    }

    /**
     * @inheritDoc
     */
    @Override
    public void registerEventListeners() {}

    /**
     * @inheritDoc
     */
    @Override
    public void registerCommands() {}

    /**
     * Called when the Forge mod is initializing.
     */
    public ForgeLeafDecayNtPlugin() {
        // Register server starting/stopping events
        MinecraftForge.EVENT_BUS.register(this);

        // Register player event listeners
        MinecraftForge.EVENT_BUS.register(new ForgeLeafDecayListener());

        // Register commands
//        MinecraftForge.EVENT_BUS.register(ForgeTemplateCommand.class);
        pluginStart();
    }

    /**
     * Called when the server is stopping.
     * @param event The event.
     */
    @SubscribeEvent
    public void onServerStopped(ServerStoppedEvent event) {
        pluginStop();
    }
}
