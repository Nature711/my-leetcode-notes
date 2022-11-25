class Trie {
    
    Node root;

    public Trie() {
        this.root = new Node();
    }
    
    public void insert(String word) {
        Node currNode = root;
        for (int i = 0; i < word.length(); i++) {
            if (currNode.children[word.charAt(i) - 'a'] == null) {
                currNode.children[word.charAt(i) - 'a'] = new Node(word.charAt(i));
            } 
            currNode = currNode.children[word.charAt(i) - 'a'];
            if (i == word.length() - 1) currNode.isTerminating = true;
        }
    }
    
    public boolean search(String word) {
        Node currNode = root;
        for (int i = 0; i < word.length(); i++) {
            if (currNode.children[word.charAt(i) - 'a'] == null) return false;
            currNode = currNode.children[word.charAt(i) - 'a'];
            if (i == word.length() - 1 && !currNode.isTerminating) return false;
        }
        return true;
    }
    
    public boolean startsWith(String prefix) {
        Node currNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (currNode.children[prefix.charAt(i) - 'a'] == null) return false;
            currNode = currNode.children[prefix.charAt(i) - 'a'];
        }
        return true;
    }
}

class Node {
    
    char c;
    Node[] children = new Node[27];
    boolean isTerminating = false;
    
    public Node() {this.c = 'R';}
    
    public Node(char c) {this.c = c;}
    
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */