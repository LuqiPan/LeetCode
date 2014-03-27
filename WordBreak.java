/*
 *Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 *For example, given
 *s = "leetcode",
 *dict = ["leet", "code"].
 *
 *Return true because "leetcode" can be segmented as "leet code".
 */

public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        boolean[] T = new boolean[s.length()+1];
        T[0] = true;
        for (int i = 0 ; i < s.length() ; i++) {
            for (int j = 0 ; j <= i ; j++) {
                String temp = s.substring(j, i+1);
                if (dict.contains(temp) && T[j]) {
                    T[i+1] = true;
                    break;
                }
            }
        }
        
        return T[s.length()];
    }
}
