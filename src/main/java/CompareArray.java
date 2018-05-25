package main.java;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CompareArray {
    /**
     * 1. Write a function that compares two arrays (a, b) and returns True if they're the same,
     * and False if they are not. The order does not matter. e.g. [7, 5, 2] is the same as [5, 2, 7].
     * Now do it with an argument 'k' that also allows the elements to be of 'k' difference
     * in the two arrays. Must be O(n).
     */

    public static boolean compareTwo(int[] A, int[] B) {
        if (A.length != B.length) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i])){
                map.put(A[i], map.get(A[i]) + 1);
            } else {
                map.put(A[i], 1);
            }
        }

        // start finding all the element of B from map
        for (int i = 0; i < B.length; i++) {
            if (!map.containsKey(B[i])) {
                return false;
            } else {
                if (map.get(B[i]) <= 1) {
                    map.remove(B[i]);
                } else {
                    map.put(B[i], map.get(B[i]) - 1);
                }
            }
        }
        return map.size() == 0;
    }

    @Test
    public void testCompareTwo() {
        int[] A = new int[]{2, 4, 8, 9};
        int[] B = new int[]{4, 8, 2, 9};
        Assert.assertTrue(compareTwo(A, B));

        A = new int[]{3, 4, 2, 7};
        B = new int[]{2, 3, 0, 7};
        Assert.assertFalse(compareTwo(A, B));
    }

    public static boolean compareTwoArrayWithK(int[] A, int[] B, int k) {
        if (k < 0) {
            throw new IllegalArgumentException("Invalid k");
        }
        if (Math.abs(A.length - B.length) > k) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i])){
                map.put(A[i], map.get(A[i]) + 1);
            } else {
                map.put(A[i], 1);
            }
        }

        // start finding all the element of B from map
        for (int i = 0; i < B.length; i++) {
            if (!map.containsKey(B[i])) {
                k--;
            } else {
                if (map.get(B[i]) <= 1) {
                    map.remove(B[i]);
                } else {
                    map.put(B[i], map.get(B[i]) - 1);
                }
            }
        }

        // calculate the remaining count in the map
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            sum += entry.getValue();
        }
        return k - sum >= 0;
    }
}
