package com.github.voxxin.colourmyservers.mixin;

import net.minecraft.client.gui.screen.world.EditWorldScreen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(EditWorldScreen.class)
public abstract class WorldNameEditMixin {

    @Shadow
    private TextFieldWidget levelNameTextField;

    @Inject(at = @At("HEAD"), method = "Lnet/minecraft/client/gui/screen/world/EditWorldScreen;commit()V")
    public void nameCommitMixin(CallbackInfo ci) {
        levelNameTextField.setText(levelNameTextField.getText().replace("&", "§"));
    }

    @Inject(at = @At("TAIL"), method = "Lnet/minecraft/client/gui/screen/world/EditWorldScreen;init()V")
    public void worldNameMixin(CallbackInfo ci) {

        if (levelNameTextField.getText() != "") {
            levelNameTextField.setText(levelNameTextField.getText().replace("§", "&"));
        }
    }
}
