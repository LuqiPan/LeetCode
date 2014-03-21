/*
 *Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 *
 *For example,
 *Given [100, 4, 200, 1, 3, 2],
 *The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 *
 *Your algorithm should run in O(n) complexity.
 */

public class Solution {
    public int longestConsecutive(int[] num) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int n: num) {
            set.add(n);
        }
        int max = 0;
        for (int n: num) {
            if (!set.contains(n)) {
                continue;
            }
            int count = 1;
            int cur = n-1;
            while (set.contains(cur)) {
                count++;
                set.remove(cur);
                cur--;
            }

            cur = n+1;
            while (set.contains(cur)) {
                count++;
                set.remove(cur);
                cur++;
            }

            max = Math.max(max, count);
        }

        return max;
    }
}
