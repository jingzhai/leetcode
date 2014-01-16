public class Solution {
    String[] dict = new String[]{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> list = new ArrayList<String>();
        if (digits.length()==0) {
            list.add("");
        } else {
            for (char ch : dict[digits.charAt(0)-'2'].toCharArray()) {
                for (String s : letterCombinations(digits.substring(1))) {
                    list.add(ch+s);
                }
            }
        }
        return list;
    }
}
