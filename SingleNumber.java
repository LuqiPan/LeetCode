public class Solution {
    public int singleNumber(int[] A) {
        int single = 0;
        for (int i: A) {
            single ^= i;
        }
        return single;
    }
}
