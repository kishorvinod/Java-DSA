public class Main {

    // TrieNode class
    static class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        public TrieNode() {
            children = new TrieNode[26]; // 26 lowercase English letters
            isEndOfWord = false;
        }
    }

    // Trie class
    static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Insert a word into the Trie
        public void insert(String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a'; // Find position in array
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode(); // Create if missing
                }
                node = node.children[index];
            }
            node.isEndOfWord = true; // Mark end of word
        }

        // Search for a complete word
        public boolean search(String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (node.children[index] == null) {
                    return false; // Missing character
                }
                node = node.children[index];
            }
            return node.isEndOfWord;
        }

        // Check if any word starts with the given prefix
        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for (char ch : prefix.toCharArray()) {
                int index = ch - 'a';
                if (node.children[index] == null) {
                    return false; // Missing character
                }
                node = node.children[index];
            }
            return true;
        }
    }

    // Main method
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("bat");
        trie.insert("ball");
        trie.insert("banana");

        System.out.println(trie.search("bat"));    // true
        System.out.println(trie.search("bats"));   // false
        System.out.println(trie.startsWith("ba")); // true
        System.out.println(trie.startsWith("cat")); // false
    }
}
