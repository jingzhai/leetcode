public class Solution {
    public String intToRoman(int num) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        StringBuffer roman = new StringBuffer();
        int remaining=num;
        while (remaining>=1000) {
            roman.append("M");
            remaining-=1000;
        }
        if (remaining>=900) {
            roman.append("CM");
            remaining-=900;
        }
        if (remaining>=500) {
            roman.append("D");
            remaining-=500;
        }
        if (remaining>=400) {
            roman.append("CD");
            remaining-=400;
        }
        while (remaining>=100) {
            roman.append("C");
            remaining-=100;
        }
        if (remaining>=90) {
            roman.append("XC");
            remaining-=90;
        }
        if (remaining>=50) {
            roman.append("L");
            remaining-=50;
        }
        if (remaining>=40) {
            roman.append("XL");
            remaining-=40;
        }
        while (remaining>=10) {
            roman.append("X");
            remaining-=10;
        }
        if (remaining>=9) {
            roman.append("IX");
            remaining-=9;
        }
        if (remaining>=5) {
            roman.append("V");
            remaining-=5;
        }
        if (remaining>=4) {
            roman.append("IV");
            remaining-=4;
        }
        while (remaining>=1) {
            roman.append("I");
            remaining-=1;
        }
        return roman.toString();
    }
}
