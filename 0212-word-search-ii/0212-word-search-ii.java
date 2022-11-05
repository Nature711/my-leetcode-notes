class Solution {
    
    public class Node {
        char c = 'R';
        boolean isTerminal = false;
        Node[] children = new Node[26];
        Node() {}
        Node(char c) {this.c = c;}
       
        @Override
        public String toString() {
            return "node: " + this.c + " ## is terminal " + this.isTerminal;
        }
        
    }
    boolean[][] visited;
    Set<String> res = new HashSet<>();
    Node trie = new Node();
    char[][] _board;
    
    public List<String> findWords(char[][] board, String[] words) {
        _board = board;
        
        for (String word: words) {
            Node currNode = trie;
            for (int i = 0; i < word.length(); i++) {
                if (currNode.children[word.charAt(i) - 'a'] == null) {
                    currNode.children[word.charAt(i) - 'a'] = new Node(word.charAt(i));
                }
                currNode = currNode.children[word.charAt(i) - 'a'];
            }
            currNode.isTerminal = true;
        }
        
        visited = new boolean[board.length][board[0].length];
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(i, j, new ArrayList<>(), trie);
            }
        }
        
        return new ArrayList<>(res);
        
    }
    
    
    public void dfs(int i, int j, List<Character> currString, Node currNode) {
        
        // System.out.println("i " + i + " j " + j);
        // System.out.println(currString);
        // System.out.println(currNode);
        
        if (i < 0 || i == _board.length || j < 0 || j == _board[0].length 
            || visited[i][j] || currNode.children[_board[i][j] - 'a'] == null) return;
 
        visited[i][j] = true;
        
        Node oldNode = currNode;
        currString.add(_board[i][j]);
        currNode = currNode.children[_board[i][j] - 'a'];
        
        if (currNode.isTerminal) {
            StringBuilder sb = new StringBuilder();
            for (char c: currString) sb.append(c);
            res.add(sb.toString());
        }
        
        if (i < _board.length - 1 && !visited[i + 1][j]) dfs(i + 1, j, currString, currNode);
        if (i > 0 && !visited[i - 1][j]) dfs(i - 1, j, currString, currNode);
        if (j < _board[0].length - 1 && !visited[i][j + 1]) dfs(i, j + 1, currString, currNode);
        if (j > 0 && !visited[i][j - 1]) dfs(i, j - 1, currString, currNode);
        
        currString.remove(currString.size() - 1);
        currNode = oldNode;
        visited[i][j] = false;
    }
}