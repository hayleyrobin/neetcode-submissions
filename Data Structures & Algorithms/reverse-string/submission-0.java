/* 
Understand 
    Input: arr of chars, representing a string 
    Output: void, in-place reverse chars in arr 
    Case: ['t','a','n'] -> ['n', 'a', 't'] 
Match 
    Two Pointers -> in place modifications 
    Left ptr = left side of Array 
    Right ptr = right side of Array 
Plan 
    Initialize ptrs at 0 and s.length -1 
    while(left < right) 
    swap chars move pointers inwards 
Review/Evaluate 
    Time: O(n) -> traverse entire Array 
    Space: O(1) -> 2 pointers , no extra space */ 
class Solution {
    public void reverseString(char[] s) {
        int left = 0; 
        int right = s.length - 1; 
        while(left < right){ 
            char temp = s[left]; 
            s[left] = s[right]; 
            s[right] = temp; 
            left++; 
            right--;
        }
    }
}