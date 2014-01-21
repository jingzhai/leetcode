public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        if (s.length()>12 || s.length()<4) return new ArrayList<String>();
        return restore(s,4);
    }
    private ArrayList<String> restore(String s, int rem) {
        ArrayList<String> newlist = new ArrayList<String>();
        int len=s.length();
        if (rem==1) {
            if (s.length()>1 && s.charAt(0)=='0') return newlist;
            if (Integer.parseInt(s)<=255) newlist.add(s);
            return newlist;
        }
        int cur=0;
        for (int i=0;i<Math.min(3,len-rem+1);i++) {
            int d = Character.getNumericValue(s.charAt(i));
            if (cur*10+d>255) break;
            cur=cur*10+d;
            ArrayList<String> ilist = restore(s.substring(i+1),rem-1);
            for (String str : ilist) {
                str=cur+"."+str;
                newlist.add(str);
            }
            if (i==0 && d==0) break;
        }
        return newlist;
    }
}
