/*
 *Given an array of strings, return all groups of strings that are anagrams.
 *
 *Note: All inputs will be in lower-case.
 */

public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        ArrayList<String> result = new ArrayList<String>();
        for (String s: strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            if (!map.containsKey(sorted)) {
                ArrayList<String> arr = new ArrayList<String>();
                arr.add(s);
                map.put(sorted, arr);
            } else {
                map.get(sorted).add(s);
            }
        }

        Set<String> set = map.keySet();
        for (String s: set) {
            ArrayList<String> arr = map.get(s);
            if (arr.size() > 1) {
                result.addAll(arr);
            }
        }

        return result;
    }
}
