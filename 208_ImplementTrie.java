// Implement a trie with insert, search, and startsWith methods.

// Note:
// You may assume that all inputs are consist of lowercase letters a-z.


class TrieNode {
    // Initialize your data structure here.
    boolean isEndOfWord;
    TrieNode[] children;
    public TrieNode() {
        this.isEndOfWord = false;
        this.children = new TrieNode[26];
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode runner = root;
        for(char c : word.toCharArray()) {
            if(runner.children[c - 'a'] == null) {
                runner.children[c - 'a'] = new TrieNode();
            }
            runner = runner.children[c - 'a'];
        }
        runner.isEndOfWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode runner = root;
        for(char c : word.toCharArray()) {
            if(runner.children[c- 'a'] == null) {
                return false;
            } else {
                runner = runner.children[c - 'a'];
            }
        }
        return runner.isEndOfWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode runner = root;
        for(char c : prefix.toCharArray()) {
            if(runner.children[c - 'a'] == null) {
                return false;
            } else {
                runner = runner.children[c - 'a'];
            }
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");