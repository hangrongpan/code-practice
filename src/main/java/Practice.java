package main.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Practice {


    static int getMostVisited(int n, int[] sprints) {
        if (n <= 0 || sprints.length == 0) {
            return -1;   // return a flag if input is invalid.
        }
        int[] res = new int[n];
        for (int i = 0; i < sprints.length - 1 ; i++) {
            int start = sprints[i];
            int end = sprints[i+1];
            count(res, start, end);
        }
        int max = 0;
        int maxPos = 0;
        for (int i = 0; i < res.length; i++) {
            if (res[i] > max) {
                max = res[i];
                maxPos = i;
            }
        }
        return maxPos + 1; // based 1 index.
    }

    static void count(int[] result, int start, int end) {
        if (start > end) {
            count(result, end, start);
        }
        for (int i = start-1; i <= end-1; i++) {
            result[i]++;
        }
    }


    @Test
    public void testAA() {
        getMostVisited(10, new int[] {5, 10});
    }



    static int countConsecutive2(int N)
    {
        // constraint on values of L gives us the
        // time Complexity as O(N^0.5)
        int count = 0;
        for (int L = 1; L * (L + 1) < 2 * N; L++)
        {
            float a = (float) ((1.0 * N-(L * (L + 1)) / 2) / (L + 1));
            if (a-(int)a == 0.0)
                count++;
        }
        return count;
    }
    static int consecutive(int num) {
        int count = 0;
        for (int i = 1; i * (i+1) < 2 * num; i++) {
            //Math problem: num = a + (a+1) + (a+2) + ... + (a+i):
            float a = (float) ((num * 1.0 - (i * (i + 1)) / 2) / (i + 1));
            if (a - Math.ceil(a) == 0.0) {
                count++;
            }
        }
        return count;
    }



    @Test
    public void hackerrank() {
        System.out.println(consecutive(15));
    }

    @Test
    public void test() {
        char c = '1';
        int i = (int) c;
        System.out.printf("Character 1: %d%n", i);
        int i2 = Character.getNumericValue(c);
        System.out.printf("Character 1 to numeric: %d%n", i2);
    }


    @Test
    public void test2() {
        boolean[] exist = new boolean[256];
        char c = 'a';
        exist[c] = true;
        for (int i = 0; i < exist.length; i++) {
            if (exist[i]) {
                System.out.println(i);
            }
        }
        System.out.println((int)c);
    }

    @Test
    public void testPrioriyQueue() {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int[] ia = { 1, 10, 5, 3, 4, 7, 6, 9, 8 };
        for (int x : ia) {
            pq.offer(x);
        }
        System.out.println("PQ: " + pq);
        while(!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }

    @Test
    public void testMinPQ() {
        PriorityQueue<Integer> pq = new PriorityQueue<>(8, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return  o1 - o2;
            }
        });
        int[] ia = { 1, 10, 5, 3, 4, 7, 6, 9, 8 };
        for (int x : ia) {
            pq.offer(x);
        }
        System.out.println("PQ: " + pq);
        while(!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }

    @Test
    public void testArray() {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 9, 10};
        int index = Arrays.binarySearch(a, 9);
        System.out.println(index);
        Arrays.fill(a, 10);
        printArray(a);
    }

    private static void printArray(int[] a) {
        for(int x : a) {
            System.out.printf("%d ", x);
        }
    }
}
