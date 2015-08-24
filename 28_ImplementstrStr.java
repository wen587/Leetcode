// Implement strStr().

// Returns the index of the first occurrence of needle in haystack, or -1 
// if needle is not part of haystack.

// Update (2014-11-02):
// The signature of the function had been updated to return the index 
// instead of the pointer. If you still see your function signature 
// returns a char * or String, please click the reload button  to reset 
// your code definition.


//注意 string中 == 是指对象， equals是指数值
// String str1 = "abc";
// String str2 = "abc";
// String str3 = new String("abc");
// System.out.println(str1 == str2);   //true
// System.out.println(str1 == str3);   //false
// System.out.println(str1.equals(str3));  //true
public class Solution {
    public int strStr(String haystack, String needle) {
        for(int i=0; i<=haystack.length() - needle.length(); i++) {
            System.out.println(haystack.substring(i, i + needle.length()));
            if(haystack.substring(i, i + needle.length()).equals(needle))
            return i;
        }
        return -1;
    }
}

//two pointer
public class Solution {
    public int strStr(String haystack, String needle) {
        if( needle == "") return 0;
        for(int i=0; i<=haystack.length() - needle.length(); i++) {
            int k = i;
        	for(int j=0; j<needle.length(); j++) {
        	    if(haystack.charAt(k) == needle.charAt(j)) {
        	        k++;
        	    } else break;
        	    if(k - i == needle.length()) return i;
        	}
        }
        return -1;
    }
}