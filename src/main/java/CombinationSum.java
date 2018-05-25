package main.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;

public class CombinationSum {

    // NP problem ;  or Backtracking.
    public ArrayList<ArrayList<Integer>> combination(int n, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (n <= 0 || n < k) {
            return res;
        }
        // create a item for storing intermediate result.
        ArrayList<Integer> item = new ArrayList<>();
        helper(n, k, 1, item, res);
        return res;
    }

    public void helper(int n, int k, int start,  ArrayList<Integer> item, ArrayList<ArrayList<Integer>> res) {
        if (item.size() == k) {
            res.add(new ArrayList<Integer>(item));
            return;
        }
        for (int i = start; i <= n; i++) {
            // backtracking..
            item.add(i);
            helper(n, k, i+1, item, res);
            item.remove(item.size() - 1);
        }
    }


    @Test
    public void testBacktracking() {
        CombinationSum c = new CombinationSum();
        c.combination(4, 2);
    }
}
