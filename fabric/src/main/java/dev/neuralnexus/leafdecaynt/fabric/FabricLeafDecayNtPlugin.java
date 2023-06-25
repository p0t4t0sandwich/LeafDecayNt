package dev.neuralnexus.leafdecaynt.fabric;

import dev.neuralnexus.leafdecaynt.common.LeafDecayNtPlugin;
import dev.neuralnexus.leafdecaynt.fabric.events.server.FabricServerStartingEvent;
import dev.neuralnexus.leafdecaynt.fabric.events.server.FabricServerStoppedEvent;
import net.fabricmc.api.DedicatedServerModInitializer;
import org.slf4j.LoggerFactory;

/**
 * The LeafDecayNt Fabric plugin.
 */
public class FabricLeafDecayNtPlugin implements DedicatedServerModInitializer, LeafDecayNtPlugin {
    /**
     * @inheritDoc
     */
    @Override
    public Object pluginLogger() {
        return LoggerFactory.getLogger("leafdecaynt");
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
        return "Fabric";
    }

    /**
     * @inheritDoc
     */
    @Override
    public void registerHooks() {
        FabricServerStartingEvent.EVENT.register(server -> {});
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
     * @inheritDoc
     */
    @Override
    public void onInitializeServer() {
        pluginStart();
        FabricServerStoppedEvent.EVENT.register(server -> pluginStop());
    }
}
