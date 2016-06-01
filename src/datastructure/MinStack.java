package datastructure;

import java.util.Stack;

public class MinStack {
	Stack<Integer> stack;
	Stack<Integer> mins;
	int curMin = Integer.MAX_VALUE;
	
	public MinStack() {
		stack = new Stack<Integer>();
		mins = new Stack<Integer>();
	}
	
	public void push(int item) {
		stack.push(item);
		curMin = Math.min(item, curMin);
		mins.push(curMin);
	}
	
	public int pop() {
		mins.pop();
		if (mins.isEmpty()) {
			curMin = Integer.MIN_VALUE;
		} else {
			curMin = mins.peek();
		}
		return stack.pop();
	}
	
	public int min() {
		return curMin;
	}
}
