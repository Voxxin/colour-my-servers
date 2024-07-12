package com.github.voxxin.colourmyservers.mixin.server;

import com.github.voxxin.colourmyservers.util.ComponentU;
import com.github.voxxin.colourmyservers.util.ErrorCatching;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.toasts.SystemToast;
import net.minecraft.client.gui.screens.EditServerScreen;
import net.minecraft.client.multiplayer.resolver.ServerAddress;
import net.minecraft.network.chat.Component;
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
        if (!nameEdit.getValue().isEmpty()) nameEdit.setMaxLength(9999999);
    }

    @Inject(at = @At("HEAD"), method = "onAdd", cancellable = true)
    public void onAdd(CallbackInfo ci) {
        if (ErrorCatching.stringTooLong(this.nameEdit.getValue())) {
            ErrorCatching.nameTooLongToast();
            ci.cancel();
        }
    }

    @Inject(at = @At("HEAD"), method = "updateAddButtonStatus", cancellable = true)
    public void updateAddButtonStatus(CallbackInfo ci) {
        if (ErrorCatching.stringTooLong(this.nameEdit.getValue())) {
            if (this.addButton.active) {
                ErrorCatching.nameTooLongToast();
            }
            this.addButton.active = false;
            ci.cancel();
        }
    }
}
