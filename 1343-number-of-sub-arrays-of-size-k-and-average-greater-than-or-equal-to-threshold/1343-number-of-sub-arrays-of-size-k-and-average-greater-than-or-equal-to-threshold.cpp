class Solution {
public:
    int numOfSubarrays(vector<int>& arr, int k, int threshold) {
        int count=0;
        int sum = 0;
        int n=arr.size();

        for(int i=0;i<k;i++){
            sum+=arr[i];
        }

        int avg = sum/k;
        if(avg>=threshold){
            count++;
        }

        for(int i=k;i<n;i++){
            sum=sum-arr[i-k]+arr[i];
            avg = sum/k;
            if(avg>=threshold){
                count++;
            }
        }

        return count;
    }
};