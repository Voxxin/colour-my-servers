package com.github.voxxin.colourmyservers.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.toasts.SystemToast;
import net.minecraft.network.chat.Component;

public class ErrorCatching {

    public static boolean stringTooLong(String string) {
        return new ComponentU(string).getComponent().getString().length() > 32;
    }

    public static void nameTooLongToast() {
        SystemToast.add(
                Minecraft.getInstance().getToasts(), new SystemToast.SystemToastId(5000L),
                Component.literal("Name too long!"),
                Component.literal("Max length: 32 characters")
        );
    }
}
