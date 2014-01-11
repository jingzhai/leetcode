public class Solution {
    public int removeElement(int[] A, int elem) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int newlen = A.length;
        for (int i=0;i<newlen;i++) {
            while (A[i]==elem && newlen>0 && i<newlen) {
                A[i] = A[newlen-1];
                newlen--;
            }
        }
        return newlen;
    }
}
