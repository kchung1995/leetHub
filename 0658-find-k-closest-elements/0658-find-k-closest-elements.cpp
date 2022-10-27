class Solution {
public:
    
    vector<int> getFirstKElements(vector<int> &arr, int k) {
        vector<int> result;
        
        for (int i = 0; i < k; i++) {
            result.push_back(arr[i]);
        }
        return result;
    }
    
    vector<int> getLastKElements(vector<int> &arr, int k) {
        vector<int> result;
        
        for (int i = arr.size() - 1; i >= 0; i--) {
            result.push_back(arr[i]);
            if (result.size() >= k) break;
        }
        return result;
    }
    
    // get the distance between the two elements
    int getDist(int from, int to) {
        return abs(from - to);
    }
    
    // find the closest position of x
    int findXPosition(vector<int> &arr, int &x) {
        int arrSize = arr.size();
        
        int dist = 1e9;
        int mid = -1;
        
        for (int i = 0; i < arrSize; i++) {
            int tempDist = getDist(x, arr[i]);
            if (tempDist < dist) {
                dist = tempDist;
                mid = i;
            }
        }
        
        return mid;
    }
    
    // use two pointers to get k closest elements from x
    vector<int> getCloseElements(vector<int> &arr, int xPos, int &k, int &x) {
        
        int left = xPos - 1;
        int right = xPos + 1;
        vector<int> result;
        
        result.push_back(arr[xPos]);

        while(result.size() < k) {
            
            // left and right cannot go beyond boundaries
            if (left < 0) {
                result.push_back(arr[right]);
                right++;
                continue;
            }
            if (right >= arr.size()) {
                result.push_back(arr[left]);
                left--;
                continue;
            }
            
            int leftDist = getDist(x, arr[left]);
            int rightDist = getDist(x, arr[right]);
            
            // if both left and right are in boundaries,
            if (leftDist <= rightDist) {
                result.push_back(arr[left]);
                left--;
                continue;
            }
            if (leftDist > rightDist) {
                result.push_back(arr[right]);
                right++;
                continue;
            }
        }
        
        sort(result.begin(), result.end());
        return result;
    }
    
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        
        if (arr[0] > x) {
            return getFirstKElements(arr, k);
        }
        if (arr.back() < x) {
            getLastKElements(arr, k);
        }
        
        int xPos = findXPosition(arr, x);
        return getCloseElements(arr, xPos, k, x); 
        
    }
};