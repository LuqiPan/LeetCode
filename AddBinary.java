/*
 *Given two binary strings, return their sum (also a binary string).
 *
 *For example,
 *a = "11"
 *b = "1"
 *Return "100".
 */

public class Solution {
    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) {
            return b;
        }
        if (b == null || b.length() == 0) {
            return a;
        }
        int m = a.length()-1;
        int n = b.length()-1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (m >= 0 || n >= 0 || carry == 1) {
            int digitA = (m >= 0)?a.charAt(m)-'0':0;
            int digitB = (n >= 0)?b.charAt(n)-'0':0;
            int sum = digitA + digitB + carry;
            carry = sum / 2;
            sum = sum % 2;
            sb.insert(0, sum);
            m = m>=0?--m:m;
            n = n>=0?--n:n;
        }
        return sb.toString();
    }
}
