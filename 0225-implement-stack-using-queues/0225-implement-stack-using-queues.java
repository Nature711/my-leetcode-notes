class MyStack {
    
    Queue<Integer> mainQueue;
    Queue<Integer> tempQueue;

    public MyStack() {
        mainQueue = new LinkedList<>();
        tempQueue = new LinkedList<>();
    }
    
    public void push(int x) {
        mainQueue.add(x);
    }
    
    public int pop() {
        while (mainQueue.size() > 1) tempQueue.add(mainQueue.poll());
        int top = mainQueue.poll();
        while (!tempQueue.isEmpty()) mainQueue.add(tempQueue.poll());
        return top;
    }
    
    public int top() {
       
        while (mainQueue.size() > 1) tempQueue.add(mainQueue.poll());
        int top = mainQueue.poll();
        tempQueue.add(top);
        
        while (!tempQueue.isEmpty()) mainQueue.add(tempQueue.poll());
        
        return top;
    }
    
    public boolean empty() {
        return mainQueue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */