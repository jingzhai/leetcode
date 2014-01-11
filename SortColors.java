public class Solution {
    public void sortColors(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int index0=0;
        int index2=A.length-1;
        for (int i=0;i<=index2;) {
            if (A[i]==0) {
                if (i!=index0) {
                    A[i]=A[index0];
                    A[index0]=0;
                    index0++;
                } else {
                    index0++;
                    i++;
                }
            } else if (A[i]==2) {
                A[i]=A[index2];
                A[index2]=2;
                index2--;
            } else {
                i++;
            }
        }
    }
}
