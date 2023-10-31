class Solution {
public:
    int maximumProduct(vector<int>& nums, int k) {
        if (nums.size() == 1) return nums[0] + k;

        priority_queue<int, vector<int>, greater<int> > pq;
        for (auto &num : nums) {
            pq.push(num);
        }

        while (k > 0) {
            pq.push(pq.top() + 1);
            pq.pop();
            k--;
        }

        long long result = 1;
        while (!pq.empty()) {
            result = result * pq.top();
            result = result % 1000000007;
            pq.pop();
        }

        return (int)result;
    }
};
