package com.github.voxxin.colourmyservers.mixin.server;

import com.github.voxxin.colourmyservers.util.ComponentU;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.multiplayer.ServerSelectionList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ServerSelectionList.OnlineServerEntry.class)
public class ServerSelectionListMixin {
    @Redirect(
            method = "render",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/GuiGraphics;drawString(Lnet/minecraft/client/gui/Font;Ljava/lang/String;IIIZ)I", ordinal = 0
            )
    )
    private int render(GuiGraphics instance, Font font, String string, int i, int j, int k, boolean bl) {
        net.minecraft.network.chat.Component component = new ComponentU(string).getComponent();
        return instance.drawString(font, component, i, j, k, bl);
    }
}
