package com.github.voxxin.colourmyservers.mixin.world;

import com.github.voxxin.colourmyservers.util.ComponentU;
import net.minecraft.client.gui.screens.worldselection.WorldCreationUiState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(WorldCreationUiState.class)
public class WorldCreationUiStateMixin {

    @Inject(at = @At(value = "INVOKE_ASSIGN", target = "Ljava/lang/String;trim()Ljava/lang/String;"), method = "findResultFolder", cancellable = true)
    private void findResultFolder(String string, CallbackInfoReturnable<String> cir) {
        cir.setReturnValue(new ComponentU(string).getComponent().getString());
    }
}
