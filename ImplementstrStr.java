/*
 *Implement strStr().
 *
 *Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.
 */

public class Solution {
    public String strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return null;
        }
        if (needle.isEmpty()) {
            return haystack.substring(0);
        }
        char[] hs = haystack.toCharArray();
        char[] nd = needle.toCharArray();

        for (int i = 0 ; i <= hs.length - nd.length; i++) {
            for (int j = 0 ; j < nd.length; j++) {
                if (hs[i+j] == nd[j]) {
                    if (j == nd.length-1) {
                        return haystack.substring(i);
                    }
                } else {
                    break;
                }
            }
        }
        return null;
    }
}
