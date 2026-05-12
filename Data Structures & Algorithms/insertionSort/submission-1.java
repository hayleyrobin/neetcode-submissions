// Definition for a pair
// class Pair {
//     int key;
//     String value;
//
//     Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
public class Solution {
    public List<List<Pair>> insertionSort(List<Pair> pairs) {
        List<List<Pair>> lists = new ArrayList<>();

        for(int i=0; i < pairs.size(); i++){
            int j = i - 1; //get prev item
            while (j >= 0 && (pairs.get(j+1).key < pairs.get(j).key)) // while j is still in array & next # < prev #
            {
                Pair temp = pairs.get(j+1); // temp store next item
                pairs.set(j+1, pairs.get(j)); // set next item to larger number
                pairs.set(j, temp); // set prev item to smaller number
                j--;       
            }
            List<Pair> cloneList = new ArrayList<>(pairs);
            lists.add(cloneList);
        }
        return lists;
    }
}
