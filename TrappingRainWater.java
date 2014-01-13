public class Solution {
    public int trap(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (A.length==0) return 0;
        
        int[] leftMax = new int[A.length];
        int[] rightMax = new int[A.length];
        int sum=0;
        
        leftMax[0]=0;
        for (int i=1;i<A.length;i++) {
            leftMax[i]=Math.max(leftMax[i-1], A[i-1]);
        }
        rightMax[A.length-1]=0;
        for (int i=A.length-2;i>=0;i--) {
            rightMax[i]=Math.max(rightMax[i+1], A[i+1]);
        }
        for (int i=0;i<A.length;i++) {
            if (A[i]<leftMax[i] && A[i]<rightMax[i]) {
                sum+=Math.min(leftMax[i],rightMax[i])-A[i];
            }
        }
        return sum;
    }
}
