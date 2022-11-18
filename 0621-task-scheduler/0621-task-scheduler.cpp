class Solution {
private:
    unordered_map<char, int> intervals;
    
public:
    int leastInterval(vector<char>& tasks, int n) {
        int mostSchedule = 0;
        // init
        for (auto &next : tasks) {
            intervals[next]++;
            mostSchedule = max(mostSchedule, intervals[next]);
        }
        
        // compare with the most appeared schedule
        int result = (mostSchedule - 1) * (n + 1);
        
        for (auto &next : intervals) {
            if (next.second == mostSchedule) {
                result++;
            }
        }
        
        if (tasks.size() >= result) {
            result = tasks.size();
        }
        
        return result;
    }
};