public class Solution {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        if (s==null || s.isEmpty()) return null;
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        return wbreak(s, dict, map);
    }
    private ArrayList<String> wbreak(String s, Set<String> dict, HashMap<String, ArrayList<String>> map) {
        ArrayList<String> list = new ArrayList<String>();
        for (int i=1;i<=s.length();i++) {
            String cur = s.substring(0,i);
            if (dict.contains(cur)) {
                if (i<s.length()) {
                    String remaining=s.substring(i);
                    ArrayList<String> remlist=null;
                    if (map.containsKey(remaining)) {
                        remlist=map.get(remaining);
                    } else {
                        remlist = wbreak(s.substring(i),dict,map);
                    }
                    if (!remlist.isEmpty()) {
                        for (int j=0;j<remlist.size();j++) {
                            String sl=remlist.get(j);
                            list.add(cur+" "+sl);
                        }
                    }
                } else {
                    list.add(cur);
                }
            }
        }
        map.put(s,list);
        return list;
    }
}
