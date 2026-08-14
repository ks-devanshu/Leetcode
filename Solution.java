import java.util.Arrays;
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (x, y) -> (int) (euclidean(x) - euclidean(y)));
        int[][] result = new int[k][2];
        int i = 0;
        while (i < k) {
            result[i] = points[i];
            i++;
        }
        return result;
    }
    
    private double euclidean(int[] point) {
        return (point[0] * point[0]) + (point[1] * point[1]);
    }
}