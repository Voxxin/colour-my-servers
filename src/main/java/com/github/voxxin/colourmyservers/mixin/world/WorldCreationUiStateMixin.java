package com.github.voxxin.colourmyservers.mixin.world;

import com.github.voxxin.colourmyservers.util.ComponentU;
import net.minecraft.client.gui.screens.worldselection.WorldCreationUiState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(WorldCreationUiState.class)
public class WorldCreationUiStateMixin {

    @Inject(at = @At(value = "HEAD"), method = "findResultFolder")
    private void findResultFolder(String string, CallbackInfoReturnable<String> cir) {
        string = new ComponentU(string).parse().getString();
    }
}
