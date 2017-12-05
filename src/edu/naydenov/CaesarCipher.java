package edu.naydenov;

/**
 * Created by Andrey Naydenov on 28.11.2017.
 */
class CaesarCipher {
    private String text = "";
    private char[] alphabet = {};
    private int shift = 0;
    private String result = "";

    void incShift() {
        shift++;
    }

    void decShift() {
        shift--;
    }

    int getShift() {
        return shift;
    }

    void setText(String text) {
        this.text = text;
    }

    void setAlphabet(String alphabet) {
        this.alphabet = alphabet.toCharArray();
    }

    private String cipherText() {
        return cipherText(text, alphabet, shift);
    }

    String getResult() {
        update();
        return result;
    }

    private void update() {
        result = cipherText();
    }

    private static String cipherText(String text, char[] alphabet, int shift) {
        if (shift < 0) shift = shift % alphabet.length + alphabet.length;
        char[] chars = text.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            int index = getIndex(alphabet, ch);
            if (index == -1) continue;
            int newIndex = (index + shift) % alphabet.length;
            chars[i] = alphabet[newIndex];
        }

        return new String(chars);
    }

    private static int getIndex(char[] array, char symbol) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == symbol) return i;
        }
        return -1;
    }
}
