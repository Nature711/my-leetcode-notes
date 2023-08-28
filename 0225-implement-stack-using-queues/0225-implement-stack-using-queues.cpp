class MyStack {
public:
    queue<int> q_main;
    queue<int> q_tmp;
    
    MyStack() {
        
    }
    
    void push(int x) {
        q_main.push(x);
    }
    
    int pop() {
        while (q_main.size() > 1) {
            q_tmp.push(q_main.front());
            q_main.pop();
        }
        int res = q_main.front();
        q_main.pop();
        while (q_tmp.size() > 0) {
            q_main.push(q_tmp.front());
            q_tmp.pop();
        }
        return res;
    }
    
    int top() {
        int top = this->pop();
        this->push(top);
        return top;
    }
    
    bool empty() {
        return q_main.empty();
    }
};

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack* obj = new MyStack();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->top();
 * bool param_4 = obj->empty();
 */