class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {

        // keeps the longest common prefix
        string answer = "";

        // if there is no given strings, break
        if (strs.empty()) return answer;

        // search among given strings
        int i = 0;
        while(1) {
            // if the first string's length is less than i, break;
            if (strs[0].size() <= i) break;
            char temp = strs[0][i];

            bool noMorePrefix = false;
            for (int j = 1; j < strs.size(); j++) {
                if (strs[j].size() <= i) noMorePrefix = true;
                if (strs[j][i] != temp) noMorePrefix = true;
            }

            if (noMorePrefix) break;

            answer += string(1, temp);
            i++;
        }

        return answer;
    }
};