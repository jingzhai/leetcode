public class Solution {
    public String multiply(String num1, String num2) {
        if (num1==null || num2==null) return "";
        if (num1.equals("0") || num2.equals("0")) return "0";
        StringBuffer res = null;
        for (int j=num2.length()-1;j>=0;j--) {
            StringBuffer cur = new StringBuffer();
            int n1=Character.getNumericValue(num2.charAt(j));
            int mcarry=0;
            for (int i=num1.length()-1;i>=0;i--) {
                int n2=Character.getNumericValue(num1.charAt(i));
                cur.insert(0,(n1*n2+mcarry)%10);
                mcarry=(n1*n2+mcarry)/10;
            }
            if (mcarry>0) cur.insert(0,mcarry);
            if (res==null) res=cur;
            else {
                int acarry=0;
                for (int m=res.length()-num2.length()+j,n=cur.length()-1;m>=0||n>=0||acarry>0;m--,n--) {
                    int m1=(m>=0)?Character.getNumericValue(res.charAt(m)):0;
                    int m2=(n>=0)?Character.getNumericValue(cur.charAt(n)):0;
                    if (m>=0) res.setCharAt(m,Character.forDigit((m1+m2+acarry)%10, 10));
                    else res.insert(0,(m1+m2+acarry)%10);
                    acarry=(m1+m2+acarry)/10;
                }
            }
        }
        return res.toString();
    }
}
