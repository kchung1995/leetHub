class Solution {
private:
    void informToSubordinates(int time, int currentEmployee, vector<int> &informTime, unordered_map<int, vector<int>> &employees, vector<int> &finallyInformedTimes) {
        if (currentEmployee == -1 || employees[currentEmployee].empty()) {
            finallyInformedTimes.push_back(time);
            return;
        }

        int nextTime = time + informTime[currentEmployee];
        for (auto &next : employees[currentEmployee]) {
            informToSubordinates(nextTime, next, informTime, employees, finallyInformedTimes);
        }
    }

public:
    int numOfMinutes(int n, int headID, vector<int>& manager, vector<int>& informTime) {
        unordered_map<int, vector<int>> employees;
        vector<int> finallyInformedTimes;

        for (int i = 0; i < n; i++) {
            employees[manager[i]].push_back(i);
        }

        informToSubordinates(0, headID, informTime, employees, finallyInformedTimes);
        return *max_element(finallyInformedTimes.begin(), finallyInformedTimes.end());
    }
};

