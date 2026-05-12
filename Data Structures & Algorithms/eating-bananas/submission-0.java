class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // piles = [1,4,3,2] h = 9 (hours to eat all bananas) k = bananas-per-hour/pile
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt(); // maximum useful speed is the size of the largest pile.
        int result = r; // min number of hours (guarantees that Koko can finish all piles within h hours )
        
        //binary search over k possible ranges of eating speeds
         // l-> 1 4<-k 3 2 <-r

         while(l <= r){
            int k = (l+r) / 2; //4
            int totalTime = 0;
            for(int p : piles){
                totalTime += Math.ceil((double) p / k); // 1/2 + 4/2 + 3/2 + 2/2 = 1+2+2+1 = 6
            }
            if(totalTime <= h) // if 6 <= 9
            {
                result = k; // min number of hours so far
                r = k - 1; // go to previous index(pile)
            }
            else{ 
                l = k + 1;  // go to next index(pile)    
            }
         }
         return result;

    }
}
