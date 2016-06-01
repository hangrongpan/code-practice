package datastructure;

import java.util.Stack;

public class ImplementsQueueTwoStacks {

}

/**
 * Using two stacks to implement a queue structure
 * 
 * @author hpan
 *
 */
class Queue {
	private Stack<Integer> stack1;
	private Stack<Integer> stack2;

	public Queue() {
		stack1 = new Stack<Integer>();
		stack2 = new Stack<Integer>();
	}

	public void push(int val) {
		stack1.push(val);
	}

	public int pop() {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.pop();
	}

	public int top() {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.peek();
	}

	public boolean isEmpty() {
		return stack1.isEmpty() && stack2.isEmpty();
	}
}
