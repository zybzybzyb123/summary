package algorithm.dataStruct.interview;

public class Trie {

    private class TreeNode{
        Boolean isLeaf = false;
        public TreeNode[] nodes = new TreeNode[26];
    }

    TreeNode root = null;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TreeNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TreeNode head = root;
        for(char ch : word.toCharArray()){
            int pos = ch - 'a';
            if(head.nodes[pos] == null){
                head.nodes[pos] = new TreeNode();
            }
            head = head.nodes[pos];
        }
        head.isLeaf = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TreeNode head = root;
        for(char ch : word.toCharArray()){
            int pos = ch - 'a';
            if(head.nodes[pos] == null){
                return false;
            }
            head = head.nodes[pos];
        }
        return head.isLeaf;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TreeNode head = root;
        for(char ch : prefix.toCharArray()){
            int pos = ch - 'a';
            if(head.nodes[pos] == null){
                return false;
            }
            head = head.nodes[pos];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */