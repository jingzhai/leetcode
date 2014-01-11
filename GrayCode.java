public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (n<0) return list;
        if (n==0) {
            list.add(0);
            return list;
        }
        ArrayList<Integer> prevlist = grayCode(n-1);
        ArrayList<Integer> sublist = new ArrayList<Integer>();
        int highestBit=1<<(n-1);
        for (int i=prevlist.size()-1;i>=0;i--) {
            sublist.add(prevlist.get(i)+highestBit);
        }
        prevlist.addAll(sublist);
        return prevlist;
    }
}

public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (n<0) return list;
        if (n>=0) {
            list.add(0);
        }

        for(int bit=0; bit<n; bit++) {
            int cursize = list.size();
            int highestBit=1<<bit;
            for (int i=cursize-1;i>=0;i--) {
                list.add(list.get(i)+highestBit);
            }
        }
        return list;
    }
}
