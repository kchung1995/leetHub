class Solution {
public:
    int findShortestSubArray(vector<int>& nums) {
        unordered_map<int, int> occurs;
        unordered_map<int, int> firstMeet;
        
        int numsDegree = -1;
        int subArrayLength = -1;
        
        
        for (int i = 0; i < nums.size(); i++) {
            int current = nums[i];
            occurs[current]++;
            if (firstMeet.find(current) == firstMeet.end()) {
                firstMeet[current] = i;
            }
            
            if (occurs[current] == numsDegree) {
                int currentLength = i - firstMeet[current] + 1;
                if (currentLength < subArrayLength) {
                    subArrayLength = currentLength;
                }
            }
            
            if (occurs[current] > numsDegree) {
                subArrayLength = i - firstMeet[current] + 1;
                numsDegree = occurs[current];
            }
        }
        
        return subArrayLength;
    }
};