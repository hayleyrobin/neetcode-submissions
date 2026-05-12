class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // points = [[0,2],
        //           [2,2]], k = 1

        // For every point (x, y), compute its squared distance: dist = x^2 + y^2
        Arrays.sort(points, (a,b) -> (a[0] * a[0] + a[1] * a[1]) - 
                                        (b[0] * b[0] + b[1] * b[1]));
        // sort all points based on distance value
        // return first 3 k points from sorted list
        return Arrays.copyOfRange(points, 0, k);
    }
}
