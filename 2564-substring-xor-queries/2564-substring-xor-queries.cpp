class Solution {
public:
    vector<vector<int>> substringXorQueries(string s, vector<vector<int>>& queries) {
        int n = s.size();
        int q = queries.size();

        vector<vector<int>> result;
        unordered_map<long long, pair<int, int>> map;

        for (int i = 0; i < n; i++) {
            if (s[i] == '0') {
                if (!map.count(0)) map[0] = make_pair(i, i);
                continue;
            }
            long long num = 0;
            for (int j = i; j <= min(n - 1, i + 32); j++) {
                num = (num << 1) + (s[j] - '0');
                if (map.count(num) == 0) map[num] = make_pair(i, j);
            }
        }
        for (int i = 0;i < q; i++){
            int num = queries[i][0] ^ queries[i][1];
            if (map.count(num)) {
                result.push_back({map[num].first,map[num].second});
            } else {
                result.push_back({-1,-1});
            }
        }

        return result;
    }
};
