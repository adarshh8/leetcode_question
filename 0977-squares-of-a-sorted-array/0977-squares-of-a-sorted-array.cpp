class Solution {
public:
    vector<int> sortedSquares(vector<int>& nums) {
        int left=0;
        int right=nums.size()-1;
        int index=nums.size()-1;
        vector<int> res(nums.size(),0);
        while(left<=right){
            if(abs(nums[left])>abs(nums[right])){
                res[index]=nums[left]*nums[left];
                left++;
            }else{
                res[index]=nums[right]*nums[right];
                right--;
            }
            index--;
        }
        return res;
    }
};