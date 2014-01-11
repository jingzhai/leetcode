public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if (numRows<=0) return list;
        for (int i=0;i<numRows;i++) {
            ArrayList<Integer> sublist = new ArrayList<Integer>();
            sublist.add(1);
            ArrayList<Integer> prevlist = null;
            if (i>0) prevlist = list.get(i-1);
            if (prevlist!=null) {
                for (int j=1;j<i;j++){
                    int value = prevlist.get(j-1)+prevlist.get(j);
                    sublist.add(value);
                }
            }
            if (i>=1) sublist.add(1);
            list.add(sublist);
        }
        return list;
    }
}
