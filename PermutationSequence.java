// For each k, divide the number of previous permutations into some factorials, for each factorial, count how many and save this info into an index array. Based on this array, we can choose which digit at each position. e.g, for n=4, k=20, it has 19 permutations before, 19 = 3*3! + 0*2! + 1*1! + 0, so the index[] would be 0,1,0,3 (reversing order), which can be interpreted as the order of digit in an ordered array, e.g, 3 means arr[3] in [1,2,3,4] which is 4.

public class Solution {
    public String getPermutation(int n, int k) {
        boolean[] used = new boolean[n+1];
        for (int i=0;i<=n;i++) {
            used[i]=false;
        }
        String res="";
        int f=factorial(n);
        int N=n;
        while(res.length() < N) {
            f /= n;
            int j=0;
            while(k > 0) {
                if(j!=0 && !used[j]) 
                    k -= f;  
                j++;                
            }           
            used[j-1] = true;
            k += f;
            res += j-1;
            n--;            
        }     
        return res;
    }
    private int factorial(int n) {
        int fact = 1; 
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}
