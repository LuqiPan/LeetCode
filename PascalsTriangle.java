/*
 *Given numRows, generate the first numRows of Pascal's triangle.
 *
 *For example, given numRows = 5,
 *    Return
 *
 *    [
 *    [1],
 *    [1,1],
 *    [1,2,1],
 *    [1,3,3,1],
 *    [1,4,6,4,1]
 *    ]
 */

public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> rows = new ArrayList<ArrayList<Integer>>();
        if (numRows == 0) {
            return rows;
        }
        ArrayList<Integer> prev = new ArrayList<Integer>();
        prev.add(1);
        rows.add(prev);

        for (int i = 1 ; i < numRows ; i++) {
            ArrayList<Integer> cur = new ArrayList<Integer>();
            for (int j = 0 ; j <= i ; j++) {
                if (j == 0) {
                    cur.add(1);
                } else if (j == i) {
                    cur.add(1);
                } else {
                    cur.add(prev.get(j-1) + prev.get(j));
                }
            }
            rows.add(cur);
            prev = cur;
        }
        return rows;
    }
}
