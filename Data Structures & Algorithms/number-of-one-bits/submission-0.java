class Solution {
    public int hammingWeight(int n) {
        // non negative number
        // n : 10111
        int count = 0;
        while(n > 0){
            if((n & 1) == 1) {
                count++;
            }
            n = n >> 1; // shift left once 
        }
        return count;
    }
}
