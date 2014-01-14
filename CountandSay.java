public class Solution {
    public String countAndSay(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (n==0) return "";
        StringBuffer last = new StringBuffer("1");
        for (int i=1;i<n;i++) {
            StringBuffer seq = new StringBuffer();
            int lastchar = 0;
            for (int j=1;j<=last.length();j++) {
                if (j==last.length() || last.charAt(lastchar)!=last.charAt(j)) {
                    seq.append(j-lastchar);
                    seq.append(last.charAt(lastchar));
                    lastchar = j;
                }
            }
            last = seq;
        }
        return last.toString();
    }
}
