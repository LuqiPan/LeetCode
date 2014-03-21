/*
 *Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 *
 *If the last word does not exist, return 0.
 *
 *Note: A word is defined as a character sequence consists of non-space characters only.
 *
 *For example, 
 *Given s = "Hello World",
 *return 5.
 */

public class Solution {
    public int lengthOfLastWord(String s) {
        int length = 0;
        int result = 0;
        char[] chars = s.toCharArray();
        for (char c: chars) {
            if (c == ' ') {
                if (length == 0) {
                    continue;
                }
                result = length;
                length = 0;
            } else {
                length++;
            }
        }
        return length > 0?length:result;
    }
}
