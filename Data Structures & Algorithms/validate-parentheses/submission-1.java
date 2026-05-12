
class Solution {
    public boolean isValid(String s) {
        // s = [{}([{}])]
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();

        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');



        for(int i=0; i< s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                // if closing char, pop opening off stack
                if(!stack.isEmpty() && stack.peek() == map.get(s.charAt(i))){
                    stack.pop();
                }
                else{ 
                    return false;
                }
            } // if opening char, push onto stack
            else {
                stack.push(s.charAt(i)); // [{
            }
            
        }
        return stack.isEmpty();


    }
}
