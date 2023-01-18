class Solution {
public:
    string longestDiverseString(int a, int b, int c) {
        priority_queue<pair<int, char>> q;
        string result = "";
        int total = a + b + c;
        
        q.push({a, 'a'});
        q.push({b, 'b'});
        q.push({c, 'c'});
        
        char prevChar = '.';
        int prevCount = 0;
        
        while(!q.empty()) {
            char currentChar = q.top().second;
            int currentCount = q.top().first;
            q.pop();
            
            if (currentCount == 0) continue;
            if (prevCount > 0) {
                q.push({prevCount, prevChar});
            }
            
            if (currentCount >= 2) {
                int add;
                (currentCount > total - currentCount) ? add = 2 : add = 1;
                for (int i = 0; i < add; i++) {
                    result += currentChar;
                }
                currentCount -= add;
                total -= add;
            }
            else {
                result += currentChar;
                currentCount--;
                total--;
            }
            prevChar = currentChar;
            prevCount = currentCount;
        }
        
        return result;
    }
};