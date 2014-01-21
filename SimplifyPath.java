public class Solution {
    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        ArrayDeque<String> stack= new ArrayDeque<String>();
        for (String p : paths) {
            if (p.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            }
            else if (!p.equals(".") && !p.equals("")) stack.push(p);
        }
        String newpath = "";
        while (!stack.isEmpty()) {
            newpath="/"+stack.pop()+newpath;
        }
        if (newpath.isEmpty()) newpath="/";
        return newpath;
    }
}
