class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i = 0, n = intervals.length;
        List<int[]> output = new ArrayList<>();

        // Phase 1: add all intervals that end before newInterval starts
        while(i < n && intervals[i][1] < newInterval[0]) {
            output.add(intervals[i]);
            i++;
        }
        // Phase 2: merge overlapping intervals 
        while(i < n && intervals[i][0] <= newInterval[1]){
            // merge!
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        // add the merged interval (only once)
        output.add(newInterval);

        // Phase 3: intervals starting after newInterval[1]
        while(i < n){
            output.add(intervals[i]);
            i++;
        }

        return output.toArray(new int[output.size()][]);
    }
}
