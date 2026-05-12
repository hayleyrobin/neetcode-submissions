class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length == 0) return new int[]{};
        // hash map to count frequency
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int i : nums){
            freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
            
        }
        // sort by values descending
        PriorityQueue<Map.Entry<Integer,Integer>> q = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());

        for(Map.Entry<Integer,Integer> entry  : freqMap.entrySet()){
            q.add(entry);
        }
        int[] mostFreq = new int[k];
        for(int i = 0; i < k; i++){
            mostFreq[i] = q.poll().getKey();
        }
        return mostFreq;

        
    }
}
