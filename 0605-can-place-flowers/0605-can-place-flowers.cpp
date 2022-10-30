class Solution {
public:
    
    int plantableFront(vector<int> flowerbed) {
        int count = 0;
        int len = flowerbed.size();
        
        for (int i = 0; i < len; i++) {
            if (flowerbed[i] == 1) continue;
            if (i == 0) {
                if (flowerbed[i + 1] == 0) {
                    count++;
                    flowerbed[i] = 1;
                }
                continue;
            }
            if (i == len - 1) {
                if (flowerbed[i - 1] == 0) {
                    count++;
                    flowerbed[i] = 1;
                }
                continue;
            }
            if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                count++;
                flowerbed[i] = 1;
            }
        }
        return count;
    }
    
    int plantableBack(vector<int> flowerbed) {
        int count = 0;
        int len = flowerbed.size();
        
        for (int i = len - 1; i >= 0; i--) {
            if (flowerbed[i] == 1) continue;
            if (i == 0) {
                if (flowerbed[i + 1] == 0) {
                    count++;
                    flowerbed[i] = 1;
                }
                continue;
            }
            if (i == len - 1) {
                if (flowerbed[i - 1] == 0) {
                    count++;
                    flowerbed[i] = 1;
                }
                continue;
            }
            if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                count++;
                flowerbed[i] = 1;
            }
        }
        return count;
    }
    
    bool canPlaceFlowers(vector<int>& flowerbed, int n) {
        
        if (flowerbed.size() == 1 && flowerbed[0] == 0) {
            if (n <= 1) return true;
            else return false;
        }
        
        int maxPlantable = max(plantableFront(flowerbed), plantableBack(flowerbed));
        if (n <= maxPlantable) {
            return true;
        }
        return false;
    }
};