// Given a set of non-overlapping intervals, insert a new interval into
//  the intervals (merge if necessary).

// You may assume that the intervals were initially sorted according to 
// their start times.

// Example 1:
// Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

// Example 2:
// Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as
//  [1,2],[3,10],[12,16].

// This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

//

public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(newInterval == null) return intervals;
        int first = 0;
        /*find first overlapping interval*/
        while(first < intervals.size() && newInterval.start > intervals.get(first).end)
            first++;   
        /*merge intervals */
        while(first < intervals.size() && newInterval.end >= intervals.get(first).start)
        {
            newInterval = new Interval(Math.min(newInterval.start,intervals.get(first).start),
                                      Math.max(newInterval.end,intervals.get(first).end));
            intervals.remove(first);
        }
        intervals.add(first,newInterval);
        return intervals;
    }
    //
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> res = new ArrayList<Interval>();
        for(Interval interval : intervals) {
            if(interval.end < newInterval.start) {// [1,2] _[3,4]_
                res.add(interval);
            } else if(interval.start > newInterval.end) {// _[1,2]_ [3,4]
                res.add(newInterval);
                newInterval = interval;
            } else if(interval.start <= newInterval.end || interval.end >= newInterval.start) { // [1,3] _[2,4]_ or _[1,3]_ [2,4]
                newInterval.start = Math.min(interval.start, newInterval.start);
                newInterval.end = Math.max(interval.end, newInterval.end);
            }
        }
        res.add(newInterval);
        return res;
    }
}

//
public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    List<Interval> result = new LinkedList<>();
    int i = 0;
    // add all the intervals ending before newInterval starts
    while (i < intervals.size() && intervals.get(i).end < newInterval.start)
        result.add(intervals.get(i++));
    // merge all overlapping intervals to one considering newInterval
    while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
        newInterval = new Interval( // we could mutate newInterval here also
                Math.min(newInterval.start, intervals.get(i).start),
                Math.max(newInterval.end, intervals.get(i).end));
        i++;
    }
    result.add(newInterval); // add the union of intervals we got
    // add all the rest
    while (i < intervals.size()) result.add(intervals.get(i++)); 
    return result;
}

