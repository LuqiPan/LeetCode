/*
 *Given an array of integers, find two numbers such that they add up to a specific target number.
 *
 *The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 *
 *You may assume that each input would have exactly one solution.
 *
 *Input: numbers={2, 7, 11, 15}, target=9
 *Output: index1=1, index2=2
 */

import java.util.HashMap;
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int len = numbers.length;
        int[] result = new int[2];

        for (int i = 0 ; i < len ; i++) {
            Integer remainder = map.get(target-numbers[i]);
            if (remainder != null) {
                result[0] = remainder + 1;
                result[1] = i + 1;
                return result;
            } else {
                map.put(numbers[i], i);
            }
        }

        return result;
        //should never go here
    }
}
