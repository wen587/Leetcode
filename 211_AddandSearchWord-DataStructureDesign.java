// Design a data structure that supports the following two operations:

// void addWord(word)
// bool search(word)
// search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

// For example:

// addWord("bad")
// addWord("dad")
// addWord("mad")
// search("pad") -> false
// search("bad") -> true
// search(".ad") -> true
// search("b..") -> true
// Note:
// You may assume that all words are consist of lowercase letters a-z.


class TrieNode {
    boolean isEnd;
    TrieNode[] children;
    public TrieNode() {
        this.isEnd = false;
        this.children = new TrieNode[26];
    }
}
public class WordDictionary {
    private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode runner = root;
        for(char c : word.toCharArray()) {
            if(runner.children[c - 'a'] == null) {
                runner.children[c - 'a'] = new TrieNode();
            }
            runner = runner.children[c - 'a'];
        }
        runner.isEnd = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        TrieNode runner = root;
        return searchWord(word, runner, 0);
    }
    public boolean searchWord(String word, TrieNode runner, int i) {
        if(i == word.length()) return runner.isEnd;
        char c = word.charAt(i);
        if(c == '.') {
            for(int j=0; j<26; j++) {
                if(runner.children[j] != null && searchWord(word, runner.children[j], i + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            return runner.children[c - 'a'] != null && searchWord(word, runner.children[c - 'a'], i + 1);
        }
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");