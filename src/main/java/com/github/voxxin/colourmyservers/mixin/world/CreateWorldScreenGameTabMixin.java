package com.github.voxxin.colourmyservers.mixin.world;

import com.github.voxxin.colourmyservers.util.CreateWorldScreenExt;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.worldselection.CreateWorldScreen;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CreateWorldScreen.GameTab.class)
public class CreateWorldScreenGameTabMixin {
    @Shadow @Final private EditBox nameEdit;

    @Inject(at = @At("TAIL"), method = "<init>")
    private void init(CreateWorldScreen createWorldScreen, CallbackInfo ci) {
        nameEdit.setMaxLength(Integer.MAX_VALUE);
        nameEdit.setResponder(w -> ((CreateWorldScreenExt) createWorldScreen).updateFinalizeButton(w));
    }
}