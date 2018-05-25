package main.java;

import org.junit.Test;

public class printFibonacciNumber {
    /**
     *  f0 = 1;
     *  f1 = 1;
     *  f2 = f1 + f0 = 2
     *  f3 = f2 + f3 = 3
     *  f4 = f3 + f2 = 5;
     *  ...
     *
     *  ..
     *  f(n) < 1000
     */

    public int fib(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative");
        }
        if ( n <= 1) {
            return 1;
        }
        return fib(n - 1) + fib(n-2 );
    }

    // DP:
    public int fibDP(int n) {
        int p = 1, q = 1;
        for (int i = 2; i <= n; i++) {  // n2; n3;  n4
            int temp = p;   // temp = 1;  temp = 2; temp = 3;
            p = p + q;      // p = 2;  p = 3;  p = 5;
            q = temp;       // q = 1;    q = 2;   q = 3;
        }
        return p;
    }

    public void printFibLessThanN(int N) {
        int i = 0;
        do {
            System.out.printf("Fib(%d):  %d%n", i, fibDP(i));
            i++;
        } while (fib(i) < N);
    }

    @Test
    public void testPrint() {
        printFibonacciNumber pf = new printFibonacciNumber();
        pf.printFibLessThanN(1000);
    }
}
