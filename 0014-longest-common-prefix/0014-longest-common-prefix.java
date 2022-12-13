class Solution {
    public String longestCommonPrefix(String[] strs) {
        Trie trie = new Trie();
        for (String str: strs) {
            if (str.length() == 0) return "";
            trie.insert(str);
        }
        return trie.findLCP();
    }
    
    
    
    
    
    class Node {
        char c;
        Node[] children = new Node[27];
        boolean isTerminating = false;

        public Node() {this.c = 'R';}
        public Node(char c) {this.c = c;}
    }
    
    class Trie {
        Node root;

        public Trie() { this.root = new Node(); }

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
        
        public String findLCP() {
            StringBuilder sb = new StringBuilder();
            Node currNode = root;
            while (currNode != null) {
                int count = 0;
                int next = -1;
                char c = 'R';
                int flag = 0;
                for (int i = 0; i < 26; i++) {
                    if (currNode.children[i] != null) {
                        next = i;
                        c = (char) (i + 97);
                        count++;
                        if (currNode.children[i].isTerminating) flag = 1;
                    }
                    if (count > 1) return sb.toString();
                }
                 
                if (count == 0) return sb.toString();
                else sb.append(c);
                if (flag == 1) break;
                currNode = currNode.children[next];
            }
            return sb.toString();
        }
    }
    
    
}