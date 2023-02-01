class Solution {
public:
    int longestSubsequence(string s, int k) {
        int validOnes = 0;
        int zeros = 0;
        int currentNumber = 0;
        int currentPower = 1;
        
        for (auto &i : s) {
            if (i == '0') zeros++;
        }
        
        for (int i = s.size() - 1; i >= 0; i--) {
            if (s[i] == '1') {
                validOnes++;
                currentNumber += currentPower;
            }
            currentPower *= 2;
            
            if (currentNumber + currentPower > k) {
                break;
            }
        }
        
        return validOnes + zeros;
    }
};