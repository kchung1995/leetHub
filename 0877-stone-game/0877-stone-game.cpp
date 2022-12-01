class Solution {
public:
    bool stoneGame(vector<int>& piles) {
        
        int alice = 0, bob = 0;
        
        sort(piles.begin(), piles.end(), greater<int>());
        
        for (int i = 0; i < piles.size(); i+=2) {
            alice += piles[i];
            bob += piles[i + 1];
        }
        
        if (alice > bob) {
            return true;
        }
        else {
            return false;
        }
    }
};