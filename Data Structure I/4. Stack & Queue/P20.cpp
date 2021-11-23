// Date: Sun, Oct 3, 2021
// 20. Valid Parentheses (https://leetcode.com/problems/valid-parentheses/)

// time complexity: O(n)
// space complexity: O(n)
bool isValid(string s) {
	stack<char> mystack;
	for (char ch: s) {
		if (ch == '(' || ch == '{' || ch == '[')
			mystack.push(ch);
		else {
			if (mystack.empty())
				return false;
			else {
				char ch_top = mystack.top();
				if (ch == ')' && ch_top != '(' || ch == '}' && ch_top != '{' || ch == ']' && ch_top != '[')
					return false;
				mystack.pop();
			}
		} 
	}
	return mystack.empty();
}

// shorter version
bool isValid(string s) {
	stack<char> mystack;
	for (char& ch: s) {
		switch(ch) {
			case '(': mystack.push(')'); break;
			case '{': mystack.push('}'); break;
			case '[': mystack.push(']'); break;
			default:
				if (mystack.empty() || ch != mystack.top())
					return false;
				mystack.pop();
		}
	}
	return mystack.empty();
}