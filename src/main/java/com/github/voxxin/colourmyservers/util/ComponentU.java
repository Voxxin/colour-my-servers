package com.github.voxxin.colourmyservers.util;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;

public class ComponentU {
    private final String input;

    public ComponentU(String input) {
        this.input = input;
    }

    public MutableComponent parse() {
        MutableComponent result = Component.literal("");
        StringBuilder currentText = new StringBuilder();
        Style currentStyle = Style.EMPTY;
        int pos = 0;

        while (pos < input.length()) {
            char c = input.charAt(pos++);

            if ((c == '§' || c == '&') && pos < input.length()) {
                char code = input.charAt(pos++);

                if (code == 'r') {
                    flush(currentText, result, currentStyle);
                    currentStyle = Style.EMPTY;
                    continue;
                }

                if (code == '#') {
                    if (pos + 6 <= input.length()) {
                        String hex = input.substring(pos, pos + 6);
                        if (hex.matches("[0-9a-fA-F]{6}")) {
                            flush(currentText, result, currentStyle);
                            currentStyle = currentStyle.withColor(Integer.parseInt(hex, 16));
                            pos += 6;
                            continue;
                        }
                    }
                } else {
                    ChatFormatting format = ChatFormatting.getByCode(code);
                    if (format != null) {
                        if (format.isColor()) {
                            flush(currentText, result, currentStyle);
                            currentStyle = Style.EMPTY.withColor(format);
                        } else {
                            currentStyle = applyFormat(currentStyle, format);
                        }
                        continue;
                    }
                }
                // Fallback for invalid codes
                currentText.append(c).append(code);
            } else {
                currentText.append(c);
            }
        }

        flush(currentText, result, currentStyle);
        return result;
    }

    private Style applyFormat(Style style, ChatFormatting format) {
        return switch (format) {
            case BOLD -> style.withBold(true);
            case ITALIC -> style.withItalic(true);
            case UNDERLINE -> style.withUnderlined(true);
            case STRIKETHROUGH -> style.withStrikethrough(true);
            case OBFUSCATED -> style.withObfuscated(true);
            default -> style;
        };
    }

    private void flush(StringBuilder text, MutableComponent result, Style style) {
        if (text.length() > 0) {
            result.append(Component.literal(text.toString()).withStyle(style));
            text.setLength(0);
        }
    }
}