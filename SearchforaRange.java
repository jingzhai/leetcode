public class Solution {
    public int[] searchRange(int[] A, int target) {
        int i=0;
        int j=A.length-1;
        int[] results={-1,-1};
        //the idea is to put the lower bound in i
        while(i<j){
            int mid=i+(j-i)/2;
            if(target<=A[mid])
                j=mid;
            else
                i=mid+1;
        }
        if(A[i]==target) 
            results[0]=i;
        else
            return results; 
        i=0;
        j=A.length;
        //the idea is to put the upper bound in j-1
        while(i<j){
            int mid=i+(j-i)/2;
            if(target>=A[mid])
                i=mid+1;
            else
                j=mid;
        }
        results[1]=j-1;
        return results;
    }
}

public class Solution {
    public int[] searchRange(int[] A, int target) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        return search (A, target, 0, A.length-1);
        
    }
    
    private int[] search(int[] A, int target, int s, int e) {
        if (s>e) {
            return new int[]{-1,-1};
        }
        int mid = (s+e)/2;
        int[] result = new int[2];
        if (A[mid]<target) {
            result = search(A, target, mid+1, e);
        } else if (A[mid]>target){
            result = search(A, target, s, mid-1);
        } else if (A[mid]==target) {
            result[0]=mid;
            result[1]=mid;
            int start=s;
            int end=mid-1;
            for (int i=end;i>=start&&start<=end;) {
                if (A[i]==target) {
                    result[0]=i;
                    end=i-1;
                    i=(start+end)/2;
                    if (i==result[0]) break;
                } else {//(A[i]<target) 
                    start=i+1;
                    i=(start+end)/2;
                }
            }
            start=mid+1;
            end=e;
            for (int i=start;i<=end&&start<=end;) {
                if (A[i]==target) {
                    result[1]=i;
                    start=i+1;
                    i=(start+end)/2;
                    if (i==result[1]) break;
                } else {// (A[i]>target) 
                    end=i-1;
                    i=(start+end)/2;
                }
            }

        } 
        return result;        
    }
    
}
