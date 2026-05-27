class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // intervals = [[1,3],[4,6]], newInterval = [2,5]
        // already sorted 
        List<int[]> output = new ArrayList<>();
        
        for(int[] interval : intervals){
            // Case 1: newInterval already placed, OR current interval ends before new starts → add current safely
            if (newInterval == null || interval[1] < newInterval[0]) {
                output.add(interval);
            }
            // Case 2: first interval that starts after newInterval ends → insert newInterval then this interval
            else if (interval[0] > newInterval[1]) {
                output.add(newInterval);
                output.add(interval);
                newInterval = null;
            }
            // Case 3: overlap → merge into newInterval (don't add yet)
            else {
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }
        // If the loop ends, it means newInterval belongs at the end:
        
        // comes after all existing intervals or result of merging but not added
        if(newInterval != null){
            output.add(newInterval);
        }
        return output.toArray(new int[output.size()][]);
        
    }
}
