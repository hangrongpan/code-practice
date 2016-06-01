package datastructure;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * A very naive way to solve problem when you want to sort items based on your
 * customized factor.
 * 
 * @author hpan
 *
 */
public class MergeKSortedArrays {

	public List<Integer> mergeKSortedArrays(int[][] arrays) {
		List<Integer> res = new ArrayList<Integer>();
		if (arrays == null || arrays.length == 0) {
			return res;
		}
		Queue<Element> queue = new PriorityQueue<Element>(arrays.length, ElementComparator);
		for (int i = 0; i < arrays.length; i++) {
			if (arrays[i].length > 0) {
				Element e = new Element(i, 0, arrays[i][0]);
				queue.add(e);
			}
		}

		while (!queue.isEmpty()) {
			Element e = queue.poll();
			res.add(e.val);
			if (e.col + 1 < arrays[e.row].length) {
				Element newElement = new Element(e.row, e.col + 1, arrays[e.row][e.col + 1]);
				queue.add(newElement);
			}
		}
		return res;
	}

	private Comparator<Element> ElementComparator = new Comparator<Element>() {
		public int compare(Element o1, Element o2) {
			return o1.val - o2.val;
		};
	};
}

/*
 * [ [1, 3, 5, 7], [2, 4, 6], [0, 8, 9, 10, 11] ] two-d array -> element
 */

class Element {
	int row;
	int col;
	int val;

	public Element(int r, int c, int v) {
		row = r;
		col = c;
		val = v;
	}
}