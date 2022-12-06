class Solution {
public:
    vector<int> sortedSquares(vector<int>& nums) {
        stack<int> negatives;
        queue<int> positives;
        
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] < 0) {
                negatives.push(pow(nums[i], 2));
            }
            else {
                positives.push(pow(nums[i], 2));
            }
        }
        
        vector<int> result;
        while (!negatives.empty() && !positives.empty()) {
            if (negatives.top() < positives.front()) {
                result.push_back(negatives.top());
                negatives.pop();
            }
            else {
                result.push_back(positives.front());
                positives.pop();
            }
        }
        
        while (!negatives.empty()) {
            result.push_back(negatives.top());
            negatives.pop();
        }
        
        while (!positives.empty()) {
            result.push_back(positives.front());
            positives.pop();
        }
        
        return result;
    }
};