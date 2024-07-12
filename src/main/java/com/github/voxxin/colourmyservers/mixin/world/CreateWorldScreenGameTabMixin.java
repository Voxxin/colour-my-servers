package com.github.voxxin.colourmyservers.mixin.world;

import com.github.voxxin.colourmyservers.util.ComponentU;
import com.github.voxxin.colourmyservers.util.CreateWorldScreenExt;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.worldselection.CreateWorldScreen;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(CreateWorldScreen.GameTab.class)
public class CreateWorldScreenGameTabMixin {

    @Shadow @Final private EditBox nameEdit;

    @Inject(at = @At(value = "TAIL"), method = "<init>", locals = LocalCapture.CAPTURE_FAILHARD)
    private void init(CreateWorldScreen createWorldScreen, CallbackInfo ci) {
        if (!nameEdit.getValue().isEmpty()) nameEdit.setMaxLength(9999999);
        nameEdit.setResponder(w -> {
            ((CreateWorldScreenExt)createWorldScreen).cms$updateFinalizeButton(w);
        });
    }
}
