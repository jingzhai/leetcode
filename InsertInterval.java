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
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval ni) {
        
        if (intervals.size()==0) {
            ArrayList<Interval> ilist = new ArrayList<Interval>();
            ilist.add(ni);
            return ilist;
        }
        int s=0;
        int e=intervals.size()-1;
        while (s<intervals.size() && intervals.get(s).end<ni.start) {
            s++;
        }
        while (e>=0 && intervals.get(e).start>ni.end) {
            e--;
        }

        int newStart=(s>=intervals.size())?ni.start:Math.min(intervals.get(s).start,ni.start);
        int newEnd=(e<0)?ni.end:Math.max(intervals.get(e).end,ni.end);

        Interval in = new Interval(newStart,newEnd);
        for (int i=e;i>=s;i--) {
            intervals.remove(i);
        }
        intervals.add(s,in);
        return intervals;
    }
}
