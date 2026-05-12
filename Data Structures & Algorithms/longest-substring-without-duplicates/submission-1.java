class Solution {
    public int lengthOfLongestSubstring(String s) {
        // s = "zxyzxyz"
        if(s == null || s.length() == 0) return 0;
        // loop over string
        // keep two pointers, store char in set
        // if char repeats, bring start ptr to end ptr to restart window
        int maxSubstring = 0, start = 0;
        Set<Character> charSet = new HashSet<>();
        for(int end = 0; end < s.length(); end++){
            char c = s.charAt(end);
            if(charSet.contains(c)){ // if repeated char
                // restart window
                while(charSet.contains(c)){
                    charSet.remove(s.charAt(start));
                    start++;
                }

            }
            charSet.add(c);
            maxSubstring = Math.max(maxSubstring, end - start + 1);
        }
        return maxSubstring;
    }
}
