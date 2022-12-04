class MyQueue {
    
    Stack<Integer> mainStack;
    Stack<Integer> tempStack;

    public MyQueue() {
        mainStack = new Stack<>();
        tempStack = new Stack<>();
    }
    
    public void push(int x) {
        mainStack.push(x);
    }
    
    public int pop() {
        while (mainStack.size() > 1) tempStack.push(mainStack.pop());
        int front = mainStack.pop();
        while (!tempStack.isEmpty()) mainStack.push(tempStack.pop());
        return front;
    }
    
    public int peek() {
        while (mainStack.size() > 1) tempStack.push(mainStack.pop());
        int front = mainStack.peek();
        while (!tempStack.isEmpty()) mainStack.push(tempStack.pop());
        return front;
    }
    
    public boolean empty() {
        return mainStack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */