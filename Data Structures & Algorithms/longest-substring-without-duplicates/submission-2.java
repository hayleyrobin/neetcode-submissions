/**
UNDERSTAND
find longest substring no repeating chars(unique chars)
Input: string 
Output: int, length of longest substring of s

Cases: abcabcbb -> abc, bca, cab = 3
    "" : empty string -> 0
MATCH
    Pattern: What technique might help you avoid checking every substring?
        Sliding window and Set 

PLAN
    create starting pointer and ending for window at 0
    create set
    while right ptr < len(s)
        if we find a duplicate
            shrink left of window until no duplicates
        if no duplicate
            save letters and extend right of window

REVIEW
    Time: O(n) because each character enters and leaves the window at most once.
    Space: O(n) because the set can hold up to all distinct characters in the string.
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;

        Set<Character> charMap = new HashSet<>();
        int left, right, longestLen;
        left = right = longestLen = 0;
        
        while(right < s.length()){
            if(charMap.contains(s.charAt(right))){
                while(charMap.contains(s.charAt(right))){
                    charMap.remove(s.charAt(left));
                    left++;
                }
            }
            charMap.add(s.charAt(right));
            
            // compute the current window length from right - left + 1 each time
            longestLen = Math.max(longestLen, right - left + 1);
            right++;
        }
        return longestLen;
    }
}
