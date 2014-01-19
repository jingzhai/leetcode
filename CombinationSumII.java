public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] C, int target) {
        Arrays.sort(C);
        return new ArrayList<ArrayList<Integer>>(cs(C,target,0));
    }
    private HashSet<ArrayList<Integer>> cs(int[] C, int target, int loc) {
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        if (loc>=C.length) {
            return set; 
        }
        for (int i=loc;i<C.length&&C[i]<=target;i++) {
            if (C[i]<target) {
                int curValue=C[i];
                for (ArrayList<Integer> pilist : cs(C,target-curValue,i+1)) {
                    pilist.add(0,curValue);
                    set.add(pilist);
                }
            } else {
                ArrayList<Integer> curlist = new ArrayList<Integer>();
                curlist.add(C[i]);
                set.add(curlist);
                break;
            }
        }
        return set;
    }
}
