package main.java;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Practice {

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
}
