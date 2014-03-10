/*
 *Given a roman numeral, convert it to an integer.
 *
 *Input is guaranteed to be within the range from 1 to 3999.
 */

public class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;
        int i = s.length() - 1;
        int prev = 0;

        while (i >= 0) {
            char c = s.charAt(i);
            int cur = map.get(c);
            if (cur >= prev) {
                result += cur;
            } else {
                result -= cur;
            }
            prev = cur;
            i--;
        }
        return result;
    }
}
