/*
 *Given an array and a value, remove all instances of that value in place and return the new length.
 *
 *The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */

public class Solution {
    public int removeElement(int[] A, int elem) {
        if (A.length == 0) {
            return 0;
        }
        int left = 0;
        int right = A.length - 1;

        if (A.length == 1) {
            if (A[0] == elem) {
                return 0;
            } else {
                return 1;
            }
        }

        while (true) {
            while (left < A.length && A[left] != elem) {
                left++;
                //stops at A[left] == elem
            }
            while (right >= 0 && A[right] == elem) {
                right--;
                //stops at A[right] != elem
            }
            if (left == right + 1) {
                break;
            }
            if (left < A.length && right >= 0) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
            }
        }

        return left;
    }
}
