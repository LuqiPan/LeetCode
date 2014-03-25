/*
 *Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 *
 *Note:
 *Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 *The solution set must not contain duplicate quadruplets.
 *    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 *
 *    A solution set is:
 *    (-1,  0, 0, 1)
 *    (-2, -1, 1, 2)
 *    (-2,  0, 0, 2)
 */

public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int len = num.length;
        if (len < 4) {
            return result;
        }
        Arrays.sort(num);
        
        for (int i = 0 ; i <= len - 4 ; i++) {
            if (i != 0 && num[i] == num[i-1]) {
                continue;
            }
            for (int j = i+1 ; j <= len -3; j++) {
                if (j != i+1 && num[j] == num[j-1]) {
                    continue;
                }
                int low = j+1;
                int high = len-1;
                while (low < high) {
                    int sum = num[i] + num[j] + num[low] + num[high];
                    if (sum == target) {
                        ArrayList<Integer> temp = new ArrayList<Integer>();
                        temp.add(num[i]);
                        temp.add(num[j]);
                        temp.add(num[low]);
                        temp.add(num[high]);
                        result.add(temp);
                        do {
                            low++;
                        } while (low < high && num[low] == num[low-1]);
                        do {
                            high--;
                        } while (low < high && num[high] == num[high+1]);
                    } else if (sum > target) {
                        high--;
                    } else {
                        low++;
                    }
                }
            }
        }
        
        return result;
    }
}
