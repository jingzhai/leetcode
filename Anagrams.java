public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        ArrayList<String> anagrams = new ArrayList<String>();
        ArrayList<String> alist = new ArrayList<String>();
        for (String s: strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key=String.valueOf(chars);
            ArrayList<String> list = null;
            if (!map.containsKey(key)) {
                list=new ArrayList<String>();
            } else {
                if (map.get(key).size()==1) anagrams.add(key);
                list=map.get(key);
            }
            list.add(s);
            map.put(key,list);
        }
        for (String a : anagrams) {
            alist.addAll(map.get(a));
        }
        return alist;
    }
}
