class Solution {
    public int lastStoneWeight(int[] stones) {
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : stones){
           maxHeap.offer(i);
        }

        while ( maxHeap.size() > 1){

            int bigger = maxHeap.poll();
            int smaller = maxHeap.poll();

            if(bigger > smaller){
                maxHeap.add(bigger - smaller);
            }
        }
        maxHeap.add(0);
        return maxHeap.peek();
    }
}
