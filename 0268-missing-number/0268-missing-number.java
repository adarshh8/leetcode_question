class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        int n=nums.length;
        int sumarr = 0;
        for (int i=0;i<=n;i++)
        {
            sum = sum+i;
        }
        for(int i=0;i<n;i++)
        {
            sumarr += nums[i];
        }
        int ans = sum - sumarr;
        return ans;

    }
    

}