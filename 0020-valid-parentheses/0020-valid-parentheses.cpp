class Solution {
private:
    stack<char> brackets;
public:
    bool isValid(string s) {
        for (int i = 0; i < s.size(); i++) {
            if (s[i] == '(' || s[i] == '{' || s[i] == '[') {
                brackets.push(s[i]);
            }
            else {
                if (brackets.empty()) {
                    return false;
                }
                if (s[i] == ')') {
                    if (brackets.top() != '(') {
                        return false;
                    }
                }
                if (s[i] == '}') {
                    if (brackets.top() != '{') {
                        return false;
                    }
                }
                if (s[i] == ']') {
                    if (brackets.top() != '[') {
                        return false;
                    }
                }
                brackets.pop();
            }
        }
        
        if (!brackets.empty()) {
            return false;
        }
        return true;
    }
};