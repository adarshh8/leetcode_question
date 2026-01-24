class Solution {
    public int pivotIndex(int[] nums) {
     int n = nums.length;
     int totalSum=0; //totalsum as well as right sum
     int leftSum=0;

     for(int i=0;i<n;i++){
        totalSum += nums[i];
     }
     for(int i=0;i<n;i++){
        totalSum = totalSum - nums[i];
        if(leftSum == totalSum){
            return i;
        }
        leftSum = leftSum + nums[i];
     }
     return -1;


    }
}