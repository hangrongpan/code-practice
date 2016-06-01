import java.util.ArrayList;

class Interval {
	int start;
	int end;

	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

/**
 * Insert Interval - merge if necessary.
 * 
 * @author hpan
 *
 */
public class InsertInterval {
	public ArrayList<Interval> insertIntervals(ArrayList<Interval> intervals, Interval newInterval) {
		ArrayList<Interval> res = new ArrayList<Interval>();
		if (intervals.size() == 0) {
			res.add(newInterval);
			return res;
		}
		int i = 0;
		while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
			res.add(intervals.get(i));
			i++;
		}
		if (i < intervals.size()) {
			newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
		}
		res.add(newInterval);
		while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
			newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
			i++;
		}
		while (i < intervals.size()) {
			res.add(intervals.get(i));
			i++;
		}
		return res;
	}
}
