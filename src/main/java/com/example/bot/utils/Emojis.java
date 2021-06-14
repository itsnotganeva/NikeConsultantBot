package com.example.bot.utils;

import com.vdurmont.emoji.EmojiParser;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Emojis {
    SNEAKERS(EmojiParser.parseToUnicode(":athletic_shoe:")),
    MONEY(EmojiParser.parseToUnicode(":money_with_wings:")),
    TROLLEY(EmojiParser.parseToUnicode(":shopping_trolley:")),
    EYES(EmojiParser.parseToUnicode(":eyes:"));

    private String emojiName;

    @Override
    public String toString() {
        return emojiName;
    }
}
