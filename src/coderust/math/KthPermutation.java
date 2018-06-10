package coderust.math;

import java.util.List;

public class KthPermutation {

    private int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n-1);
    }

    private int factorialII(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int res = 1;
        for (int i = 2; i <= n; i++) {
            res *= i;
        }
        return res;
    }

    public void findKthPermutation(List<Integer> nums, int k, StringBuilder result) {
        if (nums.isEmpty()) {
            return;
        }
        int n = nums.size();
        // size of the block
        int block = factorialII(n - 1);
        // which block of the selection
        int selected = (k - 1) / block;
        result.append(nums.get(selected));

        // prepare the input for the recursive call
        nums.remove(selected);
        k = k - selected * block;
        findKthPermutation(nums, k, result);
    }


    public static void main(String[] args) {
        KthPermutation permu = new KthPermutation();
        System.out.println(permu.factorialII(3));
    }
 }
