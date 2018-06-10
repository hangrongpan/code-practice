package coderust.string;

import org.junit.Test;

public class ReverseWords {

    // First implement a helper function to reverse the string from start to end index
    private static void reverse(char[] input, int start, int end) {
        int right = end - 1;
        while (start < right) {
            char temp = input[start];
            input[start++] = input[right];
            input[right--] = temp;
        }
    }


    public String reverseWords(String words) {
        if (words == null) {
            return null;
        }
        char[] charArray = words.toCharArray();
        reverse(charArray, 0, charArray.length);
        int k = 0;
        for (int i = 0; i <= charArray.length; i++) {
            if (i == charArray.length || charArray[i] == ' ') {
                reverse(charArray, k, i);
                k = i+1;
            }
        }
        return new String(charArray);
    }



    @Test
    public void testReverse() {
        String s = "abcde";
        char[] a = s.toCharArray();
        reverse(a, 0, a.length);
        System.out.println(new String(a));
    }

    @Test
    public void testReverseWords() {
        String s = "Hello World";
        System.out.println(reverseWords(s));
    }
}
