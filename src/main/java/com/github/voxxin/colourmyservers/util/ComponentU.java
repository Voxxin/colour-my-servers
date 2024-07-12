package com.github.voxxin.colourmyservers.util;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;

import java.util.ArrayList;
import java.util.Arrays;

public class ComponentU {
    private final char[] characters;

    private final MutableComponent parsedComponentString = net.minecraft.network.chat.Component.literal("");
    private StringBuilder parsingCharString = new StringBuilder();

    private final ArrayList<String> uniqueCharacters = new ArrayList<>(Arrays.asList("r", "l", "o", "k", "m", "n"));
    private final ArrayList<String> startCharacters = new ArrayList<>(Arrays.asList("§", "&"));
    private ChatFormatting parsingWithColourFormatting = null;
    private int parsingWithColourInt = 0;
    private boolean bold = false;
    private boolean italic = false;
    private boolean obfuscated = false;
    private boolean strikethrough = false;
    private boolean underline = false;

    private boolean finalized = false;

    public ComponentU(String original) {
        this.characters = original.toCharArray();
    }


    public net.minecraft.network.chat.Component getComponent() {
        for (int i = 0; i < this.characters.length; i++) {

            if (finalized) {
                addToParsingCharString();
                finalized = false;
            }

            if ((startCharacters.contains(String.valueOf(characters[i]))) && i + 1 < characters.length) {
                if (characters[i + 1] == '#' && i + 8 < characters.length) {
                    addToParsingCharString();
                    String hexString = new String(characters, i + 2, 6);
                    if (hexString.matches("[A-Fa-f0-9]{6}")) {
                        parsingWithColourInt = Integer.parseInt(hexString, 16);
                        if (i + 8 < characters.length && startCharacters.contains(String.valueOf(characters[i + 8]))) {
                            i += 7;
                            finalized = !parsingCharString.isEmpty();
                            continue;
                        }
                        i += 8;
                        finalized = !parsingCharString.isEmpty();
                    }
                } else if (i + 1 < characters.length && uniqueCharacters.contains(String.valueOf(characters[i + 1]))) {
                    addToParsingCharString();
                    char nextChar = characters[i + 1];
                    if (nextChar == 'r') resetFormatting();
                    else if (hasColour())
                        switch (nextChar) {
                            case 'l': bold = true; break;
                            case 'o': italic = true; break;
                            case 'k': obfuscated = true; break;
                            case 'm': strikethrough = true; break;
                            case 'n': underline = true; break;
                        }

                    i += 1;
                    finalized = !parsingCharString.isEmpty();
                    continue;
                } else if (ChatFormatting.getByCode(characters[i + 1]) != null && i + 1 < characters.length) {
                    addToParsingCharString();

                    bold = false;
                    italic = false;
                    obfuscated = false;
                    strikethrough = false;
                    underline = false;

                    parsingWithColourFormatting = ChatFormatting.getByCode(characters[i + 1]);

                    if (i + 2 < characters.length && startCharacters.contains(String.valueOf(characters[i + 2]))) {
                        i += 1;
                        finalized = !parsingCharString.isEmpty();
                        continue;
                    }
                    i += 2;
                    finalized = !parsingCharString.isEmpty();
                }
            }

            if (i < characters.length) parsingCharString.append(characters[i]);
        }

        addToParsingCharString();

        return parsedComponentString;
    }

    private void resetFormatting() {
        bold = false;
        italic = false;
        obfuscated = false;
        strikethrough = false;
        underline = false;
        parsingWithColourFormatting = null;
        parsingWithColourInt = 0;
    }


    private void addToParsingCharString() {
        parsedComponentString.append(
                net.minecraft.network.chat.Component.literal(parsingCharString.toString()).withStyle(
                        parsingWithColourInt == 0 ? Style.EMPTY.withColor(parsingWithColourFormatting == null ? ChatFormatting.WHITE : parsingWithColourFormatting)
                                .withBold(bold)
                                .withItalic(italic)
                                .withObfuscated(obfuscated)
                                .withStrikethrough(strikethrough)
                                .withUnderlined(underline) :
                        Style.EMPTY.withColor(parsingWithColourInt)
                                .withBold(bold)
                                .withItalic(italic)
                                .withObfuscated(obfuscated)
                                .withStrikethrough(strikethrough)
                                .withUnderlined(underline))
        );

        parsingCharString = new StringBuilder();
    }

    private boolean hasColour() {
        return parsingWithColourInt != 0 || parsingWithColourFormatting != null;
    }

}
