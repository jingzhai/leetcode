public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        int slen=S.length();
        ArrayList<Integer> ilist = new ArrayList<Integer>();
        if (L.length==0) return ilist;
        int lslen=L[0].length();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for (String s : L) {
            if (!map.containsKey(s)) {
                map.put(s,1);
            } else {
                map.put(s, map.get(s)+1);
            }
        }
        for (int i=0;i<lslen;i++) {
            int count=0;
            HashMap<String, Integer> found = new HashMap<String, Integer>();
            for (int b=0,e=0;b<=e&&e<=slen/lslen;e++) {
                if (i+(e+1)*lslen>slen) break;
                String cur = S.substring(i+e*lslen,i+(e+1)*lslen);
                if (map.containsKey(cur)) {
                    found.put(cur,found.containsKey(cur)?found.get(cur)+1:1);
                    if (found.get(cur)<=map.get(cur)) {
                        count++;
                        if (count==L.length) {
                            ilist.add(b*lslen+i);
                        }
                    } else {
                        while (found.get(cur)>map.get(cur)) {
                            String temp = S.substring(i+b*lslen,i+(b+1)*lslen);
                            found.put(temp,found.get(temp)-1);
                            if (!temp.equals(cur)) count--;
                            b++;
                        }
                        if (count==L.length) {
                            ilist.add(b*lslen+i);
                        }
                    }
                } else {
                    found.clear();
                    count=0;
                    b=e+1;
                }
            }
        }
        return ilist;
    }
}
