/**
UNDERSTAND
    Allowed to change anycharacter at most k times and return length of longest substring with the same letter ex. BBBB = 4
Input: string s, int k - operations of changing any character to any other uppercase character
Output: int, length of longest substring w/ same letter after performaing k operations
Cases:
    "ABAB" -> AAAA = 4

MATCH
Sliding window:
    Valid window: 
        If a window has a “main” letter, how many other letters can it tolerate before it needs too many changes?
        ~ changes needed = window length - count of the most frequent letter
        window length - maxCount <= k

PLAN
    intialize window ptrs and maxLen and maxCount and alphabet count array
    while endptr < len(s):
        add s[endPtr] into arr count
        maxCount = max(maxCount, count of current char)
        
        if (window length - maxCount > k):
            while not valid:(shrink window until valid)
            while (window length - maxCount > k):
                arr[s.charAt(startPtr) -'A']--;
                startPtr++
        window length = endPtr - startPtr + 1?
        maxLen = max(maxLen, window length)    
        endptr++
REVIEW/ EVALUATE:
    Time:
    Space:
    Edge Cases:
        k = 0 -> 0
        k = s.length() -> s: "ABCD" k = 4 ->
            four changes allowed
            longest same-letter substring can be AAAA?
        s has all same letters = LLLLL ->4
 */
class Solution {
    public int characterReplacement(String s, int k) {
        int left, right, maxLen, maxCount;
        left = right = maxLen = maxCount = 0;
        int[] freqArr = new int[26];

        while(right < s.length()){
            char currLetter = s.charAt(right);
            freqArr[currLetter - 'A']++; // update freq of letter
            maxCount =  Math.max(maxCount, freqArr[currLetter - 'A']); // count of most frequent letter

            // check if window is valid
            while((right - left + 1) - maxCount > k){
                freqArr[s.charAt(left) - 'A']--;
                left++;
            }
            // window is valid
            int windowLen = right - left + 1;
            maxLen = Math.max(maxLen, windowLen);
            right++;
        }

        return maxLen;
    }
}

