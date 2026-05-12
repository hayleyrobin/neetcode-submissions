class Solution {
    public int lengthOfLongestSubstring(String s) {
        // sliding window O(n))
        // zxyzxyz
        if(s.length() == 0) return 0;

        int l = 0;
        int maxLength = 0;
        HashSet<Character> charSet = new HashSet<>();

        for(int r = 0; r < s.length(); r++){
            while(charSet.contains(s.charAt(r))){
                charSet.remove(s.charAt(l));
                l++; // shrink left window until were at new substring

            }
            
            // if a unique char, increase len
            charSet.add(s.charAt(r));
            int curLength = r - l + 1;
            maxLength = Math.max(maxLength, curLength);
        }

        return maxLength;
    }
}
