class Solution {
private:
    int dx[4] = {-1, 0, 1, 0};
    int dy[4] = {0, 1, 0, -1};
    queue<pair<int, int>> q;
public:
    int bfs(int &i, int &j, vector<vector<int>> &grid, vector<vector<bool>> &visited) { 
        visited[i][j] = true;
        int size = 1;
        q.push({i, j});
        
        while(!q.empty()) {
            int cx = q.front().first;
            int cy = q.front().second;
            q.pop();
            
            for (int dir = 0; dir < 4; dir++) {
                int nx = cx + dx[dir];
                int ny = cy + dy[dir];
                
                if (nx < 0 || nx >= grid.size() || ny < 0 || ny >= grid[0].size()) {
                    continue;
                }
                if (visited[nx][ny]) {
                    continue;
                }
                if (grid[nx][ny] != 1) {
                    continue;
                }
                visited[nx][ny] = true;
                size++;
                q.push({nx, ny});
            }
        }
        
        return size;
    }
    
    int maxAreaOfIsland(vector<vector<int>>& grid) {
        int maxAreaSize = 0;
        
        vector<vector<bool>> visited(grid.size(), vector<bool>(grid[0].size(), false));
        
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid[0].size(); j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    maxAreaSize = max(maxAreaSize, bfs(i, j, grid, visited));
                }
            }
        }
        
        return maxAreaSize;
    }
};