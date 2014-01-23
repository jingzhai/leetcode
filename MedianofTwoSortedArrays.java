public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        if ((A.length+B.length)%2==1) {
            return findKth(A,0,A.length,B,0,B.length,(A.length+B.length)/2+1); 
        } else {
            double num1=(double)findKth(A,0,A.length,B,0,B.length,(A.length+B.length)/2);
            double num2=(double)findKth(A,0,A.length,B,0,B.length,(A.length+B.length)/2+1);
            return (num1+num2)/2;
        }
    }
    private int findKth(int A[], int a, int alen, int B[],  int b, int blen, int k) {
        if (alen>blen) return findKth(B,b,blen,A,a,alen,k);
        if (alen==0) return B[b+k-1];
        if (k==1) return Math.min(A[a],B[b]);
        int pa=Math.min(k/2,alen);
        int pb=k-pa;
        if (A[a+pa-1]<=B[b+pb-1]) return findKth(A,a+pa,alen-pa,B,b,blen,k-pa);
        return findKth(A,a,alen,B,b+pb,blen-pb,k-pb);
    }
}
