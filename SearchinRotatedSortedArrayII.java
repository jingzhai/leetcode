public class Solution {
    public boolean search(int[] A, int target) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        return searchRotate(A, target, 0, A.length-1);
    }
    private boolean searchRotate(int[] A, int target, int l, int r) {
        if (l>r) return false;
        if (l==r) {
            if (A[l]!=target) return false;
            else return true;
        } 
        while (l<A.length-2) {
            if (A[l+1]==A[l]) l++;
            else break;
        }
        while (r>0) {
            if (A[r-1]==A[r]) r--;
            else break;
        }
        if (l>r) return false;
        int mid=(l+r)/2;
        if (A[mid]==target || A[l]==target || A[r]==target) return true;

        if (A[l]>A[mid]) {
            if (A[l]>target && A[mid]<target) return searchRotate(A, target, mid+1, r);
            if ((A[l]<target && A[mid]<target) || (A[l]>target && A[mid]>target)) return searchRotate(A,target,l,mid-1);

        } else {
            if ((A[l]<target && A[mid]<target)  || (A[l]>target && A[mid]>target)) return searchRotate(A, target, mid+1, r);
            if ((A[l]<target && A[mid]>target)) return searchRotate(A,target,l,mid-1);
        }
        return false;
    }
}
