public class Solution {
    public boolean isPalindrome(String s) {
        String str = s.toLowerCase();
        if (str.isEmpty()) return true;
        for (int i=0,j=str.length()-1;i<j;) {
            if (!Character.isLetterOrDigit(str.charAt(i))) i++;
            else if (!Character.isLetterOrDigit(str.charAt(j))) j--;
            else {
                if (str.charAt(i)!=str.charAt(j)) {
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }
}
