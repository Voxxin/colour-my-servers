package com.github.voxxin.colourmyservers.mixin.world;

import com.github.voxxin.colourmyservers.util.ErrorCatching;
import it.unimi.dsi.fastutil.booleans.BooleanConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.layouts.LinearLayout;
import net.minecraft.client.gui.screens.worldselection.EditWorldScreen;
import net.minecraft.world.level.storage.LevelStorageSource;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(EditWorldScreen.class)
public class EditWorldScreenMixin {

    @Shadow @Final private EditBox nameEdit;

    @Inject(method = "<init>", at = @At("TAIL"), locals = LocalCapture.CAPTURE_FAILHARD)
    public void init(Minecraft minecraft, LevelStorageSource.LevelStorageAccess levelStorageAccess, String string, BooleanConsumer booleanConsumer, CallbackInfo ci, Font font, LinearLayout linearLayout, Button button) {
        if (nameEdit.getValue().isEmpty()) nameEdit.setMaxLength(9999999);
        nameEdit.setResponder(w -> {
            if (ErrorCatching.stringTooLong(w)) {
                if (button.active) {
                    ErrorCatching.nameTooLongToast();
                }
                button.active = false;
            } else {
                button.active = true;
            }

            if (w.isEmpty()) {
                button.active = false;
            }
        });
    }
}
