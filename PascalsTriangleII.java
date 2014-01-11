public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<Integer> list = new ArrayList<Integer>();

        if (rowIndex>=0) {
            list.add(1);
        };
        if (rowIndex>=1) {
            list.add(1);
        }
        
        for (int i=2;i<=rowIndex;i++) {
            list.add(1, i);
            for (int j=2;j<i;j++) {
                list.set(j, list.get(j)+list.get(j+1));
            }
        }
        return list;
    }
}
