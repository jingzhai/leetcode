public class Solution {
    public String longestCommonPrefix(String[] strs) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (strs.length==0) return "";
        if (strs[0].length()==0) return "";
        int rightmost=0;
        while (rightmost<strs[0].length()) {
            for (int i=1;i<strs.length;i++) {
                if (strs[i].length()<=rightmost || strs[i].charAt(rightmost)!=strs[0].charAt(rightmost)) {
                    if (rightmost>0) {
                        return strs[0].substring(0,rightmost);
                    } 
                    return "";
                }
            }
            rightmost++;
        }
        return strs[0].substring(0,rightmost);
    }
    
}
