class Solution {
public:
    vector<int> numberGame(vector<int>& nums) {
       vector<int> arr;
       sort(nums.begin(),nums.end());
       int n = nums.size();

       for(int i=0;i<n;i+=2){
            arr.push_back(nums[i+1]);
            arr.push_back(nums[i]);
       }
       return arr;
    }
};