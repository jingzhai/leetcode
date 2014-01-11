public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (k>n || n==0 || k==0) return null;

        ArrayList<ArrayList<Integer>> newlist = new ArrayList<ArrayList<Integer>>();
        if (k<=1) {
            ArrayList<Integer> ilist = new ArrayList<Integer>();
            ilist.add(n);
            newlist.add(ilist);
        } else {
            ArrayList<ArrayList<Integer>> llist = combine(n-1,k-1);
            for (ArrayList<Integer> ilist : llist) {
                ilist.add(n);
                newlist.add(ilist);
            }
        }
        if (n>k) {
            newlist.addAll(combine(n-1,k));
        }
        return newlist;
    }
}
