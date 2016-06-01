package datastructure;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {

	public String[] topKWords(String[] words, int k) {
		class WordFreq implements Comparable<WordFreq> {
			String word;
			int freq;

			public WordFreq(String w, int c) {
				word = w;
				freq = c;
			}

			@Override
			public int compareTo(WordFreq other) {
				if (this.freq != other.freq) {
					return Integer.compare(this.freq, other.freq);
				}
				return other.word.compareTo(this.word);
			}
		}

		if (words.length == 0 || k == 0) {
			return new String[0];
		}

		Map<String, Integer> frequencyMap = new HashMap<String, Integer>();
		PriorityQueue<WordFreq> topKHeap = new PriorityQueue<WordFreq>(k);
		for (String word : words) {
			int freq = 1;
			if (frequencyMap.containsKey(word)) {
				freq = frequencyMap.get(word) + 1;
			}

			// update the frequency map
			frequencyMap.put(word, freq);
		}

		// Build the topK heap
		for (java.util.Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
			if (topKHeap.size() < k) {
				topKHeap.add(new WordFreq(entry.getKey(), entry.getValue()));
			} else if (entry.getValue() > topKHeap.peek().freq || (entry.getValue() == topKHeap.peek().freq
					&& entry.getKey().compareTo(topKHeap.peek().word) < 0)) {
				topKHeap.remove();
				topKHeap.add(new WordFreq(entry.getKey(), entry.getValue()));
			}
		}

		// extract the top K
		String[] topK = new String[k];
		int i = 0;
		while (topKHeap.size() > 0) {
			topK[i++] = topKHeap.remove().word;
		}

		for (int j = 0; j < i / 2; j++) {
			String tmp = topK[j];
			topK[j] = topK[i - j - 1];
			topK[i - j - 1] = tmp;
		}
		return topK;
	}

}
