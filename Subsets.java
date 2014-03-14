/*
 *Given a set of distinct integers, S, return all possible subsets.
 *
 *Note:
 *Elements in a subset must be in non-descending order.
 *The solution set must not contain duplicate subsets.
 *For example,
 *If S = [1,2,3], a solution is:
 *
 *    [
 *    [3],
 *    [1],
 *    [2],
 *    [1,2,3],
 *    [1,3],
 *    [2,3],
 *    [1,2],
 *    []
 *    ]
 */

public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        boolean[] B = new boolean[S.length];
        dfs(S, B, 0, result);
        return result;
    }

    private void dfs(int[] S, boolean[] B, int depth, ArrayList<ArrayList<Integer>> result) {
        if (depth == S.length) {
            result.add(convert(S, B));
            return;
        }
        B[depth] = true;
        dfs(S, B, depth+1, result);
        B[depth] = false;
        dfs(S, B, depth+1, result);
    }
    private ArrayList<Integer> convert(int[] S, boolean[] B) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 0 ; i < S.length ; i++) {
            if (B[i]) {
                arr.add(S[i]);
            }
        }
        return arr;
    }
}
