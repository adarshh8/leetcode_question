class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int res = -1;
        int[] ans = new int[2];

        // first occurrence
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                res = mid;
                end = mid - 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        ans[0] = res;

        // reset variables
        start = 0;
        end = nums.length - 1;
        res = -1;

        // last occurrence
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                res = mid;
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        ans[1] = res;

        return ans;
    }
}
