public class Solution {
    public ArrayList<ArrayList<String>> partition(String str) {
        if(str == null || str.length() == 0)
            return new ArrayList<ArrayList<String>>();
        boolean[][] palin = new boolean[str.length()][str.length()];
        for (int i=str.length()-1;i>=0;i--) {
            for (int j=0;j<str.length();j++) {
                boolean isPalin=(str.charAt(i)==str.charAt(j));
                if (i<=j-2) isPalin=isPalin&&palin[i+1][j-1];
                palin[i][j]=isPalin;
            }
        }
        return findPalin(str, palin, 0, str.length()-1);
    }
    private ArrayList<ArrayList<String>> findPalin(String str, boolean[][] palin, int s, int e) {
        ArrayList<ArrayList<String>> llist = new ArrayList<ArrayList<String>>();
        if (s>e) return llist;
        ArrayList<String> slist = new ArrayList<String>();
        if (palin[s][e]) {
            slist.add(str.substring(s,e+1));
            llist.add(slist);
        }
        for (int i=s;i<e;i++) {
            if (palin[s][i]) {
                ArrayList<ArrayList<String>> sublist = findPalin(str, palin, i+1,e);
                for (ArrayList<String> sl : sublist) {
                    sl.add(0,str.substring(s,i+1));
                    llist.add(sl);
                }
            }
        }
        return llist;
    }
}
