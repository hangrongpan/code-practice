package datastructure;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Use a hashmap to store the string (k) and its freq (v)
 * The main point of this method is to create the comparator you need.
 * @author hpan
 *
 */
public class TopKFrequentB {
	public String[] topKFrequentwords(String[] words, int k) {
		if (words.length == 0 || k <= 0) {
			return new String[0];
		}

		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String word : words) {
			int f = 1;
			if (map.containsKey(word)) {
				f += map.get(word);
			}
			map.put(word, f);
		}

		Queue<WordFreq> queue = new PriorityQueue<WordFreq>(k, WordFreqComparator);
		for (String word : map.keySet()) {
			WordFreq tmp = queue.peek();
			WordFreq newWordFreq = new WordFreq(word, map.get(word));
			if (queue.size() < k) {
				queue.add(newWordFreq);
			} else if (WordFreqComparator.compare(tmp, newWordFreq) > 0) {
				queue.poll();
				queue.add(newWordFreq);
			}

		}

		String[] result = new String[k];
		int index = 0;
		while (!queue.isEmpty()) {
			result[index++] = queue.poll().word;
		}

		// do the reverse
		for (int i = 0; i < index / 2; i++) {
			String tmp = result[i];
			result[i] = result[index - i - 1];
			result[index - i - 1] = tmp;
		}
		return result;
	}

	private Comparator<WordFreq> WordFreqComparator = new Comparator<WordFreq>() {
		public int compare(WordFreq w1, WordFreq w2) {
			if (w1.freq != w2.freq) {
				return w1.freq - w2.freq;
			} else {
				return w2.word.compareTo(w1.word);
			}
		};
	};
}

class WordFreq {
	int freq;
	String word;

	public WordFreq(String w, int f) {
		freq = f;
		word = w;
	}
}