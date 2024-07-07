class Solution {
public:
    int minGroups(vector<vector<int>>& intervals) {
        vector<vector<int>> memo;

        for (auto& v : intervals) {
            memo.push_back({v[0], 1});
            memo.push_back({v[1] + 1, -1});
        }
        int result = 0, current = 0;
        sort(memo.begin(), memo.end());
        for (auto &v : memo) {
            result = max(result, current += v[1]);
        }

        return result;
    }
};

