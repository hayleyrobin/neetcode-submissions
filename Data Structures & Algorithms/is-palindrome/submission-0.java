class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        String lowerCase = s.toLowerCase();
        while(left < right){
            Character begin = lowerCase.charAt(left);
            Character end = lowerCase.charAt(right);
            if(!Character.isLetterOrDigit(begin)){
                left++;
            }
            else if(!Character.isLetterOrDigit(end)){
                right--;
            }
            else{
                if(lowerCase.charAt(left) == lowerCase.charAt(right)){
                    left++;
                    right--;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}
