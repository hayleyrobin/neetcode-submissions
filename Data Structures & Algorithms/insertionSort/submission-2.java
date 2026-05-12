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
        List<List<Pair>> listOfPairs = new ArrayList<>();
        int length = pairs.size();

        for(int i=0; i<length; i++){
            int j = i - 1; //previous number
            while(j >= 0 && pairs.get(j+1).key < pairs.get(j).key) //if next # < prev #
            {
                Pair temp = pairs.get(j+1);
                pairs.set(j+1, pairs.get(j));
                pairs.set(j, temp);
                j--;
            }
            List<Pair> cloneList = new ArrayList<>(pairs);
            listOfPairs.add(cloneList);
        }
        return listOfPairs;

    }
}
