public class Solution {
    public boolean canJump(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (A.length==0) return false;
        
        ArrayList<Integer> zeros = new ArrayList<Integer>();
        for (int i=0;i<A.length-1;i++) {
            if (A[i]==0) zeros.add(i);
        }
        for (int zero: zeros) {
            boolean canJumpThis=false;
            for (int i=0;i<zero;i++) {
                if (i+A[i]>zero) {
                    canJumpThis=true;
                    break;
                }
            }
            if (!canJumpThis) return false;
        }
        return true;
    }
}
