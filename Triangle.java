public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int n=triangle.size();

        if ((triangle.size()==0) ||
            (triangle.get(0).size()==0) ||
            (triangle.size() != triangle.get(triangle.size()-1).size())) {
            return 0;
        }
        ArrayList<Integer> minlist = new ArrayList<Integer>();
        minlist.add(triangle.get(0).get(0));
        for (int i=1;i<n;i++) {
            ArrayList<Integer> ilist = triangle.get(i);
            minlist.add(i,ilist.get(i)+minlist.get(minlist.size()-1));
            
            for (int j=i-1;j>0;j--) {
                int min=Math.min(minlist.get(j-1),minlist.get(j));
                minlist.set(j, ilist.get(j)+min);
            }
            minlist.set(0,minlist.get(0)+ilist.get(0));
        }
        int mintotal=Integer.MAX_VALUE;
        for (Integer m : minlist) {
            if (m<mintotal) {
                mintotal=m;
            }
        }
        return mintotal;
    }
}
