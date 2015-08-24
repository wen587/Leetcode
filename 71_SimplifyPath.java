// Given an absolute path for a file (Unix-style), simplify it.

// For example,
// path = "/home/", => "/home"
// path = "/a/./b/../../c/", => "/c"
// click to show corner cases.

// Corner Cases:
// Did you consider the case where path = "/../"?
// In this case, you should return "/".
// Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
// In this case, you should ignore redundant slashes and return "/home/foo".

public class Solution {
    public String simplifyPath(String path) {
        String[] tokens = path.split("/");
        String[] parsed = new String[tokens.length];
        
        int pos = 0;
        for(String token : tokens) {
            if(token.equals("") || token.equals(".")) 
                continue;
            else if (token.equals("..")) {
                if(pos > 0) pos--;
            } else {
                parsed[pos] = token;
                pos++;
            }
        }
        
        String init = "";
        if(path.startsWith("/")) init = "/";
        StringBuilder sb = new StringBuilder(init);
        boolean first = true;
        for(int i=0; i<pos; i++) {
            if(!first) sb.append("/");
            first = false;
            sb.append(parsed[i]);
        }
        return sb.toString();
        
    }
}