class Solution {
private:
    void dfs(vector<int> &nums, int index, int result, int &count, int &target) {
        if (index == nums.size()) {
            if (result == target) {
                count++;
            }
            return;
        }
        
        dfs(nums, index + 1, result + nums[index], count, target);
        dfs(nums, index + 1, result - nums[index], count, target);
    }
public:
    int findTargetSumWays(vector<int>& nums, int target) {
        int count = 0;
        dfs(nums, 0, 0, count, target);
        return count;
    }
};