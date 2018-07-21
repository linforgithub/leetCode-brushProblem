class MyQueue {
public:
    /** Initialize your data structure here. */
    MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
	void push(int x) {
		std::stack<int> tmp_stack;
		while (!_stack.empty()){
			tmp_stack.push(_stack.top());
			_stack.pop();
		}
		_stack.push(x);
		while (!tmp_stack.empty()){
			_stack.push(tmp_stack.top());
			tmp_stack.pop();
		}
	}

	/** Removes the element from in front of queue and returns that element. */
	int pop() {
		int x = _stack.top();
		_stack.pop();
		return x;
	}

	/** Get the front element. */
	int peek() {
		return _stack.top();
	}

	/** Returns whether the queue is empty. */
	bool empty() {
		return _stack.empty();
	}
private:
	std::stack<int> _stack;
};

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * bool param_4 = obj.empty();
 */
