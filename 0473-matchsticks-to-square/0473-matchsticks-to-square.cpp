class Solution {
private:
    bool dfs(vector<int> &matchsticks, vector<long long> &squareSide, int selected) {
        if (selected == matchsticks.size()) {
            return true;
        }
        for (int i = 0; i < 4; i++) {
            if (squareSide[i] >= matchsticks[selected]) {
                squareSide[i] -= matchsticks[selected];
                if (dfs(matchsticks, squareSide, selected + 1)) {
                    return true;
                }
                squareSide[i] += matchsticks[selected];
            }
            else {
                continue;
            }
        }
        return false;
    }    
public:
    bool makesquare(vector<int>& matchsticks) {
        if (matchsticks.size() < 4) {
            return false;
        }
        long long matchSticksSum = reduce(matchsticks.begin(), matchsticks.end());
        // cannot make a square if matchSticksSum does not get divided by 4
        if (matchSticksSum % 4 != 0) {
            return false;
        }
        
        long long oneSide = matchSticksSum / 4;
        vector<long long> squareSide(4, oneSide);
        sort(matchsticks.begin(), matchsticks.end(), greater<int>());
        
        return dfs(matchsticks, squareSide, 0);
    }
};

