class Solution {
private:
    queue<pair<int, int> > q;   // currentPosition, moveCount
    int visitedCount[401];
    int snakeAndLadders[401];
    const int inf = 2147483647;
    
    
public:
    
    void init(int n, vector<vector<int>>& board) {
        for (int i = 1; i <= n*n; i++) {
            visitedCount[i] = inf;
        }
        
        int pos = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (n % 2 == 0) {
                if (i % 2 == 1) {
                    for (int j = 0; j < n; j++) {
                        snakeAndLadders[pos] = board[i][j];
                        pos++;
                    }
                }
                if (i % 2 == 0) {
                    for (int j = n - 1; j >= 0; j--) {
                        snakeAndLadders[pos] = board[i][j];
                        pos++;
                    }
                }
            }
            if (n % 2 == 1) {
                if (i % 2 == 0) {
                    for (int j = 0; j < n; j++) {
                        snakeAndLadders[pos] = board[i][j];
                        pos++;
                    }
                }
                if (i % 2 == 1) {
                    for (int j = n - 1; j >= 0; j--) {
                        snakeAndLadders[pos] = board[i][j];
                        pos++;
                    }
                }
            }
        }
    }
    
    int snakesAndLadders(vector<vector<int>>& board) {
        
        int n = board.size();
        init(n, board);
        
        q.push({1, 0}); // initial position, initial moveCount
        while(!q.empty()) {
            int currentPosition = q.front().first;
            int currentMoveCount = q.front().second;
            q.pop();
            
            // roll a dice
            for (int i = 1; i <= min(6, n*n - currentPosition); i++) {
                int nextPosition = currentPosition + i;
                int nextMove = currentMoveCount + 1;
                if (snakeAndLadders[nextPosition] != -1) {
                    nextPosition = snakeAndLadders[nextPosition];
                }
                
                if (nextMove < visitedCount[nextPosition]) {
                    visitedCount[nextPosition] = nextMove;
                    q.push({nextPosition, nextMove});
                }
            }
        }
        
        if (visitedCount[n*n] == inf) {
            return -1;
        }
        return visitedCount[n*n];
    }
};