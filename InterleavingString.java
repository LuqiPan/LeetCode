/*
 *ven s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 *
 *For example,
 *Given:
 *s1 = "aabcc",
 *s2 = "dbbca",
 *
 *When s3 = "aadbbcbcac", return true.
 *When s3 = "aadbbbaccc", return false.
 */

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len1 + len2 != len3) {
            return false;
        }
        if (s1.isEmpty()) {
            if (s2.equals(s3)) {
                return true;
            } else {
                return false;
            }
        }
        if (s2.isEmpty()) {
            if (s1.equals(s3)) {
                return true;
            } else {
                return false;
            }
        }

        boolean[][] B = new boolean[len1+1][len2+1];
        B[0][0] = true;
        for (int sum = 1 ; sum <= len3 ; sum++) {
            for (int pos1 = 0 ; pos1 <= sum ; pos1++) {
                int pos2 = sum - pos1;
                if (pos1 > 0 && pos1 <= len1 && pos2 <= len2 && B[pos1-1][pos2] && s3.charAt(sum-1) == s1.charAt(pos1-1)) {
                    B[pos1][pos2] = true;
                }
                if (pos2 > 0 && pos1 <= len1 && pos2 <= len2 && B[pos1][pos2-1] && s3.charAt(sum-1) == s2.charAt(pos2-1)) {
                    B[pos1][pos2] = true;
                }
            }
        }

        for (int i = 0 ; i <= len1 ; i++) {
            if (len3-i <= len2 && B[i][len3-i]) {
                return true;
            }
        }
        for (int i = 0 ; i <= len2 ; i++) {
            if (len3-i <= len1 && B[len3-i][i]) {
                return true;
            }
        }
        return false;
    }
}
