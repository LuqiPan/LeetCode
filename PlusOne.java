/*
 *Given a non-negative number represented as an array of digits, plus one to the number.
 *
 *The digits are stored such that the most significant digit is at the head of the list.
 */

public class Solution {
    public int[] plusOne(int[] digits) {
        if (digits.length == 0) {
            return digits;
        }
        int carry = 1;

        for (int i = digits.length - 1 ; i >= 0 ; i--) {
            int result = carry + digits[i];
            if (result == 10) {
                digits[i] = 0;
                carry = 1;
                continue;
            }
            digits[i] = result;
            carry = 0;
            break;
        }
        if (carry == 0) {
            return digits;
        }
        int[] newDigits = new int[digits.length+1];
        newDigits[0] = 1;
        for (int i = 0 ; i < digits.length ; i++) {
            newDigits[i+1] = 0;
        }
        return newDigits;
    }
}
