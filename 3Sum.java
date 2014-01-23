public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        if (num.length<3) return list; 
        for (int i=0;i<num.length-2&&num[i]<=0;i=next(num,i)) {
            for (int j=i+1,k=num.length-1;k>j;) {
                int sum = num[i]+num[j]+num[k];
                if (sum==0) {
                    ArrayList<Integer> ilist = new ArrayList<Integer>();
                    ilist.add(num[i]);
                    ilist.add(num[j]);
                    ilist.add(num[k]);
                    list.add(ilist);
                    j=next(num,j);
                    k=prev(num,k);
                }
                else if (sum<0) j=next(num,j);
                else k=prev(num,k);
            }
        }
        return list;
    }
    private int next(int[] num, int index) {
        do {
            index++;
        } while (index<num.length&&index>0&&num[index]==num[index-1]);
        return index;
    }
    private int prev(int[] num, int index) {
        do {
            index--;
        } while (index>=0&&index<num.length-1&&num[index]==num[index+1]);
        return index;
    }
}
