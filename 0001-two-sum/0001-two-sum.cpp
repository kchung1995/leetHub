class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        
        vector<pair<int, int> > numsPair;
        
        for (int i = 0; i < nums.size(); i++) {
            numsPair.push_back({nums[i], i});
        }
        
        sort(numsPair.begin(), numsPair.end());
        
        vector<int> result;
        bool foundAnswer = false;
        for (int i = 0; i < nums.size() - 1; i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                int temp = numsPair[i].first + numsPair[j].first;
                if (temp > target) break;
                if (temp == target) {
                    result.push_back(numsPair[i].second);
                    result.push_back(numsPair[j].second);
                    foundAnswer = true;
                    break;
                }
            }
            if (foundAnswer) {
                break;
            }
        }
        
        sort(result.begin(), result.end());
        return result;
    }
};