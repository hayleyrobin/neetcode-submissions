class Solution {

    public String encode(List<String> strs) {
        // Input: dummy_input = ["Hello","World"]
        StringBuilder sb = new StringBuilder();

        for(String s : strs){
            //4#Hello
            int strLen = s.length();
            char delimitter = '#';
            sb.append(strLen).append(delimitter).append(s);
        }
        return sb.toString();

    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();

        for(int i = 0; i < str.length(); i++){
            // get pointer to find hashtag
            int j = i;
            while(j < str.length() && str.charAt(j) != '#'){
                j++; 
            }// found hashtag

            int wordLen = Integer.parseInt(str.substring(i, j));

            i = j+1;
            String word = str.substring(i, i + wordLen);
            result.add(word);
            i = i + wordLen - 1;
        }
        return result;
    }
}
