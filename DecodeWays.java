public class Solution {
    public int numDecodings(String s) {
        if (s.length()==0) return 0;
        if (s.charAt(0)=='0') return 0;
        char[] chars = s.toCharArray();
        int[] nd = new int[s.length()+1];
        nd[s.length()]=1;
        nd[s.length()-1]=chars[s.length()-1]=='0'?0:1;
        for (int i=s.length()-2;i>=0;i--) {
            if (chars[i]=='0') nd[i]=0;
            else if ((chars[i]-'0')*10+(chars[i+1]-'0')<=26) nd[i]=nd[i+1]+nd[i+2];
            else nd[i]=nd[i+1];
        }
        return nd[0];
    }
}
