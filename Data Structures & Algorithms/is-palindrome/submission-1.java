/**
Understand
    Return if string is same forward and backward after converting upper->lowercase and removing non alphabet numeric characters
Input: string 
Output: boolean, if string is a palindrom or not
Case:
    "A man, a plan, a canal: Panama" -> "amanaplanacanalpanama"
    " " -> "" : true for empty string
    "!!!" -> return true
Match
    Two pointers to compare ends
        -> move both pointers inward until one lands on an alphanumeric char , then compare! 
            says to remove all non-alphanumeric chars
        left = left character to compare
        right = right character to compare      
Plan
    Set left to 0 and right to s.length() - 1.

    While left < right:
    Move left forward while its character is not alphanumeric.
    Move right backward while its character is not alphanumeric.

    Convert both characters to lowercase and compare them.
    If they differ, return false.

    Move left forward and right backward.

    Return true.
Evaluate/Review
    Time: O(n) -> going through whole string length if it is a palindrome
    Space: O(1)
 */
class Solution {
    public boolean isPalindrome(String s) {
        int left = 0; // left Character to compare
        int right = s.length() - 1;

        while(left < right){
            // avoid indexing pass the ends & IndexOutOfBoundsException
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            // avoid indexing pass the ends & IndexOutOfBoundsException
            while(left < right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            char leftChar = Character.toLowerCase(s.charAt(left));
            char rightChar = Character.toLowerCase(s.charAt(right));
            if(leftChar != rightChar) return false;
            left++;
            right--;
        }
        return true;
    }
}
