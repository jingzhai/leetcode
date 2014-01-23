public class Solution {
    public int atoi(String str) {
        if (str==null || str.isEmpty()) return 0;
        boolean negative=false;
        int i=0;
        while (str.charAt(i)==' ') i++;
        if (str.charAt(i)=='-' || str.charAt(i)=='+') {
            negative=(str.charAt(i)=='-');
            i++;
        }
        int result=0;
        char[] chars = str.toCharArray();
        for (;i<chars.length;i++) {
            char c=chars[i];
            if (Character.isDigit(c)) {
                int value = Character.getNumericValue(c);
                if (!negative && (result>Integer.MAX_VALUE/10 || (result==Integer.MAX_VALUE/10 && value>=7))) return Integer.MAX_VALUE;
                if (negative && (0-result<Integer.MIN_VALUE/10 || (0-result==Integer.MIN_VALUE/10 && value>=8))) return Integer.MIN_VALUE;
                result=result*10+value;
            }
            else break;
        }
        return negative?-result:result;
    }
}
