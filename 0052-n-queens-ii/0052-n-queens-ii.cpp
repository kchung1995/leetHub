class Solution {
public:
    
    int answer = 0;
    int queens[9];
    
    bool canPlace(int j) {
        // check current row
        for (int i = 0; i < j; i++) {
            if (queens[i] == queens[j]) return false;
            if (abs(j - i) == abs(queens[j] - queens[i])) return false;
        }
        
        return true;
    }
    
    
    void dfs(int j, int &n) {
        // if n queens have been placed
        if (j == n) {
            answer++;
            return;
        }
        
        // check if there's any possible position at current row (j)
        for (int i = 0; i < n; i++) {
            queens[j] = i;
            if (canPlace(j)) {
                dfs(j + 1, n);
            }
        }
    }
    
    int totalNQueens(int n) {
        dfs(0, n);
        return answer;
    }
};