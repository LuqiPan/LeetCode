/*
 *Given an index k, return the kth row of the Pascal's triangle.
 *
 *For example, given k = 3,
 *Return [1,3,3,1].
 *
 *Note:
 *Could you optimize your algorithm to use only O(k) extra space?
 */

public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        int[] result = new int[rowIndex+1];
        if (rowIndex == 0) {
            result[0] = 1;
            return toArrayList(result);
        }
        for (int i = 1 ; i <= rowIndex ; i++) {
            result[0] = 1;
            for (int j = i-1 ; j > 0 ; j--) {
                result[j] = result[j] + result[j-1];
            }
            result[i] = 1;
        }
        return toArrayList(result);
    }

    public ArrayList<Integer> toArrayList(int[] array) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i: array) {
            result.add(i);
        }
        return result;
    }
}
