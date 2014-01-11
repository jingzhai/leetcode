public class Solution {
    public int climbStairs(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (n==0) return 0;
        if (n==1) return 1;
        if (n==2) return 2;
        int a0 = 1;
        int a1 = 2;
        int a2 = 3;
        for (int i=3;i<=n;i++) {
            a2 = a0+a1;
            a0 = a1;
            a1 = a2;
        }
        return a2;
    }
}
