class Solution {
    public int lastStoneWeight(int[] stones) {
        List<Integer> arr = new ArrayList<>();
        for(int i : stones){
            arr.add(i);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(arr);

        while ( maxHeap.size() > 1){

            int y = maxHeap.poll();
            int x = maxHeap.poll();

            if(y > x){
                maxHeap.add(y - x);
            }
        }
        maxHeap.add(0);
        return maxHeap.peek();
    }
}
