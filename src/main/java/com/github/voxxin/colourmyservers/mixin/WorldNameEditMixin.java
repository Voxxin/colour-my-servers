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
        levelNameTextField.setText(levelNameTextField.getText().replace("&0", "§0"));
        levelNameTextField.setText(levelNameTextField.getText().replace("&1", "§1"));
        levelNameTextField.setText(levelNameTextField.getText().replace("&2", "§2"));
        levelNameTextField.setText(levelNameTextField.getText().replace("&3", "§3"));
        levelNameTextField.setText(levelNameTextField.getText().replace("&4", "§4"));
        levelNameTextField.setText(levelNameTextField.getText().replace("&5", "§5"));
        levelNameTextField.setText(levelNameTextField.getText().replace("&6", "§6"));
        levelNameTextField.setText(levelNameTextField.getText().replace("&7", "§7"));
        levelNameTextField.setText(levelNameTextField.getText().replace("&8", "§8"));
        levelNameTextField.setText(levelNameTextField.getText().replace("&9", "§9"));
        levelNameTextField.setText(levelNameTextField.getText().replace("&b", "§a"));
        levelNameTextField.setText(levelNameTextField.getText().replace("&a", "§b"));
        levelNameTextField.setText(levelNameTextField.getText().replace("&c", "§c"));
        levelNameTextField.setText(levelNameTextField.getText().replace("&d", "§d"));
        levelNameTextField.setText(levelNameTextField.getText().replace("&e", "§e"));
        levelNameTextField.setText(levelNameTextField.getText().replace("&f", "§f"));

        levelNameTextField.setText(levelNameTextField.getText().replace("&u", "§u"));
        levelNameTextField.setText(levelNameTextField.getText().replace("&l", "§l"));
        levelNameTextField.setText(levelNameTextField.getText().replace("&o", "§o"));
        levelNameTextField.setText(levelNameTextField.getText().replace("&m", "§m"));
        levelNameTextField.setText(levelNameTextField.getText().replace("&k", "§k"));
    }

    @Inject(at = @At("TAIL"), method = "Lnet/minecraft/client/gui/screen/world/EditWorldScreen;init()V")
    public void worldNameMixin(CallbackInfo ci) {

        if (levelNameTextField.getText() != "") {
            levelNameTextField.setText(levelNameTextField.getText().replace("§0", "&0"));
            levelNameTextField.setText(levelNameTextField.getText().replace("§1", "&1"));
            levelNameTextField.setText(levelNameTextField.getText().replace("§2", "&2"));
            levelNameTextField.setText(levelNameTextField.getText().replace("§3", "&3"));
            levelNameTextField.setText(levelNameTextField.getText().replace("§4", "&4"));
            levelNameTextField.setText(levelNameTextField.getText().replace("§5", "&5"));
            levelNameTextField.setText(levelNameTextField.getText().replace("§6", "&6"));
            levelNameTextField.setText(levelNameTextField.getText().replace("§7", "&7"));
            levelNameTextField.setText(levelNameTextField.getText().replace("§8", "&8"));
            levelNameTextField.setText(levelNameTextField.getText().replace("§9", "&9"));
            levelNameTextField.setText(levelNameTextField.getText().replace("§b", "&a"));
            levelNameTextField.setText(levelNameTextField.getText().replace("§a", "&b"));
            levelNameTextField.setText(levelNameTextField.getText().replace("§c", "&c"));
            levelNameTextField.setText(levelNameTextField.getText().replace("§d", "&d"));
            levelNameTextField.setText(levelNameTextField.getText().replace("§e", "&e"));
            levelNameTextField.setText(levelNameTextField.getText().replace("§f", "&f"));

            levelNameTextField.setText(levelNameTextField.getText().replace("§u", "&u"));
            levelNameTextField.setText(levelNameTextField.getText().replace("§l", "&l"));
            levelNameTextField.setText(levelNameTextField.getText().replace("§o", "&o"));
            levelNameTextField.setText(levelNameTextField.getText().replace("§m", "&m"));
            levelNameTextField.setText(levelNameTextField.getText().replace("§k", "&k"));
        }
    }
}