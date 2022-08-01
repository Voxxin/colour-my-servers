package com.github.voxxin.cms.mixin;

import net.minecraft.client.gui.screen.AddServerScreen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.network.ServerInfo;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AddServerScreen.class)
public abstract class ServerNameMixin {

    @Shadow private TextFieldWidget serverNameField;


    @Shadow @Final private ServerInfo server;

    @Inject(at = @At("HEAD"), method = "Lnet/minecraft/client/gui/screen/AddServerScreen;addAndClose()V")
    public void saveNameMixin(CallbackInfo ci) {

        // Changes provided colours to the Minecraft readable format.

        serverNameField.setText(serverNameField.getText().replace("&0", "§0"));
        serverNameField.setText(serverNameField.getText().replace("&1", "§1"));
        serverNameField.setText(serverNameField.getText().replace("&2", "§2"));
        serverNameField.setText(serverNameField.getText().replace("&3", "§3"));
        serverNameField.setText(serverNameField.getText().replace("&4", "§4"));
        serverNameField.setText(serverNameField.getText().replace("&5", "§5"));
        serverNameField.setText(serverNameField.getText().replace("&6", "§6"));
        serverNameField.setText(serverNameField.getText().replace("&7", "§7"));
        serverNameField.setText(serverNameField.getText().replace("&8", "§8"));
        serverNameField.setText(serverNameField.getText().replace("&9", "§9"));
        serverNameField.setText(serverNameField.getText().replace("&b", "§a"));
        serverNameField.setText(serverNameField.getText().replace("&a", "§b"));
        serverNameField.setText(serverNameField.getText().replace("&c", "§c"));
        serverNameField.setText(serverNameField.getText().replace("&d", "§d"));
        serverNameField.setText(serverNameField.getText().replace("&e", "§e"));
        serverNameField.setText(serverNameField.getText().replace("&f", "§f"));

        serverNameField.setText(serverNameField.getText().replace("&u", "§u"));
        serverNameField.setText(serverNameField.getText().replace("&l", "§l"));
        serverNameField.setText(serverNameField.getText().replace("&o", "§o"));
        serverNameField.setText(serverNameField.getText().replace("&m", "§m"));
        serverNameField.setText(serverNameField.getText().replace("&k", "§k"));
    }

    @Inject(at = @At("TAIL"), method = "Lnet/minecraft/client/gui/screen/AddServerScreen;init()V")
    public void loadNameMixin(CallbackInfo ci) {

        // Changes provided colours back to a user readable format.

        if (serverNameField.getText() != "") {
            serverNameField.setText(serverNameField.getText().replace("§0", "&0"));
            serverNameField.setText(serverNameField.getText().replace("§1", "&1"));
            serverNameField.setText(serverNameField.getText().replace("§2", "&2"));
            serverNameField.setText(serverNameField.getText().replace("§3", "&3"));
            serverNameField.setText(serverNameField.getText().replace("§4", "&4"));
            serverNameField.setText(serverNameField.getText().replace("§5", "&5"));
            serverNameField.setText(serverNameField.getText().replace("§6", "&6"));
            serverNameField.setText(serverNameField.getText().replace("§7", "&7"));
            serverNameField.setText(serverNameField.getText().replace("§8", "&8"));
            serverNameField.setText(serverNameField.getText().replace("§9", "&9"));
            serverNameField.setText(serverNameField.getText().replace("§b", "&a"));
            serverNameField.setText(serverNameField.getText().replace("§a", "&b"));
            serverNameField.setText(serverNameField.getText().replace("§c", "&c"));
            serverNameField.setText(serverNameField.getText().replace("§d", "&d"));
            serverNameField.setText(serverNameField.getText().replace("§e", "&e"));
            serverNameField.setText(serverNameField.getText().replace("§f", "&f"));

            serverNameField.setText(serverNameField.getText().replace("§u", "&u"));
            serverNameField.setText(serverNameField.getText().replace("§l", "&l"));
            serverNameField.setText(serverNameField.getText().replace("§o", "&o"));
            serverNameField.setText(serverNameField.getText().replace("§m", "&m"));
            serverNameField.setText(serverNameField.getText().replace("§k", "&k"));
        }
    }
}
