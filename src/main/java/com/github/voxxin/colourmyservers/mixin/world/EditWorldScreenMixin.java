package com.github.voxxin.colourmyservers.mixin.world;

import com.github.voxxin.colourmyservers.util.ErrorCatching;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.worldselection.EditWorldScreen;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EditWorldScreen.class)
public class EditWorldScreenMixin {
    @Shadow @Final private EditBox nameEdit;

    @Inject(method = "<init>", at = @At("TAIL"))
    public void init(CallbackInfo ci, @Local Button button) {
        nameEdit.setMaxLength(Integer.MAX_VALUE);
        nameEdit.setResponder(w -> {
            button.active = !w.isEmpty() && !ErrorCatching.isTooLong(w);
        });
    }
}