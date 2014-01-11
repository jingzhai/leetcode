public class Solution {
    public int maxSubArray(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (A.length==0) return 0;
        int max = A[0];
        int currMax = A[0]>0?A[0]:0;
        for (int i=1;i<A.length;i++) {
            if (A[i]+currMax>0) {
                currMax+=A[i];
                if (currMax>max) {
                    max = currMax;
                }
            } else {
                max=Math.max(A[i],max);
                currMax=(A[i]>=max&&A[i]>0)?A[i]:0;
            }
        }
        return max;
    }
}
