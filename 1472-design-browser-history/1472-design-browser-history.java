class BrowserHistory {
    List<String> history;
    int max, curr;

    public BrowserHistory(String homepage) {
        history = new ArrayList<>();
        history.add(homepage);
        max = 0;
        curr = 0;
    }
    
    public void visit(String url) {
        max = curr + 1; //clear forward history
        if (max < history.size()) history.add(max, url);
        else history.add(url);
        curr = max;
        // System.out.println("add " + url + " " + history);
        // System.out.println("curr " + curr + " max " + max);
    }
    
    public String back(int steps) {
        while (curr > 0 && steps > 0) {
            curr--;
            steps--;
        }
        return history.get(curr);
    }
    
    public String forward(int steps) {
        while (curr < max && steps > 0) {
            curr++;
            steps--;
        }
        return history.get(curr);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */