class Solution {
    public int[][] merge(int[][] intervals) {
        // Sort intervals by start
        // a: one interval {8,2} b: another {2,6}
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0])); // a[0]: 8, a[1]:2. b[0]:2, b[1]:6
        // Integer.compare(x,y) : x < y ? negative(x is first) : positive(y is first) : 0 (equal)
        
        List<int[]> output = new ArrayList<>();
        output.add(intervals[0]); // add first interval as current merged interval

        for(int[] interval : intervals){
            int startTime = interval[0]; // in current row : 2
            int endTime = interval[1]; // in current row: 6
            // endTime of the last merged interval in output list
            int lastEnd = output.get(output.size() -  1)[1]; 

            if(startTime <= lastEnd){
                // if overlapping, update last interval's end
                output.get(output.size() - 1)[1] = Math.max(lastEnd, endTime);
            } else{
                output.add(new int[]{startTime, endTime});
                // if not overlapping, start new merged interval 
            }
        }
        // convert List<int> back into int[][]
        return output.toArray(new int[output.size()][]);
    }
}
