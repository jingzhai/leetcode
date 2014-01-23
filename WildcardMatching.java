public class Solution {
    public boolean isMatch(String s, String p) {
        if(p.length()==0) return s.length()==0;
        if(s.equals(p)) return true;
        StringBuffer p1=new StringBuffer();
        boolean dup=false;
        for (int i=0;i<p.length();i++) {
            if (p.charAt(i)=='*') {
                if (!dup) {
                    dup=true;
                    p1.append(p.charAt(i));
                }
            }else {
                dup=false;
                p1.append(p.charAt(i));
            }
        }
        p=p1.toString();
        if (s.length()==0) return (p.equals("*"));
        boolean[][] match = new boolean[s.length()+1][p.length()+1];
        match[0][0]=true;
        for (int i=0;i<s.length();i++) {
            for (int j=0;j<p.length();j++) {
                if (s.charAt(i)==p.charAt(j) || p.charAt(j)=='?') {
                    match[i+1][j+1]=match[i][j];
                } else if (p.charAt(j)=='*') {
                    match[0][j+1]=match[0][j];
                    if (match[i][j]||match[i+1][j]) {
                        for (int k=i;k<s.length();k++) {
                            match[k+1][j+1]=true;
                        }
                    }
                } else {
                    match[i+1][j+1]=false;
                }
            }
        }
        return match[s.length()][p.length()];
    }
}
