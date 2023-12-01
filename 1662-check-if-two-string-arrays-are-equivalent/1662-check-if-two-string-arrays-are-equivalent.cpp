class Solution {
public:
    bool arrayStringsAreEqual(vector<string>& word1, vector<string>& word2) {
        string one = "";
        for (auto &next : word1) {
            one += next;
        }

        string two = "";
        for (auto &next : word2) {
            two += next;
        }

        return one == two;
    }
};
