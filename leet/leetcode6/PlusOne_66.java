package leetcode6;

/**
 * Created by Henry Pan on 6/2/2016.
 */
public class PlusOne_66 {
    public int[] solution(int[] digits) {
        for (int i = digits.length - 1; i > 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
            } else {
                digits[i] = 0;
            }
        }

        int[] newDigits;
        if (digits[0] == 0) {
            newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            for (int i = 1; i < newDigits.length; i++) {
                newDigits[i] = digits[i-1];
            }
        } else {
            newDigits = new int[digits.length];
            for (int i = 0; i < digits.length; i++) {
                newDigits[i] = digits[i];
            }
        }
        return newDigits;
    }
}
