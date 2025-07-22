package com.github.voxxin.colourmyservers.mixin.server;

import com.github.voxxin.colourmyservers.util.ErrorCatching;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.EditServerScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EditServerScreen.class)
public class EditServerScreenMixin {
    @Shadow private EditBox nameEdit;
    @Shadow private Button addButton;

    @Inject(at = @At("TAIL"), method = "init")
    public void init(CallbackInfo ci) {
        nameEdit.setMaxLength(Integer.MAX_VALUE);
    }

    @Inject(at = @At("HEAD"), method = {"onAdd", "updateAddButtonStatus"}, cancellable = true)
    public void handleValidation(CallbackInfo ci) {
        if (ErrorCatching.isTooLong(nameEdit.getValue())) {
            if (addButton.active) ErrorCatching.showToast();
            addButton.active = false;
            ci.cancel();
        }
    }
}