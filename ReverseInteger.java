public class Solution {
    public int reverse(int x) {
        int y = 0;
        while (x != 0) {
            int remainder = x % 10;
            x /= 10;
            y *= 10;
            y += remainder;
        }
        return y;
    }
}
