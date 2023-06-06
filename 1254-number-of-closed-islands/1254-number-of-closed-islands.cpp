class Solution {
private:
    int dx[4] = {-1, 0, 1, 0};
    int dy[4] = {0, 1, 0, -1};

    int n;
    int m;
    bool visited[100][100] = { 0, };

    bool isInBoundary(int x, int y) {
        if (0 <= x && x < n && 0 <= y && y < m) return true;
        return false;
    }

    bool isClosedIsland(int x, int y, vector<vector<int>> &grid) {
        queue<pair<int, int>> q;
        q.push({x, y});
        visited[x][y] = true;

        bool isClosedIsland = true;

        while(!q.empty()) {
            int cx = q.front().first;
            int cy = q.front().second;
            q.pop();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cx + dx[dir];
                int ny = cy + dy[dir];
                if (!isInBoundary(nx, ny)) {
                    isClosedIsland = false;
                    continue;
                }
                if (grid[nx][ny] == 1 || visited[nx][ny]) continue;

                visited[nx][ny] = true;
                q.push({nx, ny});
            }
        }
        return isClosedIsland;
    }
public:
    int closedIsland(vector<vector<int>>& grid) {
        n = grid.size();
        m = grid[0].size();

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 || visited[i][j]) continue;
                if (isClosedIsland(i, j, grid)) result++;
            }
        }

        return result;
    }
};

