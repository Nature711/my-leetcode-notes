class BrowserHistory {
    Stack<String> backwards;
    Stack<String> forwards;

    public BrowserHistory(String homepage) {
        backwards = new Stack<>();
        forwards = new Stack<>();
        backwards.push(homepage);
    }
    
    public void visit(String url) {
        backwards.push(url); //add url to backwards stack
        while (!forwards.isEmpty()) forwards.pop(); //clear up all forward history
    }
    
    public String back(int steps) {
        while (backwards.size() > 1 && steps > 0) {
            forwards.push(backwards.pop());
            steps--;
        }
        return backwards.peek();
    }
    
    public String forward(int steps) {
        while (!forwards.isEmpty() && steps > 0) {
            backwards.push(forwards.pop());
            steps--;
        }
        return backwards.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */