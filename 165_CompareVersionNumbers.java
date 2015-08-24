// Compare two version numbers version1 and version2.
// If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

// You may assume that the version strings are non-empty and contain only digits and the . character.
// The . character does not represent a decimal point and is used to separate number sequences.
// For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

// Here is an example of version numbers ordering:

// 0.1 < 1.1 < 1.2 < 13.37


//Simple

//1.2 < 1.10  && case 1.2.3.454.1.2.00.00
public class Solution {
    public int compareVersion(String version1, String version2) {
        //split("\\.");
        String[] str1 = version1.split("\\.");
        String[] str2 = version2.split("\\.");
        for(int i = 0; i< Math.max(str1.length, str2.length); i++) {
             int num1 = i >= str1.length ? 0 : Integer.parseInt(str1[i]);
             int num2 = i >= str2.length ? 0 : Integer.parseInt(str2[i]);
             if(num1 != num2) {
                 return num1 > num2 ? 1 : -1;
             }
        }
        return 0;
    }
}
//

public class Solution {
    
     public int compareVersion(String version1, String version2) {
        String[] tokens1 = version1.split("\\.");
        String[] tokens2 = version2.split("\\.");//重点加\\，解决了1和0的比较
         //Otherwise you are splitting on the regex ., which means "any character".
        return compareVersion(tokens1, tokens2, 0);
    }
     //下面避免了1.0 和1的比较
    private int compareVersion(String[] tokens1, String[] tokens2, int pos) {
        if (tokens1.length<=pos && tokens2.length<=pos)
            return 0;
         
        int v1 = 0;
        if (tokens1.length>pos)
            v1 = Integer.parseInt(tokens1[pos]);
         
        int v2 = 0;
        if (tokens2.length>pos)
            v2 = Integer.parseInt(tokens2[pos]);
         
        if (v1>v2)
            return 1;
        else if (v1<v2)
            return -1;
         
        return compareVersion(tokens1, tokens2, pos+1);
    }
}