/*
 *Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 *
 *You may assume that the intervals were initially sorted according to their start times.
 *
 *Example 1:
 *Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 *
 *Example 2:
 *Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 *
 *This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
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
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        for (Interval i: intervals) {
            if (i.end < newInterval.start) {
                result.add(i);
            } else if (i.start > newInterval.end) {
                result.add(newInterval);
                newInterval = i;
            } else {
                int s = Math.min(i.start, newInterval.start);
                int e = Math.max(i.end, newInterval.end);
                newInterval = new Interval(s, e);
            }
        }
        result.add(newInterval);
        return result;
    }
}
