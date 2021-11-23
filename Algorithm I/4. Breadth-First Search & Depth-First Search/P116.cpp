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

// Date: Nov 20, 2021
// Breadth-first search
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
public:
    Node* connect(Node* root) {
    	// the first node in the level is checking
        Node* first_node = root;
        // the node iterates through all nodes in the current level
        // in order to populate the 'next' pointers for its children (left and right)
        Node* current;
        while (first_node && first_node->left) {
        	current = first_node;
        	while(current) {
        		current->left->next = current->right;
        		// all the nodes in the same level as the parent (current) are populated
        		current->right->next = current->next ? current->next->left : nullptr;
        		current = current->next;
        	}
        	first_node = first_node->left;
        }
        return root;
    }
};
