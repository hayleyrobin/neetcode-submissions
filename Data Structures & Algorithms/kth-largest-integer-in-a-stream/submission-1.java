class KthLargest {
    PriorityQueue<Integer> minHeap;
    int k;

    public KthLargest(int k, int[] nums) {
        this.minHeap = new PriorityQueue<>();
        this.k = k;
        // inserts all initial nums into a min heap
        for(int i = 0; i < nums.length; i++){
            minHeap.add(nums[i]);
            if (minHeap.size() > k){ // if heap size > k, repeatedly remove smallest elmt
                minHeap.poll();
            }
        }
        // heap now contains exactly k elmts (3)
    }
    
    public int add(int val) {
        minHeap.offer(val); // add to heap 
        if (minHeap.size() > k){ // if heap size > k
            minHeap.poll();        // remove the smallest elmt (the root of heap)
        }
        return minHeap.peek(); // get root which is now the k-th largest of list
        
    }
}
