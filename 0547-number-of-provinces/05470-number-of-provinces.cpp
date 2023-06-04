class Solution {
private:
    int parent[200];

    int getParent(int x) {
        if (x == parent[x]) return x;
        else return getParent(parent[x]);
    }

    void makeUnion(int x, int y) {
        x = getParent(x);
        y = getParent(y);
        if (x <= y) parent[y] = x;
        else parent[x] = y;
    }

public:
    int findCircleNum(vector<vector<int>>& isConnected) {
        int n = isConnected.size();
        for (int i = 0; i < n; i++) parent[i] = i;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j]) makeUnion(i, j);
            }
        }

        unordered_set<int> result;
        for (int i = 0; i < n; i++) {
            result.insert(getParent(i));
        }
        return result.size();
    }
};

