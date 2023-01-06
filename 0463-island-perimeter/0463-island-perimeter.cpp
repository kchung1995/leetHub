class Solution {
public:
    int dx[4] = {-1, 0, 1, 0};
    int dy[4] = {0, 1, 0, -1};
    
    bool isInBoundary(int &x, int &y, int &height, int &width) {
        if (0<= x && x < height && 0 <= y && y < width) {
            return true;
        }
        return false;
    }
    
    int numberOfBoundary(vector<vector<int>> &grid, int &x, int &y) {
        int result = 0;
        int height = grid.size();
        int width = grid[0].size();
        
        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            if (!isInBoundary(nx, ny, height, width)) {
                result++;
                continue;
            }
            if (grid[nx][ny] == 0) {
                result++;
                continue;
            }
        }
        
        return result;
    }
    
    int islandPerimeter(vector<vector<int>>& grid) {
        pair<int, int> start;
        // find the first point to start BFS
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid[0].size(); j++) {
                if (grid[i][j] == 1) {
                    start = {i, j};
                    break;
                }
            }
        }
        int height = grid.size();
        int width = grid[0].size();
        vector<vector<bool>> isVisited(height, vector<bool>(width, false));
        
        int result = 0;
        queue<pair<int, int>> q;
        q.push(start);
        isVisited[q.front().first][q.front().second] = true;
        int dx[4] = {-1, 0, 1, 0};
        int dy[4] = {0, 1, 0, -1};
        
        while(!q.empty()) {
            int cx = q.front().first;
            int cy = q.front().second;
            q.pop();
            
            result += numberOfBoundary(grid, cx, cy);
            
            for (int dir = 0; dir < 4; dir++) {
                int nx = cx + dx[dir];
                int ny = cy + dy[dir];

                if (!isInBoundary(nx, ny, height, width) || grid[nx][ny] == 0 || isVisited[nx][ny]) {
                    continue;
                }
                isVisited[nx][ny] = true;
                q.push({nx, ny});
            }
        }
        
        return result;
    }
};