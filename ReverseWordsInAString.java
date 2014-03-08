/*
 *Given an input string, reverse the string word by word.
 *
 *For example,
 *Given s = "the sky is blue",
 *return "blue is sky the".
 *
 *click to show clarification.
 *
 *Clarification:
 *What constitutes a word?
 *A sequence of non-space characters constitutes a word.
 *Could the input string contain leading or trailing spaces?
 *Yes. However, your reversed string should not contain leading or trailing spaces.
 *How about multiple spaces between two words?
 *Reduce them to a single space in the reversed string.
 */

public class Solution {
    static public String reverseWords(String s) {
        s = s.trim();
        if (s.isEmpty()) {
            return "";
        }
        String[] strs = s.split(" ");
        String result = new String();
        for (int i = strs.length - 1 ; i >= 0 ; i--) {
            if (strs[i].isEmpty()) {
                continue;
            }
            result += strs[i].trim();
            if (i != 0) {
                result += " ";
            }
        }
        return result;
    }
    static public void main(String[] args) {
        reverseWords("  a    b  ");
    }
}
