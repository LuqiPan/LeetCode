/*
 *A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *
 *'A' -> 1
 *'B' -> 2
 *...
 *'Z' -> 26
 *Given an encoded message containing digits, determine the total number of ways to decode it.
 *
 *For example,
 *Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 *
 *The number of ways decoding "12" is 2.
 */

public class Solution {
    public int numDecodings(String s) {
        if (s == null) {
            return 0;
        }
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        int[] ways = new int[len+1];
        ways[0] = 1;
        if (s.charAt(0) <= '9' && s.charAt(0) >= '1') {
            ways[1] = 1;
        }
        for (int i = 1 ; i < len ; i++) {
            if (s.charAt(i) <= '9' && s.charAt(i) >= '1') {
                ways[i+1] += ways[i];
            }
            if (s.charAt(i-1) == '1' && s.charAt(i) <= '9' && s.charAt(i)>='0') {
                ways[i+1] += ways[i-1];
            }
            if (s.charAt(i-1) == '2' && s.charAt(i) <='6' && s.charAt(i) >= '0') {
                ways[i+1] += ways[i-1];
            }
        }
        return ways[len];
    }
}
