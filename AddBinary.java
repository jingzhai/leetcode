public class Solution {
    public String addBinary(String a, String b) {
        if (a=="" || b=="") return a+b;
        int len=Math.max(a.length(),b.length());
        int carry=0;
        String ab="";
        
        for (int i=0;i<len;i++) {
            int ai=((i<a.length())?a.charAt(a.length()-i-1):'0')-'0';
            int bi=((i<b.length())?b.charAt(b.length()-i-1):'0')-'0';
            ab=(ai+bi+carry)%2+ab;
            carry=(ai+bi+carry)/2;
        }
        if (carry==1) {
            ab=carry+ab;
        }
        return ab;
    }
}
