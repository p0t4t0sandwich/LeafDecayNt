package dev.neuralnexus.leafdecaynt.fabric.mixin.listeners.server;

import dev.neuralnexus.leafdecaynt.fabric.events.server.FabricServerStartingEvent;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Listens for server start and emits an event.
 */
@Mixin(MinecraftServer.class)
public class FabricServerStartingListener {
    /**
     * Called when the server is starting.
     * @param ci The callback info.
     */
    @Inject(method = "runServer", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/MinecraftServer;setupServer()Z"))
    public void onServerStarting(CallbackInfo ci) {
        MinecraftServer server = (MinecraftServer) (Object) this;

        // Fire the server starting event
        FabricServerStartingEvent.EVENT.invoker().onServerStarting(server);
    }
}
