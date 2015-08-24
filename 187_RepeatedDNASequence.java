// All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

// Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

// For example,

// Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

// Return:
// ["AAAAACCCCC", "CCCCCAAAAA"].



public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        HashSet<String> strSet = new HashSet<String>();
        HashSet<Integer> numSet = new HashSet<Integer>();
        for(int i=0; i<s.length() - 9; i++) {
            String subStr = s.substring(i, i + 10);
            int curNum = encode(subStr);
            if(!numSet.contains(curNum)) {
                numSet.add(curNum);
            } else {
                strSet.add(subStr);
            }
        }
        for(String str : strSet) {
            res.add(str);
        }
        return res;
    }
    public int encode(String s) {
        int sum = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == 'A') {
                sum = sum * 4;
            } else if (s.charAt(i) == 'C') {
                sum = sum * 4 + 1;
            } else if (s.charAt(i) == 'G') {
                sum = sum * 4 + 2;
            } else if(s.charAt(i) == 'T') {
                sum = sum * 4 + 3;
            }
        }
        return sum;
    }
}