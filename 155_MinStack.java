/*
 * Design a stack that supports push, pop, top, and retrieving 
 * the minimum element in constant time.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 */

//two stack
class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minS = new Stack<>();
    public void push(int x) {
        stack.push(x);
        if(minS.isEmpty()) minS.push(x);
        else minS.push(Math.min(minS.peek(), x));
        
    }

    public void pop() {
        stack.pop();
        minS.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minS.peek();
    }
}

//one stack O(2n) space
class MinStack {
    Stack<Integer> stack = new Stack<>();
    public void push(int x) {
        int m = Integer.MAX_VALUE, n = 0;
        if(!stack.isEmpty()) {
            m = stack.peek();
        }
        stack.push(x);
        stack.push(Math.min(m, x));
        
    }

    public void pop() {
        stack.pop();
        stack.pop();
    }

    public int top() {
        int temp = stack.pop();
        int res = stack.peek();
        stack.push(temp);
        return res;
        
    }

    public int getMin() {
        return stack.peek();
        
    }
}

//one stack O(n) space
class MinStack {
    Stack<Long> stack = new Stack<>();
    long min;
    public void push(int x) {
        if(stack.isEmpty()) {
            stack.push(0L);
            min = x;
        } else {
            stack.push(x - min);
            min = (x - min) < 0 ? x : min;
        }
    }

    public void pop() {
        long pop = stack.pop();
        if(pop < 0) min = min - pop;
    }

    public int top() {
        long top = stack.peek();
        if(top > 0) {
            return (int)(top + min);
        } else {
            return (int)min;
        }
    }

    public int getMin() {
        return (int)min;
    }
}
