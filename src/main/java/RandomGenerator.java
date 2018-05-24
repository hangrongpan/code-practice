package main.java;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class RandomGenerator {

    /*
    This will generate number [0, 999]
     */
    public static int random1000() {
        return (int) (Math.random() * 1000);
    }

    @Test
    public void testRandom1000() {
        for (int i = 0; i < 10; i++) {
            System.out.println(random1000());
        }
    }

    /*
    Given a number array : [2, 4, 7, 9, 0]
    Given a dist of the possibility of above array [1, 3, 2, 3, 1]
    Ex: for number at index 0, it is possibility is 1/10  = 0.1;
    write a function randomDist() that generate above number randomly.
     */
    private static final int[] nums = new int[]{2, 4, 7, 9, 0};
    private static final int[] dist = new int[]{1, 3, 2, 3, 1};

    /*
    Base on the dist list, we create a new array, with the number generate based on the occurance.
     */
    public static int randonDist() {
        int sum = 0;
        for (int x : dist) {
            sum += x;
        }
        int[] arr = new int[sum];
        int index = 0;
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist[i]; j++) {
                arr[index++] = nums[i];
            }
        }
        // generate a random number [0, sum-1]
        int rand = (int) (Math.random()* sum);
        return arr[rand];
    }

    /*
    To save the space on the new array.
    cumulative sum of the dist array.
    [1, 3, 2, 3, 1 ] ->  [1, 4, 6, 9, 10]
    <=1  count 1
    >1 and <= 4  count 3
    >4 and <= 6  count 2
    >6 and <= 9  count 3
    >9 and <= 10 count 1

    find the ceil of the rand.
     */
    public static int randomDist() {
        int N = dist.length;
        int[] cumulative = new int[N];
        int sum = 0;
        for (int i= 0; i < N; i++) {
            sum += dist[i];
            cumulative[i] = sum;
        }
        int rand = (int) Math.ceil(Math.random() * sum); // [1: sum]
        int index = findCeil(cumulative, rand);
        return nums[index];
    }

    private static int findCeil(int[] cumu, int rand) {
        if (cumu.length == 0) {
            return -1;
        }
        if (rand <= cumu[0]) {
            return 0;
        }
        for (int i = 0; i < cumu.length - 1; i++) {
            if (rand > cumu[i] && rand <= cumu[i+1]) {
                return i+1;
            }
        }
        return -1;
    }

    @Test
    public void testRandonDist() {
        int[] p = new int[5];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(2, 0);
        map.put(4, 1);
        map.put(7, 2);
        map.put(9, 3);
        map.put(0, 4);
        for (int i = 0; i < 100000; i++) {
            int rand = randonDist();
            if (map.containsKey(rand)) {
                p[map.get(rand)]++;
            }
        }
        for (int i = 0 ; i < p.length; i++) {
            System.out.printf("Index: %d, possibility: %.2f%n", i, p[i] / 1000.0);
        }
    }

    @Test
    public void testRandomDist() {
        int[] p = new int[5];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(2, 0);
        map.put(4, 1);
        map.put(7, 2);
        map.put(9, 3);
        map.put(0, 4);
        for (int i = 0; i < 100000; i++) {
            int rand = randomDist();
            if (map.containsKey(rand)) {
                p[map.get(rand)]++;
            }
        }
        for (int i = 0 ; i < p.length; i++) {
            System.out.printf("Index: %d, possibility: %.2f%n", i, p[i] / 1000.0);
        }
    }
}
