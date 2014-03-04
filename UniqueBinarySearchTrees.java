/*
 *Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 *
 *For example,
 *Given n = 3, there are a total of 5 unique BST's.
 *
 *   1         3     3      2      1
 *    \       /     /      / \      \
 *     3     2     1      1   3      2
 *    /     /       \                 \
 *   2     1         2                 3
 */

public class Solution {
    public int numTrees(int n) {
        int[] sum = new int[n+1];
        sum[0] = 1;
        for (int i = 1 ; i <= n ; i++) {
            sum[i] = 0;
            for (int j = 1 ; j <= i ; j++) {
                sum[i] += sum[j-1]*sum[i-j];
            }
        }
        return sum[n];
    }
}
