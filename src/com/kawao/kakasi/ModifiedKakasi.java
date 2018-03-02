package com.kawao.kakasi;

import static java.lang.System.out;

/**
 * Created by shettyr on 01/03/2018.
 */
public class ModifiedKakasi {

    private final KanwaDictionary kanwaDictionary;

    public ModifiedKakasi() {
        this.kanwaDictionary = new KanwaDictionary();
    }

    public KanwaDictionary getKanwaDictionary() {
        return kanwaDictionary;
    }

    private void katakanaToHiragana(int inputCharAsInt, StringBuilder outputStringBuilder) {
        if (isKatakana(inputCharAsInt)) {
            if ((inputCharAsInt >= '\u30a1' && inputCharAsInt <= '\u30f3') ||
                    inputCharAsInt == '\u30fd' || inputCharAsInt == '\u30fe') {
                // from small 'a' to 'n' and iteration marks
                outputStringBuilder.append((char) (inputCharAsInt - 0x60));
            } else if (inputCharAsInt == '\u30f4') { // 'vu'
                outputStringBuilder.append('\u3046');
                outputStringBuilder.append('\u309b');
            } else if (isKatakana(inputCharAsInt)) {
                outputStringBuilder.append((char) inputCharAsInt);
            }
        }
    }

    private static boolean isKatakana(int ch) {
        if (ch < 0) {
            return false;
        }
        if (ch == '\u309b' || ch == '\u309c') { // voice sound mark
            return true;
        }
        Character.UnicodeBlock block = Character.UnicodeBlock.of((char) ch);
        return block.equals(Character.UnicodeBlock.KATAKANA);
    }

    private void kanjiToHiragana(int inputCharAsInt, StringBuilder outputStringBuilder) {
        if (inputCharAsInt > 0) {
            outputStringBuilder.append((char) inputCharAsInt);
            switch (inputCharAsInt) {
                case '\u3005':    // kurikaesi
                case '\u3006':    // shime
                case '\u30f5':    // katakana small ka
                case '\u30f6':    // katakana small ke
                    break;
                default:
                    break;
            }
        }
    }

    private String convert(String inputString) {

        StringBuilder outputSB = new StringBuilder();
        if (inputString.isEmpty()) {
            return outputSB.toString();
        }

        for (int i = 0; i < inputString.length(); i++) {
            int ch = inputString.charAt(i);
            Character.UnicodeBlock block = Character.UnicodeBlock.of((char) ch);

            if (block.equals(Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS)) {
                // call method to convert cjk to hiragana
                kanjiToHiragana(ch, outputSB);
            } else if (block.equals(Character.UnicodeBlock.HIRAGANA)) {
                // call method to convert hiragana to hiragana - based on wakachigakiMode
            } else if (block.equals(Character.UnicodeBlock.KATAKANA)) {
                // call method to convert katakana to hiragana
                katakanaToHiragana(ch, outputSB);
            }
        }
        return outputSB.toString();
    }

    public static void main(String[] args) throws Throwable {
        ModifiedKakasi modifiedKakasi = new ModifiedKakasi();
        if (args.length <= 0) {
            out.println("No input string to convert");
            return;
        }
        String inputString = args[0];
        out.println(String.format("The output of conversion for %s is %s", inputString, modifiedKakasi.convert(inputString)));
        modifiedKakasi.getKanwaDictionary().close();
    }
}