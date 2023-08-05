package com.github.voxxin.colourmyservers.mixin;

import net.minecraft.client.gui.screen.world.CreateWorldScreen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.world.level.LevelInfo;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CreateWorldScreen.class)
public abstract class CreateWorldMixin {

    @Shadow private String levelName;

    @Shadow private TextFieldWidget levelNameField;

    @Inject(at = @At("HEAD"), method = "Lnet/minecraft/client/gui/screen/world/CreateWorldScreen;createLevelInfo(Z)Lnet/minecraft/world/level/LevelInfo;")
    public void saveNameMixin(boolean debugWorld, CallbackInfoReturnable<LevelInfo> cir) {
        levelNameField.setText(levelNameField.getText().replace("&", "§"));

    }
}
