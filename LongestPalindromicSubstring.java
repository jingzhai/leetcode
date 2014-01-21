public class Solution {
    public String longestPalindrome(String str) {
        char[] chars = str.toCharArray();
        int len = str.length();
        int maxstart=0;
        int max=0;
        for (int i=0;i<len;i++) {
            for (int s=i,e=i;s>=0&&e<len;) {
                if (s>0 && e<len-1 && chars[s-1]==chars[e+1]) {
                    s--;
                    e++;
                } else {
                    int curlen=e-s+1;
                    if (max<curlen) {
                        max=curlen;
                        maxstart=s;
                    }
                    break;
                }
            }
            if (i<len-1 && chars[i]==chars[i+1]) {
                for (int s=i,e=i+1;s>=0&&e<len;) {
                if (s>0 && e<len-1 && chars[s-1]==chars[e+1]) {
                    s--;
                    e++;
                } else {
                    int curlen=e-s+1;
                    if (max<curlen) {
                        max=curlen;
                        maxstart=s;
                    }
                    break;
                }
            }
            }
        }
        return str.substring(maxstart,maxstart+max);
    }
}
