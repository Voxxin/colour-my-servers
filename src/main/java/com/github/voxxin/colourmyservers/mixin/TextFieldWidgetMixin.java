package com.github.voxxin.colourmyservers.mixin;

import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TextFieldWidget.class)
public class TextFieldWidgetMixin {

    @Shadow private int maxLength;

    @Inject(at = @At("TAIL"), method = "<init>(Lnet/minecraft/client/font/TextRenderer;IIIILnet/minecraft/text/Text;)V")
    private void init(TextRenderer textRenderer, int x, int y, int width, int height, Text text, CallbackInfo ci) {
        this.maxLength = 128;
    }
}
