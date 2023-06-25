package dev.neuralnexus.leafdecaynt.bukkit.listeners.world;

import dev.neuralnexus.leafdecaynt.common.LeafDecayNt;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.LeavesDecayEvent;

/**
 * Listens for leaf decay events.
 */
public class BukkitLeafDecayListener implements Listener {
    @EventHandler
    public void onPlayerLogin(LeavesDecayEvent event) {
        if (LeafDecayNt.cancelDecay) {
            event.setCancelled(true);
        }
    }
}
