public class Solution {
    public int removeDuplicates(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int index=1;
        boolean flag=false; 
        if (A.length==0) return 0;
        for (int i=1;i<A.length;i++) {
            if (A[i]==A[i-1]) {
                if (!flag) {
                    flag=true;
                    A[index]=A[i];
                    index++;
                }
            } else {
                flag=false;
                A[index]=A[i];
                index++;
            }
        }
        
        return index;
    }
}
