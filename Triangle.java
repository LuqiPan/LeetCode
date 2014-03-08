/*
 *Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 *
 *For example, given the following triangle
 *    [
 *    [2],
 *    [3,4],
 *    [6,5,7],
 *    [4,1,8,3]
 *    ]
 *The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 *Note:
 *Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */

public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int n = triangle.size();
        int[] minPaths = new int[n];

        for (int i = 0 ; i < n ; i++) {
            minPaths[i] = triangle.get(n-1).get(i);
        }
        for (int i = n-2 ; i >= 0 ; i--) {
            for (int j = 0 ; j <= i ; j++) {
                minPaths[j] = triangle.get(i).get(j) + Math.min(minPaths[j], minPaths[j+1]);
            }
        }
        return minPaths[0];
    }
}
