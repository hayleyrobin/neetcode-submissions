class Solution {
    public int reverseBits(int n){
        StringBuilder binary = new StringBuilder();
        // build a string of the binary version of n
        for(int i = 0; i < 32; i++){
            // shift 1 for each bit placement
            if ((n & (1 << i)) != 0) // if the bit is 1 (1&1 = 1)
            {
                binary.append("1");
            }
            else{ // if bit is 0
                binary.append("0");
            }
        }
        // binary: 10101000000000000000000000000000

        // reverse sequence of bits
        int reversedInt = 0;
        // reversedInt = 00000000000000000000000000000000
        String reversedBinary = binary.reverse().toString();
        // reversedBinary = 00000000000000000000000000010101

        for(int i = 0; i < 32; i++){
            // add 1 to the corresponding bit in result using bit shifting
            if(reversedBinary.charAt(i) == '1'){ // set 1 if it appears in our reversed string
                reversedInt = reversedInt | (1 << i); // (0 or 1 = 1 to set)
            }
        }
        return reversedInt;
    }
}