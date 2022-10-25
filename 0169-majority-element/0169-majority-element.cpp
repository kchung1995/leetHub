class Solution {
public:
    int majorityElement(vector<int>& nums) {
        
        if (((nums.size() / 2) + 1) > (nums.size() - 1)) return nums[nums.size() - 1];
        
        sort(nums.begin(), nums.end());
        
        int mid = 0;
        
        cout << nums.size() << endl;
        
        if (nums.size() % 2 == 0) {
            mid = (nums.size() / 2) - 1;
        }
        else {
            mid = nums.size() / 2;
        }
        return nums[mid];
    }
};