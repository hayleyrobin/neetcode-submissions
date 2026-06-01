class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] freqArr = new int[26];
        for(int i = 0; i < s.length(); i++){
            // 'a' has the numeric value 97

            // 'b' - 'a'  →  98 - 97 = 1   →  index 1 
            // 'z' - 'a'  → 122 - 97 = 25  →  index 25
            freqArr[s.charAt(i) - 'a']++;
            freqArr[t.charAt(i) - 'a']--;
        }

        for(int val : freqArr){
            if(val != 0) return false;
        }
        return true;
    }
}
