/*
 *Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:
 *
 *Only one letter can be changed at a time
 *Each intermediate word must exist in the dictionary
 *For example,
 *
 *Given:
 *start = "hit"
 *end = "cog"
 *dict = ["hot","dot","dog","lot","log"]
 *As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *return its length 5.
 *
 *Note:
 *Return 0 if there is no such transformation sequence.
 *All words have the same length.
 *All words contain only lowercase alphabetic characters.
 */

public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        LinkedList<String> strQ = new LinkedList<String>();
        LinkedList<Integer> countQ = new LinkedList<Integer>();

        if (start.equals(end)) {
            return 0;
        }
        strQ.add(start);
        countQ.add(1);

        while (!strQ.isEmpty()) {
            String str = strQ.remove();
            int count = countQ.remove();
            if (str.equals(end)) {
                return count;
            }
            for (int i = 0 ; i < str.length() ; i++) {
                for (char c = 'a' ; c <= 'z' ; c++) {
                    char[] chars = str.toCharArray();
                    chars[i] = c;
                    String newStr = new String(chars);
                    if (dict.contains(newStr)) {
                        strQ.add(newStr);
                        countQ.add(count+1);
                        dict.remove(newStr);
                        //Because it's BFS, so when you see it, you are using the least distance possible.
                        //So it's safe to remove it from dict
                    }
                }
            }
        }
        return 0;
    }
}
