package leetcode3;

import java.util.*;

class ValidateSudoku_36 {
	public boolean solution(char[][] board) {
		HashSet<Character> set = new HashSet<Character>();
		//row
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.')
					continue;
				if (set.contains(board[i][j]))
					return false;
				set.add(board[i][j]);
			}
			set.clear();
		}

		//col
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				// same above
			}
		}

		//sub-grid
		for (int k = 0; k < 9; k++) {
			for (int i = k/3*3; i < k/3*3+3; i++) {
				for (int j = k%3*3; j < k%3*3+3; j++) {
					// same above;
				}
			}
		}
		return true;
	}
}