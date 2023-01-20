class Solution {
public:
    int isHill(vector<int> &arr, int pos) {
        if (pos == 0) return -1;
        if (pos == arr.size() - 1 ) return 1;
                                           
        if (arr[pos-1] < arr[pos] && arr[pos] > arr[pos+1]) return 0;
        if (arr[pos-1] < arr[pos] && arr[pos] < arr[pos+1]) return -1;
        if (arr[pos-1] > arr[pos] && arr[pos] > arr[pos+1]) return 1;
        return 10;  // non-reachable
    }
    
    int peakIndexInMountainArray(vector<int>& arr) {
        int front = 0;
        int end = arr.size() - 1;
        
        while(front <= end) {
            int mid = (front + end) / 2;
            if (isHill(arr, mid) == 0) return mid;
            else if (isHill(arr, mid) == -1) front = mid + 1;
            else if (isHill(arr, mid) == 1) end = mid - 1;
        }
        
        return -1;  // non-reachable
    }
};