package com.github.voxxin.colourmyservers.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.toasts.SystemToast;
import net.minecraft.network.chat.Component;

public class ErrorCatching {
    private static final int MAX_LENGTH = 32;
    private static SystemToast lastToast;

    public static boolean isTooLong(String text) {
        return new ComponentU(text).parse().getString().length() > MAX_LENGTH;
    }

    public static void showToast() {
        SystemToast.add(
                Minecraft.getInstance().getToastManager(),
                new SystemToast.SystemToastId(5000L),
                Component.literal("Name too long!"),
                Component.literal("Max length: " + MAX_LENGTH + " characters")
            );
    }
}