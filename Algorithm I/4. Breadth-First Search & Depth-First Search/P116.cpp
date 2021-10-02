// Date: Wed, Sep 29, 2021
// 116. Populating Next Right Pointers in Each Node

/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* left;
    Node* right;
    Node* next;

    Node() : val(0), left(NULL), right(NULL), next(NULL) {}

    Node(int _val) : val(_val), left(NULL), right(NULL), next(NULL) {}

    Node(int _val, Node* _left, Node* _right, Node* _next)
        : val(_val), left(_left), right(_right), next(_next) {}
};
*/

class Solution {
public:
	// breadth first search technique
	// time complexity O(n)
	// space complexity O(n) 
    Node *connect(Node *root) {
	    if (root == nullptr)
	    	return nullptr;
	    queue<Node *> myqueue;
	    myqueue.push(root);
	    myqueue.push(nullptr);
	    while (!myqueue.empty()) {
	        Node *current = myqueue.front();
	        myqueue.pop();
	        if (!current) {
	            if (!myqueue.empty())
	                myqueue.push(nullptr);
	        } else {
	            current->next = myqueue.front();
	            if (current->left && current->right) {
	                myqueue.push(current->left);
	                myqueue.push(current->right);
	            }
	        }
	    }
	    return root;
	}
};
