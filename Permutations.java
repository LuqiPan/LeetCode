/*
 *Given a collection of numbers, return all possible permutations.
 *
 *For example,
 *[1,2,3] have the following permutations:
 *[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */

public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int len = num.length;
        if (len == 0) {
            return result;
        }
        perm(num, 0, result);
        return result;
    }
    private void perm(int[] num, int pos, ArrayList<ArrayList<Integer>> result) {
        int len = num.length;
        if (pos == len-1) {
            result.add(convert(num));
            return;
        }
        for (int i = pos ; i < len ; i++) {
            swap(num, pos, i);
            perm(num, pos+1, result);
            swap(num, pos, i);
        }
    }

    private void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    private ArrayList<Integer> convert(int[] num) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i : num) {
            arr.add(i);
        }
        return arr;
    }
}
