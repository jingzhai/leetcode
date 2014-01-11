public class Solution {
    public int searchInsert(int[] A, int target) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int i=0;
        while (i<A.length && target>A[i]) {
            i++;
        }
        return i;
    }
}
