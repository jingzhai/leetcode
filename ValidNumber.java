public class Solution {
    public boolean isNumber(String s) {
        boolean isNum=true;
        s=s.trim();
        try {
            Double.parseDouble(s);
        } catch (NumberFormatException e) {
            return false;
        }
        char[] chars = s.toCharArray();
        for (int i=0;i<s.length();i++) {
            char c = chars[i];
            if (((int)c>=(int)'A' && (int)c<=(int)'Z') || ((int)c>=(int)'a' && (int)c<=(int)'z')) {
                if (c=='e') continue;
                else return false;
            }
        }
        return true;
    }
}
