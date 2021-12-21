// Date: Sun, Oct 3, 2021 (Not Finished)
// Date: Tue, Nov 16, 2021
// 232. Implement Queue using Stacks (https://leetcode.com/problems/implement-queue-using-stacks/)

// My own solution
// space complexity O(n)
class MyQueue {
public:
    stack<int> stk1;
    stack<int> stk2;

    MyQueue() {
        
    }
    
    // amortized time complexity: O(1)
    void push(int x) {
        if (!stk2.empty()) {
            while (!stk2.empty()) {
                stk1.push(stk2.top());
                stk2.pop();
            }
        }
        stk1.push(x);
    }
    
    // amortized time complexity: O(1)
    int pop() {
        if (!stk1.empty()) {
            while (!stk1.empty()) {
                stk2.push(stk1.top());
                stk1.pop();
            }
        }
        int top = stk2.top();
        stk2.pop();
        return top;
    }
    
    // amortized time complexity: O(1)
    int peek() {
        if (!stk1.empty()) {
            while (!stk1.empty()) {
                stk2.push(stk1.top());
                stk1.pop();
            }
        }
        return stk2.top();
    }
    
    // time complexity: O(1)
    bool empty() {
        return stk1.empty() && stk2.empty();
    }
};

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue* obj = new MyQueue();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->peek();
 * bool param_4 = obj->empty();
 */

// Leetcode Solution
class MyQueue {
public:
    stack<int> stk1;
    stack<int> stk2;
    int front;

    MyQueue() {
        
    }
    
    // time complexity O(1)
    void push(int x) {
        if (stk1.empty())
            front = x;
        stk1.push(x);
    }
    
    // amortized time complexity: O(1)
    int pop() {
        if (stk2.empty()) {
            while (!stk1.empty()) {
                stk2.push(stk1.top());
                stk1.pop();
            }
        }
        int top = stk2.top();
        stk2.pop();
        return top;
    }
    
    // time complexity: O(1)
    int peek() {
        if (!stk2.empty())
            return stk2.top();
        return front;
    }

    // time complexity: O(1)    
    bool empty() {
        return stk1.empty() && stk2.empty();
    }
};
