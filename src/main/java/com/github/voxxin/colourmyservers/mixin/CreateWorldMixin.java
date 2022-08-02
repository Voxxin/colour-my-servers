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
        levelNameField.setText(levelNameField.getText().replace("&0", "§0"));
        levelNameField.setText(levelNameField.getText().replace("&1", "§1"));
        levelNameField.setText(levelNameField.getText().replace("&2", "§2"));
        levelNameField.setText(levelNameField.getText().replace("&3", "§3"));
        levelNameField.setText(levelNameField.getText().replace("&4", "§4"));
        levelNameField.setText(levelNameField.getText().replace("&5", "§5"));
        levelNameField.setText(levelNameField.getText().replace("&6", "§6"));
        levelNameField.setText(levelNameField.getText().replace("&7", "§7"));
        levelNameField.setText(levelNameField.getText().replace("&8", "§8"));
        levelNameField.setText(levelNameField.getText().replace("&9", "§9"));
        levelNameField.setText(levelNameField.getText().replace("&b", "§a"));
        levelNameField.setText(levelNameField.getText().replace("&a", "§b"));
        levelNameField.setText(levelNameField.getText().replace("&c", "§c"));
        levelNameField.setText(levelNameField.getText().replace("&d", "§d"));
        levelNameField.setText(levelNameField.getText().replace("&e", "§e"));
        levelNameField.setText(levelNameField.getText().replace("&f", "§f"));

        levelNameField.setText(levelNameField.getText().replace("&u", "§u"));
        levelNameField.setText(levelNameField.getText().replace("&l", "§l"));
        levelNameField.setText(levelNameField.getText().replace("&o", "§o"));
        levelNameField.setText(levelNameField.getText().replace("&m", "§m"));
        levelNameField.setText(levelNameField.getText().replace("&k", "§k"));

    }
}