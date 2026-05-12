class Solution {
    public int[] countBits(int n) {
        int[] onesArray = new int[n+1];
        for(int i = 0; i <= n; i++){
            int cur = i;
            while(cur > 0){
                if((cur & 1) == 1){
                    onesArray[i]++;
                }
                cur = cur >> 1;
            }
            
        }
        return onesArray;
    }
}
