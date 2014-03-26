/*
 *Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 *
 *For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 *the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 *
 *click to show more practice.
 *
 *More practice:
 *If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */

public class Solution {
    public int maxSubArray(int[] A) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0 ; i < A.length ; i++) {
            sum += A[i];
            maxSum = Math.max(maxSum, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }
}

//Recursive solution
public class Solution {
    public int maxSubArray(int[] A) {
        return helper(A, 0, A.length-1);
    }
    public int helper(int[] A, int left, int right) {
        if (left < 0 || right >= A.length) {
            return Integer.MIN_VALUE;
        }
        if (left == right) {
            return A[left];
        }
        int mid = (left + right) / 2;
        int maxOneSide = Math.max(helper(A, left, mid), helper(A, mid+1, right));
        
        int sum = A[mid] + A[mid+1];
        int maxBoth = sum;
        
        for (int i = mid-1 ; i >= left ; i--) {
            sum += A[i];
            maxBoth = Math.max(maxBoth, sum);
        }
        sum = maxBoth;
        for (int i = mid+2 ; i <= right ; i++) {
            sum += A[i];
            maxBoth = Math.max(maxBoth, sum);
        }
        return Math.max(maxBoth, maxOneSide);
    }
}

