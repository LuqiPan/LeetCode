/*
 *Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 *For example, given n = 3, a solution set is:
 *
 *"((()))", "(()())", "(())()", "()(())", "()()()"
 */

public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>();
        if (n == 0) {
            return result;
        }
        generator(result, new String(), 0, 0, n);
        return result;
    }
    public void generator(ArrayList<String> result, String s, int l, int r, int n) {
        if (l == n && r == n) {
            result.add(s);
            return;
        }
        if (l < n) {
            generator(result, s+'(', l+1, r, n);
        }
        if (r < l) {
            generator(result, s+')', l, r+1, n);
        }
    }
}
