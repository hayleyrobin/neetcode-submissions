class KthLargest {
    List<Integer> arr;
    int k;

    public KthLargest(int k, int[] nums) {
        arr = new ArrayList<>();
        this.k = k;
        for(int i = 0; i < nums.length; i++){
            arr.add(nums[i]);
        }
    }
    
    public int add(int val) {
        arr.add(val);
        Collections.sort(arr);
        return arr.get(arr.size() - k); // (len(arr) - k) == kth largest
        
    }
}
