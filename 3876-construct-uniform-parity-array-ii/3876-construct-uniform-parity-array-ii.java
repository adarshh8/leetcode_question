class Solution {
    public boolean uniformArray(int[] nums) {
        int minOdd = Integer.MAX_VALUE;
        boolean hasOdd = false;

        for (int x : nums) {
            if (x % 2 != 0) {
                minOdd = Math.min(minOdd, x);
                hasOdd = true;
            }
        }

        if (!hasOdd) {
            return true;
        }

        for (int x : nums) {
            if (x % 2 == 0 && x < minOdd) {
                return false;
            }
        }

        return true;
    }
}