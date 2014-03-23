/*
 *Given a sorted array of integers, find the starting and ending position of a given target value.
 *
 *Your algorithm's runtime complexity must be in the order of O(log n).
 *
 *If the target is not found in the array, return [-1, -1].
 *
 *For example,
 *Given [5, 7, 7, 8, 8, 10] and target value 8,
 *return [3, 4].
 */

class Solution {
    public int[] searchRange(int[] A, int target) {
        int[] result = new int[]{-1,-1};
        int left = findLeft(A, target);
        if (left == -1) {
            return result;
        }
        int right = findRight(A, target);
        result[0] = left;
        result[1] = right;
        return result;
    }
    public int findLeft(int[] A, int target) {
        int low = 0;
        int high = A.length-1;
        while (low <= high) {
            int mid = (low+high)/2;
            if (A[mid] == target && (mid == 0 || A[mid-1] < A[mid])) {
                return mid;
            }
            if (A[mid] >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
    public int findRight(int[] A, int target) {
        int low = 0;
        int high = A.length-1;
        while (low <= high) {
            int mid = (low+high)/2;
            if (A[mid] == target && (mid == A.length-1 || A[mid] < A[mid+1])) {
                return mid;
            }
            if (A[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
