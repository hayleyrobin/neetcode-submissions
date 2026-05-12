class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // loop through list sort strings to see if anagram
        Map<String, List<String>> sortStrings = new HashMap<>();
        for(String s : strs){
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sorted = new String(charArray); // sorted

            // put sorted key and add OG word to list as value
            if(!sortStrings.containsKey(sorted)){
                sortStrings.putIfAbsent(sorted, new ArrayList<String>());
            }

            sortStrings.get(sorted).add(s);
            
        }
        List<List<String>> anagramList = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry : sortStrings.entrySet()){
            anagramList.add(entry.getValue());
        }
        return anagramList;
    }
}
