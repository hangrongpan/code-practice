package main.java;

import org.junit.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class WordCount {
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

    @Test
    public void testCountWordDocument() {
        String document = "Practice makes perfect. you'll only get Perfect by practice. just practice!";

        // 1. clean word
        Map<String, Integer> wordCount = new HashMap<>();
        String[] allWords = document.toLowerCase().split(" ");
        for (String word: allWords) {
            char[] charArray = new char[word.length()];
            int i = 0;
            for (Character c : word.toCharArray()) {
                if (c >= 'a' && c <= 'z') {
                    charArray[i++] = c;
                }
            }
            String cleanWord;
            if (charArray.length < 1) {
                continue;
            } else {
                cleanWord = new String(charArray).trim();
            }

            System.out.println(cleanWord);
            // add word to hashmap
            if (wordCount.containsKey(cleanWord)) {
                wordCount.put(cleanWord, wordCount.get(cleanWord) + 1);
            } else {
                wordCount.put(cleanWord, 1);
            }
        }
        // sort hashMap
        TreeMap<String, Integer> treeWordcount = sortByValue(wordCount);
        // result count
        String[][] result = new String[wordCount.size()][2];
        int index = 0;
        for (Map.Entry<String, Integer> entry : treeWordcount.entrySet()) {
            String[] item = new String[2];
            item[0] = entry.getKey();
            item[1] = Integer.toString(entry.getValue());
            result[index++] = item;
        }

        System.out.println(result);

    }

    static TreeMap<String, Integer> sortByValue(Map<String, Integer> map) {
        Comparator<String> comparator = new ValueComparator(map);
        TreeMap<String, Integer> treeMap = new TreeMap<>(comparator);
        treeMap.putAll(map);
        return treeMap;
    }

}

class ValueComparator implements Comparator<String> {
    Map<String, Integer> map;
    public ValueComparator(Map<String, Integer> map) {
        this.map = map;
    }
    @Override
    public int compare(String s1, String s2) {
        if (map.get(s1) >= map.get(s2)) {
            return -1;
        } else {
            return 1;
        }
    }
}