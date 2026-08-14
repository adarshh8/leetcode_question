class Solution {
    public boolean searchMatrix(int[][] arr, int x) {
        int n=arr.length;
        int m=arr[0].length;
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         if(arr[i][j]==x) return true;
        //     }
        // }
        
        // return false;
        int i=n-1,j=0;
        while(i>=0 && j<m){
          if(arr[i][j]==x) return true;
          else if(arr[i][j]>x){
            i--;
          }else{
            j++;
          }
        }
        return false;
    }
}