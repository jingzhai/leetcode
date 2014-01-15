public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return cs(candidates,target,0);
    }
    private ArrayList<ArrayList<Integer>> cs(int[] candidates, int target, int loc) {
        ArrayList<ArrayList<Integer>> llist = new ArrayList<ArrayList<Integer>>();
        if (loc>=candidates.length) {
            return llist; //TODO
        }
        for (int i=loc;i<candidates.length;i++) {
            if (candidates[i]<target) {
                ArrayList<ArrayList<Integer>> prevlist = cs(candidates,target-candidates[i],i);
                for (ArrayList<Integer> pilist : prevlist) {
                    pilist.add(0,candidates[i]);
                    llist.add(pilist);
                }
            } else if (candidates[i]==target) {
                ArrayList<Integer> curlist = new ArrayList<Integer>();
                curlist.add(candidates[i]);
                llist.add(curlist);
            } else {
                break;
            }
        }
        return llist;
    }
}
