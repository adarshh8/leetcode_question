import java.util.*;

class MyStack {

    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    public void push(int x) {
        if (empty()) {
            q1.add(x);
        } else if (q1.isEmpty()) {
            q2.add(x);
        } else {
            q1.add(x);
        }
    }
    
    public int pop() {
        if (empty()) {
            return -1;
        }

        if (q2.isEmpty()) {
            while (q1.size() > 1) {
                q2.add(q1.remove());
            }
            return q1.remove();
        } else {
            while (q2.size() > 1) {
                q1.add(q2.remove());
            }
            return q2.remove();
        }
    }
    
    public int top() {
        if (empty()) {
            return -1;
        } 
        
        if (q2.isEmpty()) {
            while (q1.size() > 1) {
                q2.add(q1.remove());
            }
            int val = q1.peek();
            q2.add(q1.remove());
            return val;
        } else {
            while (q2.size() > 1) {
                q1.add(q2.remove());
            }
            int val = q2.peek();
            q1.add(q2.remove());
            return val;
        }
    }
    
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}
