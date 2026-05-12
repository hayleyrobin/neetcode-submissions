/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, Comparator.comparingInt(i -> i.start));

        // iterate starting from 2nd meeting
        for(int meeting = 1; meeting < intervals.size(); meeting++){
            // compare to previous ending
            Interval i1 = intervals.get(meeting - 1); // previous meeting
            Interval i2 = intervals.get(meeting); // current meeting
            
            if(i1.end > i2.start) return false; // meetings overlap
        }
        return true;
    }
}
