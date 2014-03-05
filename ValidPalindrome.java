/*
 *Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 *For example,
 *"A man, a plan, a canal: Panama" is a palindrome.
 *"race a car" is not a palindrome.
 *
 *Note:
 *Have you consider that the string might be empty? This is a good question to ask during an interview.
 *
 *For the purpose of this problem, we define empty string as valid palindrome.
 */

public class Solution {
    public boolean isAlpha(char c) {
        return (c <= 'z' && c >= 'a');
    }
    public boolean isNum(char c) {
        return (c <= '9' && c >= '0');
    }
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        if (s.length() < 2) {
            return true;
        }
        char[] chars = s.toLowerCase().toCharArray();
        int left = 0;
        int right = chars.length-1;

        while (left < right) {
            while (left < chars.length-1 && !isAlpha(chars[left]) && !isNum(chars[left])) {
                left++;
            }
            while (right > 0 && !isAlpha(chars[right]) && !isNum(chars[right])) {
                right--;
            }
            if (left >= right) {
                break;
            }
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
