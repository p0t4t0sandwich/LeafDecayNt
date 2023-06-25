package dev.neuralnexus.leafdecaynt.fabric.mixin.listeners.server;

import dev.neuralnexus.leafdecaynt.fabric.events.server.FabricServerStoppedEvent;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Listens for server stop and emits an event.
 */
@Mixin(MinecraftServer.class)
public class FabricServerStoppedListener {
    /**
     * Called when the server stops.
     * @param ci The callback info.
     */
    @Inject(method = "shutdown", at = @At("HEAD"))
    public void onServerStopped(CallbackInfo ci) {
        MinecraftServer server = (MinecraftServer) (Object) this;
        // Fire the server stopped event
        FabricServerStoppedEvent.EVENT.invoker().onServerStopped(server);
    }
}
