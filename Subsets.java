public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int len = S.length;
        int num = (int)Math.pow(2, len);
        ArrayList<ArrayList<Integer>> llist = new ArrayList<ArrayList<Integer>>();
        for (int i=0;i<num;i++) {
            ArrayList<Integer> ilist = new ArrayList<Integer>();
            for (int j=0;j<len;j++) {
                int mask=1<<j;
                if ((i&mask)!=0) {
                    ilist.add(S[j]);
                }
            }
            Collections.sort(ilist);
            llist.add(ilist);
        }
        return llist;
    }
}
