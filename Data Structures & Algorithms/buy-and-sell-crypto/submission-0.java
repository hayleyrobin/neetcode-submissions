class Solution {
    public int maxProfit(int[] prices) {
        //two ptrs
        int l = 0, r = 1;
        int curMax = 0;

        while(r < prices.length){
            if(prices[l] < prices[r]){
                int profit = prices[r] - prices[l];
                if(profit > curMax){
                    curMax = profit;
                }
            }
            else{
                l = r; // found the lowest price to buy
            }
            r++;
        }
        return curMax;
        
    }
}
