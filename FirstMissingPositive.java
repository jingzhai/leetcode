public class Solution {
    public int firstMissingPositive(int[] A) {

        for (int i=0;i<A.length;) {
            if (A[i]<=0 || A[i]==i+1 || A[i]>=A.length || A[A[i]-1] == A[i]) {
                i++;
            } else {
                int temp=A[i];
                A[i]=A[temp-1];
                A[temp-1]=temp;
            }
        }
        for (int i=0;i<A.length;i++) {
            if (A[i]!=i+1) return i+1;
        }
        return A.length+1;
    }
}
