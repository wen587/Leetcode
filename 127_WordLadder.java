// Given two words (beginWord and endWord), and a dictionary, find the length of shortest transformation sequence from beginWord to endWord, such that:

// Only one letter can be changed at a time
// Each intermediate word must exist in the dictionary
// For example,

// Given:
// start = "hit"
// end = "cog"
// dict = ["hot","dot","dog","lot","log"]
// As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
// return its length 5.

// Note:
// Return 0 if there is no such transformation sequence.
// All words have the same length.
// All words contain only lowercase alphabetic characters.

//
public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        if (dict == null || dict.size() == 0) {
            return 0;
        }

        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        dict.remove(start);
        int length = 1;

        while(!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i<count; i++){
                String current = queue.poll();
                for (char c = 'a'; c <= 'z'; c++) {
                    for (int j=0; j < current.length(); j++) {
                        if (c == current.charAt(j)) {
                            continue;
                        }
                        String tmp = replace(current, j, c);
                        if (tmp.equals(end)) {
                            return length + 1;
                        }
                        if (dict.contains(tmp)){
                            queue.offer(tmp);
                            dict.remove(tmp);
                        }
                    }
                }
            }
            length++;
        }
        return 0;
    }

    private String replace(String s, int index, char c) {
        char[] chars = s.toCharArray();
        chars[index] = c;
        return new String(chars);
    }
}


//public class Solution {
    public int ladderLength(String begin, String end, Set<String> dict) {
        LinkedList<String> queue = new LinkedList<>();
        queue.add(begin);
        dict.add(end);
        int res = 0;
        while(!queue.isEmpty()) {
            LinkedList<String> level = new LinkedList<>();
            res++;
            while(!queue.isEmpty()) {
                String cur = queue.poll();
                if(cur.equals(end)) return res;
                char[] ch = cur.toCharArray();
                for(int i=0; i<ch.length; i++) {
                    for(char c = 'a'; c <= 'z'; c++) {
                        char temp = ch[i];
                        ch[i] = c;
                        String newStr = new String(ch);
                        ch[i] = temp;
                        if(dict.contains(newStr)) {
                            level.add(newStr);
                            dict.remove(newStr);
                        }
                    }
                }
            }
            queue = level;
        }
        return 0;
    }
}