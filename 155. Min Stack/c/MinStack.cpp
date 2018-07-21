class MinStack {
public:
    /** initialize your data structure here. */
	MinStack() {

	}

	void push(int x) {
		_stack.push(x);
		std::stack<int> tmp_stack;
		while (!minStack.empty())
		{
			if (minStack.top() < x){
				tmp_stack.push(minStack.top());
				minStack.pop();
			}
			else{
				break;
			}
		}
		minStack.push(x);
		while (!tmp_stack.empty())
		{
			minStack.push(tmp_stack.top());
			tmp_stack.pop();
		}
	}

	void pop() {
		if (minStack.top() == _stack.top()){
			minStack.pop();
		}
		_stack.pop();
	}

	int top() {
		return _stack.top();
	}

	int getMin() {
		return minStack.top();
	}
private:
	std::stack<int> minStack;
	std::stack<int> _stack;
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
