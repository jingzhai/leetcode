public class Solution {
    public int lengthOfLastWord(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (s==null) return 0;
        String[] sub = s.split(" ");
        if (sub.length==0) return 0;
        else return sub[sub.length-1].length();
    }
}
