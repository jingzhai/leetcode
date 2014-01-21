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
        if (intervals.size()<=1) return intervals;
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare (Interval i1, Interval i2){
                if (i1.start!=i2.start) return i1.start-i2.start;
                else return i1.end-i2.end;
            }
        });
        ArrayList<Interval> list = new ArrayList<Interval>();
        int start=intervals.get(0).start;
        int end=intervals.get(0).end;
        for (int i=1;i<=intervals.size();i++) {
            if (i<intervals.size() && intervals.get(i).start<=end) {
                end=Math.max(end,intervals.get(i).end);
            }
            else {
                Interval in = new Interval(start,end);
                list.add(in);
                if (i<intervals.size()) {
                    start=intervals.get(i).start;
                    end=intervals.get(i).end;
                }
            }
        }
        return list;
    }
}
