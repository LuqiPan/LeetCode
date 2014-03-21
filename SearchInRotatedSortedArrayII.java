/*
 *Follow up for "Search in Rotated Sorted Array":
 *What if duplicates are allowed?
 *
 *Would this affect the run-time complexity? How and why?
 *
 *Write a function to determine if a given target is in the array.
 */

public class Solution {
    public boolean search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return false;
        }
        int left = 0;
        int right = A.length-1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (A[mid] == target) {
                return true;
            }
            if (A[left] < A[mid]) {
                if (A[left] <= target && target < A[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (A[left] > A[mid]) {
                if (A[mid] < target && target <= A[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                left++;
            }
        }
        return false;
    }
}
