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

        int i = 0;
        while(i < str.length()){
            // find position of #
            int j = i;
            while(j < str.length() && str.charAt(j) != '#'){
                j++;
            }

            // get length before #
            int length = Integer.parseInt(str.substring(i, j));

            // move i past the #
            i = j + 1;

            // extract the string of that length
            result.add(str.substring(i, i + length));

            // move i past the extracted string and prepare for next loop
            i += length;
            // Compensate for the i++ in a for loop if using one, 
            // but here we switch to while and manually update i.
        }
        return result;
    }
}
