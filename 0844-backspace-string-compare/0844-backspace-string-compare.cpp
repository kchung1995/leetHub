class Solution {
public:
    bool backspaceCompare(string s, string t) {
        stack<char> sst;
        collectCharacters(sst, s);

        stack<char> tst;
        collectCharacters(tst, t);

        if (sst.size() != tst.size()) return false;
        while (!sst.empty()) {
            if (sst.top() != tst.top()) return false;
            sst.pop();
            tst.pop();
        }
        
        return true;
    }

    void collectCharacters(stack<char> &s, string target) {
        stack<char> result;
        for (auto &n : target) {
            if (n == '#') {
                if (!s.empty()) s.pop();
            }
            else s.push(n);
        }
    }
};
