// Given a string containing only digits, restore it by returning all p
// ossible valid IP address combinations.
// For example:
// Given "25525511135",
// return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
//

//not good
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        int len = s.length();
        for(int i = 1; i<4 && i<len-2; i++){
            for(int j = i+1; j<i+4 && j<len-1; j++){
                for(int k = j+1; k<j+4 && k<len; k++){
                    String s1 = s.substring(0,i), s2 = s.substring(i,j), s3 = s.substring(j,k), s4 = s.substring(k,len);
                    if(isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)){
                        res.add(s1+"."+s2+"."+s3+"."+s4);
                    }
                }
            }
        }
        return res;
    }
    public boolean isValid(String s){
        if(s.length()>3 || s.length()==0 || (s.charAt(0)=='0' && s.length()>1) || Integer.parseInt(s)>255)
            return false;
        return true;
    }
}


//later check
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        return restore(new int[0], s);
    }
     
    private List<String> restore(int[] tokens, String rest) {
        List<String> total = new ArrayList<>();
        if (tokens.length==4) {
            if ("".equals(rest)) {
                String ip = "";
                for (int i=0; i<4; i++) {
                    if (!"".equals(ip))
                        ip += '.';
                    ip += String.valueOf(tokens[i]);
                }
                total.add(ip);
            }
             
            return total;
        }
         
        for (int i=1; i<=3 && i<=rest.length(); i++) {
            String subStr = rest.substring(0, i);
            int sub = Integer.parseInt(subStr);
            if ((subStr.startsWith("0") && i>1) || sub>255)
                break;
             
            int[] ts = new int[tokens.length+1];
            System.arraycopy(tokens, 0, ts, 0, tokens.length);
            ts[tokens.length] = sub;
             
            total.addAll(restore(ts, rest.substring(i)));
        }
         
        return total;
    }
}