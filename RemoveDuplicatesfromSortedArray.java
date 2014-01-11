public class Solution {
    public int removeDuplicates(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int p = 1;
        int i = 1;
        if (A.length<=1) return A.length;
        while (i<A.length) {
            if (A[i]!=A[p-1]) {
                A[p]=A[i];
                p++;
            } else {
                A[p-1]=A[i];
            }
            i++;
        }
        return p;
    }
}
