class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>(); // key: charFreq array, val: list of string anagrams

        for(String s : strs){
            int[] count = new int[26]; // reps char frequency
            for(char c : s.toCharArray()){
                count[c - 'a']++; // char - 26 = index value in char array 0-25

            }
            // convert array to tuple and use as key
            String key = Arrays.toString(count);
            anagramMap.putIfAbsent(key, new ArrayList<>());
            anagramMap.get(key).add(s);
        }
        List<List<String>> anagramList = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry : anagramMap.entrySet()){
            anagramList.add(entry.getValue());
        }
        return anagramList;        
    }
}
