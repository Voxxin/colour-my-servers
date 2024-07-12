package com.github.voxxin.colourmyservers.mixin.world;

import com.github.voxxin.colourmyservers.util.ComponentU;
import com.github.voxxin.colourmyservers.util.CreateWorldScreenExt;
import com.github.voxxin.colourmyservers.util.ErrorCatching;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.toasts.SystemToast;
import net.minecraft.client.gui.layouts.LinearLayout;
import net.minecraft.client.gui.screens.worldselection.CreateWorldScreen;
import net.minecraft.client.gui.screens.worldselection.WorldCreationUiState;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(CreateWorldScreen.class)
public class CreateWorldScreenMixin implements CreateWorldScreenExt {

    @Shadow @Final
    WorldCreationUiState uiState;

    @Unique
    private LinearLayout layout;

    @Inject(method = "init", at = @At("TAIL"), locals = LocalCapture.CAPTURE_FAILHARD)
    private void init(CallbackInfo ci, LinearLayout linearLayout) {
        this.layout = linearLayout;
    }


    @Override
    public void cms$updateFinalizeButton(String name) {
        this.layout.visitWidgets((w) -> {
            if (w instanceof Button button && button.getMessage().equals(Component.translatable("selectWorld.create"))) {
                if (ErrorCatching.stringTooLong(name)) {
                    if (button.active) {
                        ErrorCatching.nameTooLongToast();
                    }
                    button.active = false;
                } else {
                    this.uiState.setName(name);
                    button.active = true;
                }
            }
        });
    }
}
