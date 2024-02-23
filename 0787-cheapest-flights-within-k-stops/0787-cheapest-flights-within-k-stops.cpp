class Solution {
public:
    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int k) {
        vector<vector<pair<int, int>>> adjacent(n);
        for (auto& flight : flights) {
            adjacent[flight[0]].push_back({flight[1], flight[2]});
        }
        vector<int> distances(n, numeric_limits<int>::max());
        queue<pair<int, int>> q;
        q.push({src, 0});
        int stops = 0;

        while (stops <= k && !q.empty()) {
            int qSize = q.size();
            while (qSize--) {
                auto [node, distance] = q.front();
                q.pop();
                for (auto& [neighbour, price] : adjacent[node]) {
                    if (price + distance >= distances[neighbour]) continue;
                    distances[neighbour] = price + distance;
                    q.push({neighbour, distances[neighbour]});
                }
            }
            stops++;
        }
        if (distances[dst] == numeric_limits<int>::max()) return -1;
        else return distances[dst];
    }
};

