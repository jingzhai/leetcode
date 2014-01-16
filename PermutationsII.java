public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        Arrays.sort(num);
        int[] dupBefore = new int[num.length];
        int count=0;
        dupBefore[0]=0;
        for (int i=1;i<num.length;i++) {
            if (num[i]==num[i-1]) {
                count++;
            }
            else {
                count=0;
            }
            dupBefore[i]=count;
        }
        return perm(num, num.length, dupBefore);
    }
    
    private ArrayList<ArrayList<Integer>> perm(int[] num, int m, int[] dupBefore) {
        ArrayList<ArrayList<Integer>> llist = new ArrayList<ArrayList<Integer>>();
        int n=num[m-1];
        if (m==1) {
            ArrayList<Integer> ilist = new ArrayList<Integer>();
            ilist.add(n);
            llist.add(ilist);
        }
        else if (m>1) {
            ArrayList<ArrayList<Integer>> prevlist = perm(num, m-1, dupBefore);
            for (ArrayList<Integer> pilist : prevlist) {
                int count=0;
                int i=0;
                while (count<dupBefore[m-1]&&i<pilist.size()) {
                    if (pilist.get(i)==n) {
                        count++;
                    }
                    i++;
                }
                for (;i<m;i++) {
                    ArrayList<Integer> ilist = new ArrayList<Integer>();
                    ilist.addAll(pilist);
                    ilist.add(i,n);
                    llist.add(ilist);
                }
            }
        }
        return llist;
    }
}



public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
    if(num == null) return null;
    Arrays.sort(num);
    return perm(num, 0, new boolean[num.length]);
}
public ArrayList<ArrayList<Integer>> perm(int[] num, int l, boolean[] used){
    ArrayList<ArrayList<Integer>> rl = new ArrayList<ArrayList<Integer>>();
    if(l == num.length) rl.add(new ArrayList<Integer>());
    else for(int i = 0; i < num.length; i++){
            if(used[i] || i != 0 && num[i] == num[i - 1] && !used[i - 1]) continue;
            used[i] = true;
            for(ArrayList<Integer> x : perm(num, l + 1, used)){
                x.add(0, num[i]);
                rl.add(x);
            }
            used[i] = false;
        }
    return rl;
}
