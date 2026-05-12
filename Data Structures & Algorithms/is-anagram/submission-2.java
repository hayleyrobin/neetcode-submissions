class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        for(Map.Entry<Character, Integer> entry : sMap.entrySet()){
            Character sKey = entry.getKey();
            if(!entry.getValue().equals(tMap.get(sKey))){
                return false;
            }
        }
        return true;
    }
}
