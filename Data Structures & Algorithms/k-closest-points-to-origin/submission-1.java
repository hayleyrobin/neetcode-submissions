class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // points = [[0,2],
        //           [2,2]], k = 1
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparing(a -> a[0])); // a[0] first element(distance) in array a[]
        for(int[] point : points){
            int x = point[0] * point[0];
            int y = point[1] * point[1];
            int distance = x + y;
            minHeap.offer(new int[]{distance, point[0], point[1]});
        }
        
        int[][] smallest = new int[k][2];
        for(int i = 0; i < k; i++){
            int[] point = minHeap.poll();
            smallest[i] = new int[]{point[1], point[2]};
        }
        return smallest;
    }
}
