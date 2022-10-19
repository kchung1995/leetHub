class Solution {
public:
    
    static bool cmp(vector<int> a, vector<int> b) {
        if (a[0] == b[0]) {
            return a[1] > b[1];
        }
        return a[0] < b[0];
    }
    
    int removeCoveredIntervals(vector<vector<int>>& intervals) {
        
        sort(intervals.begin(), intervals.end(), cmp);
        
        for (int i = 0; i < intervals.size() - 1; i++) {
            // comparing i and j
            for (int j = i + 1; j < intervals.size(); j++) {
                if (intervals[i][0] <= intervals[j][0] && intervals[j][1] <= intervals[i][1]) {
                    intervals.erase(intervals.begin() + j);
                    j--;
                }
            }
        }
        
        return intervals.size();
    }
};