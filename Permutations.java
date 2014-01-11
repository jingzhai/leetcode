public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        return perm(num, num.length);
    }
    
    private ArrayList<ArrayList<Integer>> perm(int[] num, int m) {
        ArrayList<ArrayList<Integer>> llist = new ArrayList<ArrayList<Integer>>();
        if (m==1) {
            ArrayList<Integer> ilist = new ArrayList<Integer>();
            ilist.add(num[m-1]);
            llist.add(ilist);
        }
        else if (m>1) {
            ArrayList<ArrayList<Integer>> prevlist = perm(num, m-1);
            for (ArrayList<Integer> pilist : prevlist) {
                for (int i=0;i<m;i++) {
                    ArrayList<Integer> ilist = new ArrayList<Integer>();
                    ilist.addAll(pilist);
                    ilist.add(i,num[m-1]);
                    llist.add(ilist);
                }
            }
        }
        return llist;
    }

}
