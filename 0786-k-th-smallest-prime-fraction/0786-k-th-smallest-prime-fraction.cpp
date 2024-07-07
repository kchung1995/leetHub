class Solution {
public:
    vector<int> kthSmallestPrimeFraction(vector<int>& arr, int k) {
        int n = arr.size();
        priority_queue<pair<double, pair<int, int>>> pq;

        for (int i = 0; i < n - 1; i++)
            pq.push({fraction(arr, i) / arr.back(), {i, arr.size() - 1}});
        
        while (k > 1) {
            pair<int, int> cur = pq.top().second;
            pq.pop();
            cur.second--;
            pq.push({fraction(arr, cur.first) / arr[cur.second], 
                    {cur.first, cur.second}});
            k--;
        }
        
        pair<int, int> result = pq.top().second;
        return {arr[result.first], arr[result.second]};
    }

private:
    double fraction(vector<int>& arr, int index) {
        return -1.0 * arr[index];
    }
};

