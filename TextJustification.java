public class Solution {
    public ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> jtext = new ArrayList<String>();
        if (words.length==0) return jtext;
        int remaining=L;
        StringBuffer curline=new StringBuffer();
        for (int i=0;i<words.length;i++) {
            if (words[i].length()<remaining) {
                if (i<words.length-1) {
                    curline.append(words[i]).append(" ");
                    remaining-=words[i].length()+1;
                } else if (i==words.length-1) {
                    curline.append(words[i]);
                    remaining-=words[i].length();
                    for (int j=0;j<remaining;j++) {
                        curline.append(" ");
                    }
                    jtext.add(curline.toString());
                    curline=new StringBuffer();
                    remaining=L;
                }
            } else if (words[i].length()==remaining) {
                curline.append(words[i]);
                jtext.add(curline.toString());
                curline=new StringBuffer();
                remaining=L;
            } else {
                String[] curArray = curline.toString().split(" ");
                if (curArray.length==1) {
                    for (int j=0;j<remaining;j++) {
                        curline.append(" ");
                    }
                    remaining=L;
                    jtext.add(curline.toString());
                    curline = new StringBuffer();
                } else {
                    int spaceBetween=(remaining+1)/(curArray.length-1)+1;
                    StringBuffer spaces = new StringBuffer();
                    for (int j=0;j<spaceBetween;j++) {
                        spaces.append(" ");
                    }
                    int count=(remaining+1)%(curArray.length-1);
                    curline = new StringBuffer();
                    for (int j=0;j<curArray.length-1;j++) {
                        curline.append(curArray[j]).append(spaces);
                        if (count>0) {
                            curline.append(" ");
                            count--;
                        }
                    }
                    curline.append(curArray[curArray.length-1]);
                    jtext.add(curline.toString());
                    curline=new StringBuffer();
                    remaining=L;
                }
                i--;
            }
        }
        return jtext;
    }
}
