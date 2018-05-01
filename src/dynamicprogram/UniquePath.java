package dynamicprogram;

import org.junit.Test;

public class UniquePath {

    // This is the bottom up approach for the backtracking.
    public int uniquePath(int m, int n) {
        int[][] mat = new int[m+1][n+1];
        mat[m-1][n] = 1; // Pay attention to the extra space it used here.
        for (int r = m-1; r>=0; r--) {
            for (int c = n-1; c>=0; c--) {
                mat[r][c] = mat[r+1][c] + mat[r][c+1];
            }
        }
        return mat[0][0];
    }

    @Test
    public void testUniquePath() {
        System.out.println(uniquePath(2,2));
    }
}
