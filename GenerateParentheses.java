public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<String> list = new ArrayList<String>();
        if (n==0) return list;
        list.add("(");
        return generate(list,n-1,n);
        
    }
    private ArrayList<String> generate(ArrayList<String> list, int m, int n) {
        ArrayList<String> rlist = new ArrayList<String>();
        if (m==0) {
            for (String s : list) {
                for (int i=0;i<n;i++) {
                    s+=")";
                }
                rlist.add(s);
            }
            return rlist;
        }
        else {
            
            ArrayList<String> llist = new ArrayList<String>();
            for (String s : list) {
                llist.add(s+"(");
            }
            ArrayList<String> newlist = generate(llist,m-1,n);
            
            if (m<n) {
                for (String s : list) {
                    rlist.add(s+")");
                }
                newlist.addAll(generate(rlist,m,n-1));
            }
            return newlist;
        }
    }
}
