package main.java;

import org.junit.Test;

public class Solution {
    static String encode(String text) {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            b.append(c += c + i);
        }
        return b.reverse().toString();
    }

    static String decode(String encoded) {
        StringBuilder b = new StringBuilder();
        int len = encoded.length();
        for (int i = 0; i < len; i++) {
            int ascii = (int) encoded.charAt(i);
            int deco = (ascii - (len - 1 - i)) / 2;
            b.append(Character.toString((char) deco));
        }
        return b.reverse().toString();
    }

    @Test
    public void test() {
        System.out.println(encode("abcdef"));
        System.out.println(decode("ÑÎËÈÅÂ"));
    }
}