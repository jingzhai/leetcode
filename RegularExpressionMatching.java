public class Solution {
    public boolean isMatch(String s, String p) {
        if (s.length()>0 && p.length()==0) return false;
        if (s.length()==0 && p.length()==0) return true;
        if (p.length()>=2 && p.charAt(1)=='*')  { //p.j+1=='*', (1) isMatch(s.i, p.j+2) (2) s.k==p.j & isMatch(s.k,p.j+2)
            if (p.length()==2) return true;
            for (int k=0;k<s.length();k++) {
                if (k==0 || s.charAt(k)==p.charAt(0)) {
                    if (isMatch(s.substring(k),p.substring(2))) return true;
                } else return false;
            }
        } else if (p.length()>=1 && s.length()>=1 && (p.charAt(0)==s.charAt(0) || p.charAt(0)=='.')) {//p.j+1!=*
            if (p.length()==1 && s.length()==1) return true;
            if (p.length()==1 && s.length()>1) return false; //p.length should be >1
            if (s.length()==1) {
                boolean star=false;
                for (int i=0;i<p.length();i++) {
                    if (star==(p.charAt(i)=='*')) {
                        star=!star;
                    } else return false;
                }
                return star;
            }
            return isMatch(s.substring(1),p.substring(1));
        }
        return false;
    }
}
