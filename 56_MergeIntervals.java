/*
 * Given a collection of intervals, merge all overlapping intervals.
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
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
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval left, Interval right) {
                if(left.start == right.start) return 0;
                else if(left.start > right.start) return 1;
                else  return -1;
            }
        });
        List<Interval> list = new ArrayList<Interval>();
        Interval toCompare = null;
        for(Interval interval : intervals) {
            if(toCompare != null && interval.end >= toCompare.start 
                && interval.start <= toCompare.end){
                toCompare.start = Math.min(interval.start, toCompare.start);
                toCompare.end = Math.max(interval.end, toCompare.end);
            } else {
                if(toCompare != null) list.add(toCompare);
                toCompare = interval;
            }
        }
        if(toCompare != null) list.add(toCompare);
        return list;
    }
}