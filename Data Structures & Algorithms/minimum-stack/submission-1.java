class MinStack {

    Stack<Integer> stack;
    Stack<Integer> stack2;
    public MinStack() {
        stack = new Stack<>();
        stack2 = new Stack<>();
    }
    
    // s1: 1,2,0
    public void push(int val) {
        stack.push(val);
        //s2:1,0
        if(stack2.isEmpty() || val <= stack2.peek() ){
            stack2.add(val);
        }
    }
    // s1: 1,2,0
    public void pop() {
        if(stack.isEmpty()) return;
        int top = stack.pop();
        //s2: 1,0
        if(top == stack2.peek()){
            stack2.pop(); //s1: 1,2 s2: 1
        };
    }
    
    public int top() {
        return stack.peek();
    }
    //s2:1,0
    public int getMin() {
        return stack2.peek();
    }
}
