class Solution {
public:
    int minimumRecolors(string blocks, int k) {
        int count = 0;
        int n = blocks.size();

        for(int i=0;i<k;i++){
            if(blocks[i]=='W'){
                count++;
            }
        }
        int maxCount = count;
        for(int i=k;i<n;i++){
            if(blocks[i]=='W'){
                count++;
            }
            if(blocks[i-k]== 'W'){
                count--;
            }
            maxCount=min(maxCount,count);
        }
        return maxCount;
    }
};