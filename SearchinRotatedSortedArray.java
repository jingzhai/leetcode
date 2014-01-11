public class Solution {
    public int search(int[] A, int target) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        return searchRotate(A, target, 0, A.length-1);
    }
    private int searchRotate(int[] A, int target, int l, int r) {
        if (l>r) return -1;
        if (l==r) {
            if (A[l]!=target) return -1;
            else return l;
        } 
        int mid=(l+r)/2;
        if (A[mid]==target) return mid;
        if (A[l]==target) return l;
        if (A[r]==target) return r;
        if (A[l]>A[mid]) {
            if (A[l]>target && A[mid]<target) return searchRotate(A, target, mid+1, r);
            if ((A[l]<target && A[mid]<target) || (A[l]>target && A[mid]>target)) return searchRotate(A,target,l,mid-1);

        } else {
            if ((A[l]<target && A[mid]<target)  || (A[l]>target && A[mid]>target)) return searchRotate(A, target, mid+1, r);
            if ((A[l]<target && A[mid]>target)) return searchRotate(A,target,l,mid-1);
        }
        return -1;
    }
}
