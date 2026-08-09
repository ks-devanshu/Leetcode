import java.util.Queue;
import java.util.ArrayDeque;

class MyStack {
    private Queue<Integer> stack;

    public MyStack() {
        stack = new ArrayDeque<>();
    }

    public void push(int x) {
        stack.add(x);
    }

    public int pop() {
        int repeat = 0;
        while (repeat++ < stack.size() - 1) stack.add(stack.remove());
        return stack.remove();
    }

    public int top() {
        int repeat = 0;
        while (repeat++ < stack.size() - 1) stack.add(stack.remove());
        int res = stack.peek();
        stack.add(stack.remove());
        return res;
    }

    public boolean empty() {
        return stack.isEmpty();
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