class Solution {
private:
    int m, n;
    const int maxN = 10;
    const int INF = 2000000000;
    const int dx[4] = {-1, 0, 1, 0};
    const int dy[4] = {0, 1, 0, -1};
    
    bool inBoundary(int x, int y) {
        if (0 <= x && x < m && 0 <= y && y < n) {
            return true;
        }
        return false;
    }

public:
    int orangesRotting(vector<vector<int>>& grid) {
        m = grid.size();
        n = grid[0].size();
        
        int result = 0;
        queue<pair<int, int> > q;
        
        int visited[maxN][maxN];
        
        // set up visited grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = INF;
            }
        }
        
        // put all rotten oranges into q
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.push({i, j});
                    visited[i][j] = 0;
                }
            }
        }
        
        // bfs
        while (!q.empty()) {
            int cx = q.front().first;
            int cy = q.front().second;
            q.pop();
            
            for (int dir = 0; dir < 4; dir++) {
                int nx = cx + dx[dir];
                int ny = cy + dy[dir];
                
                if (!inBoundary(nx, ny)) {
                    continue;
                }
                if (grid[nx][ny] != 1) {
                    continue;
                }
                
                if (visited[nx][ny] > visited[cx][cy] + 1) {
                    visited[nx][ny] = visited[cx][cy] + 1;
                    result = max(result, visited[nx][ny]);
                    q.push({nx, ny});
                }
            }
        }
        
        // check if non-rotten oranges remain
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && visited[i][j] == INF) {
                    return -1;
                }
            }
        }
        
        return result;
    }
};