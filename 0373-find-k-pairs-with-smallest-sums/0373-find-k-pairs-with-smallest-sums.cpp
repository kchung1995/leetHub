class Solution {
public:
    vector<vector<int>> kSmallestPairs(vector<int>& nums1, vector<int>& nums2, int k) {
        int m = nums1.size();
        int n = nums2.size();

        vector<vector<int>> result;
        set<pair<int, int>> visited;

        priority_queue<pair<int, pair<int, int>>, vector<pair<int, pair<int, int>>>, greater<pair<int, pair<int, int>>>> pq;
        pq.push({nums1[0] + nums2[0], {0, 0}});
        visited.insert({0, 0});

        while (k-- && !pq.empty()) {
            int i = pq.top().second.first;
            int j = pq.top().second.second;
            pq.pop();

            result.push_back({nums1[i], nums2[j]});

            if (i + 1 < m && visited.find({i + 1, j}) == visited.end()) {
                pq.push({nums1[i + 1] + nums2[j], {i + 1, j}});
                visited.insert({i + 1, j});
            }

            if (j + 1 < n && visited.find({i, j + 1}) == visited.end()) {
                pq.push({nums1[i] + nums2[j + 1], {i, j + 1}});
                visited.insert({i, j + 1});
            }
        }

        return result;
    }
};
