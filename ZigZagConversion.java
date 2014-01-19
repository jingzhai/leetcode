public class Solution {
    public String convert(String s, int nRows) {
        if (nRows<=1) return s;
        ArrayList<ArrayList<Character>> list = new ArrayList<ArrayList<Character>>();
        for (int i=0;i<nRows;i++) {
            ArrayList<Character> clist = new ArrayList<Character>();
            list.add(clist);
        }
        int row=0;
        boolean goDown=true;
        for (char c: s.toCharArray()) {
            list.get(row).add(c);
            if (goDown) {
                if (row<nRows-1) row++;
                else {
                    row--;
                    goDown=false;
                }
            } else {
                if (row>0) row--;
                else {
                    row++;
                    goDown=true;
                }
            }
        }
        String str="";
        for (ArrayList<Character> l : list) {
            for (Character c : l) {
                str+=c;
            }
        }
        return str;
    }
}
