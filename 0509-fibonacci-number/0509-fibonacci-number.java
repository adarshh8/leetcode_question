class Solution {
    public int fib(int n) {
        // int a = 0;
        // int b = 1;
        if(n==0 || n==1){
            return n;
        }
        return fib(n-1)+fib(n-2);
        
    }
}