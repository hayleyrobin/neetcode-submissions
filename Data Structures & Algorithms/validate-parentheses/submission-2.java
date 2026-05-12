class Solution {
    public boolean isValid(String s) {
        // ([{}])
        HashMap<Character,Character> brack = new HashMap<>();
        brack.put(')','(');
        brack.put(']','[');
        brack.put('}','{');
        Stack<Character> s1 = new Stack<>();

        for(char c : s.toCharArray()){
            if(brack.containsKey(c))// if ending bracket
            {
                if(!s1.isEmpty() && s1.peek() == brack.get(c))
                {
                    s1.pop();
                }
                else //if stack is empty
                {
                    return false; // is not equal
                }
            }
            else{ // if starting bracket, push onto stack!
                s1.push(c); // ( [ {
            }
        }
        return s1.isEmpty();
    }
}
