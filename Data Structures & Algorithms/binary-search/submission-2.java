class Solution {
    public int search(int[] nums, int target) {
        //Input: nums = [-1,0,2,4,6,8], target = 4
         return binarySearch(0, nums.length -1, nums, target); // -1, 8 , nums, 4
        
    }
    public int binarySearch(int start, int end, int[] arr, int target){
        if(start > end ) return -1; // if  past last pointer, not in array
        int mid = (start + end) / 2; // get mid point

        if(arr[mid] == target) return mid;

        return (target > arr[mid]) ? 
            binarySearch(mid + 1, end, arr, target ) :  // if 4 > 2,  search right half
            binarySearch(start, mid -1, arr, target); // if -1 < 2 search left half
    }
}
