/*
 *Given a collection of intervals, merge all overlapping intervals.
 *
 *For example,
 *Given [1,3],[2,6],[8,10],[15,18],
 *return [1,6],[8,10],[15,18].
 */

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }

        Collections.sort(intervals, new IntervalComparator());
        ArrayList<Interval> result = new ArrayList<Interval>();

        Interval prev = intervals.get(0);

        for (int i = 1 ; i < intervals.size() ; i++) {
            Interval cur = intervals.get(i);

            if (prev.end >= cur.start) {
                int s = prev.start;
                int e = Math.max(prev.end, cur.end);
                prev = new Interval(s, e);
            } else {
                result.add(prev);
                prev = cur;
            }
        }
        result.add(prev);
        return result;
    }
    class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval i1, Interval i2) {
            return i1.start-i2.start;
        }
    }
}
