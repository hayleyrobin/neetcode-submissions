class MinStack {

    Stack<Integer> stack;
    Stack<Integer> stack2;
    public MinStack() {
        stack = new Stack<>();
        stack2 = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(stack2.isEmpty() || val <= stack2.peek() ){
            stack2.add(val);
        }
    }
    
    public void pop() {
        if(stack.isEmpty()) return;
        int top = stack.pop();
        if(top == stack2.peek()){
            stack2.pop();
        };
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return stack2.peek();
    }
}
