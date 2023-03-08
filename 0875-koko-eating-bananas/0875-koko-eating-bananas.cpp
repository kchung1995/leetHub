class Solution {
public:
    int getRounding(int banana, int k) {
        if (banana % k == 0) {
            return banana / k;
        }
        return (banana / k) + 1;
    }
    
    int minEatingSpeed(vector<int>& piles, int h) {
        int left = 1;
        int right = *max_element(piles.begin(), piles.end());
        
        while (left < right) {
            int k = left + ((right - left) / 2);
            
            int sum = 0;
            for (auto &i : piles) {
                sum += getRounding(i, k);
                if (sum > h) {
                    left = k + 1;
                    continue;
                }
            }
            
            if (sum > h) {
                left = k + 1;
            }
            else {
                right = k;
            }
        }
        
        return left;
    }
};