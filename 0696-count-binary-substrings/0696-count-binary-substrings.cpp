class Solution {
public:
    int countBinarySubstrings(string s) {
        int previous = 0;
        int current = 1;
        int result = 0;
        
        for (int i = 1; i < s.size(); i++) {
            if (s[i] != s[i - 1]) {
                result += min(previous, current);
                previous = current;
                current = 1;
            }
            else {
                current++;
            }
        }
        
        result += min(previous, current);
        return result;
    }
};