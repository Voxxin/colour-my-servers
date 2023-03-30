package com.github.voxxin.colourmyservers.mixin;

import net.minecraft.client.gui.screen.world.CreateWorldScreen;
import net.minecraft.client.gui.screen.world.WorldCreator;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.world.level.LevelInfo;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CreateWorldScreen.class)
public abstract class CreateWorldMixin {

    @Shadow @Final private WorldCreator worldCreator;

    @Inject(at = @At("HEAD"), method = "Lnet/minecraft/client/gui/screen/world/CreateWorldScreen;createLevelInfo(Z)Lnet/minecraft/world/level/LevelInfo;")
    public void saveNameMixin(boolean debugWorld, CallbackInfoReturnable<LevelInfo> cir) {
        worldCreator.setWorldName(worldCreator.getWorldName().replace("&0", "§0"));
        worldCreator.setWorldName(worldCreator.getWorldName().replace("&1", "§1"));
        worldCreator.setWorldName(worldCreator.getWorldName().replace("&2", "§2"));
        worldCreator.setWorldName(worldCreator.getWorldName().replace("&3", "§3"));
        worldCreator.setWorldName(worldCreator.getWorldName().replace("&4", "§4"));
        worldCreator.setWorldName(worldCreator.getWorldName().replace("&5", "§5"));
        worldCreator.setWorldName(worldCreator.getWorldName().replace("&6", "§6"));
        worldCreator.setWorldName(worldCreator.getWorldName().replace("&7", "§7"));
        worldCreator.setWorldName(worldCreator.getWorldName().replace("&8", "§8"));
        worldCreator.setWorldName(worldCreator.getWorldName().replace("&9", "§9"));
        worldCreator.setWorldName(worldCreator.getWorldName().replace("&a", "§a"));
        worldCreator.setWorldName(worldCreator.getWorldName().replace("&b", "§b"));
        worldCreator.setWorldName(worldCreator.getWorldName().replace("&c", "§c"));
        worldCreator.setWorldName(worldCreator.getWorldName().replace("&d", "§d"));
        worldCreator.setWorldName(worldCreator.getWorldName().replace("&e", "§e"));
        worldCreator.setWorldName(worldCreator.getWorldName().replace("&f", "§f"));

        worldCreator.setWorldName(worldCreator.getWorldName().replace("&u", "§u"));
        worldCreator.setWorldName(worldCreator.getWorldName().replace("&l", "§l"));
        worldCreator.setWorldName(worldCreator.getWorldName().replace("&o", "§o"));
        worldCreator.setWorldName(worldCreator.getWorldName().replace("&m", "§m"));
        worldCreator.setWorldName(worldCreator.getWorldName().replace("&k", "§k"));

    }
}