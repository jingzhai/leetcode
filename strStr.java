public class Solution {
    public String strStr(String s1, String s2) {
        if (s1.length()<s2.length()) return null;
        if (s2.length()==0) return s1;
        int i = 0;
        while (i<s1.length()-s2.length()+1) {
            if (s1.charAt(i)==s2.charAt(0)) {
                boolean match=true;
                for (int j=1;j<s2.length();j++) {
                    if (s1.charAt(i+j)!=s2.charAt(j)) {
                        match=false;
                        break;
                    }
                }
                if (match) return s1.substring(i);
            }
            i++;
        }
        return null;
    }
}
