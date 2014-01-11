public class Solution {
    public int numTrees(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        return numTree(1,n);
    }
    public int numTree(int s, int e) {

        if (s>=e) return 1;
        int num=0;
        for (int i=s;i<=e;i++) {
            num+=numTree(s,i-1)*numTree(i+1,e);
        }
        return num;
    }
}
