class Solution {
public:
    bool stoneGame(vector<int>& piles) {
        
        int determinant = 0;
        
        sort(piles.begin(), piles.end(), greater<int>());
        
        for (int i = 0; i < piles.size(); i+=2) {
            determinant += piles[i];
            determinant -= piles[i + 1];
        }
        
        if (determinant > 0) {
            return true;
        }
        else {
            return false;
        }
    }
};