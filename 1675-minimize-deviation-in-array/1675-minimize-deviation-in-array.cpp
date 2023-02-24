class Solution {
public:
    int minimumDeviation(vector<int>& nums) {
        set<int> set;
        
        for (auto &i : nums) {
            if (i % 2 == 1) set.insert(i * 2);
            else set.insert(i);
        }
        
        int result = *set.rbegin() - *set.begin();
        while (*set.rbegin() % 2 == 0) {
            int current = *set.rbegin();
            set.erase(current);
            set.insert(current / 2);
            result = min(result, *set.rbegin() - *set.begin());
        }
        
        return result;
    }
};