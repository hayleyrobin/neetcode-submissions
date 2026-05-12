class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> charMap = new HashMap<String, List<String>>();
        List<List<String>> groupString = new ArrayList<>();
        // sort !

        for(String s : strs){
            char[] sortedS = s.toCharArray();
            Arrays.sort(sortedS);
            String word = new String(sortedS);
            charMap.putIfAbsent(word, new ArrayList<>());
            charMap.get(word).add(s);
        }
        for(Map.Entry<String, List<String>> entry : charMap.entrySet()){
            List<String> tmpArr = new ArrayList<>();

            for(int i=0; i < entry.getValue().size(); i++){
                tmpArr.add(entry.getValue().get(i));
            }
            groupString.add(tmpArr);
        }
        return groupString;
        
    }
}
