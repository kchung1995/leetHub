class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<string>> anagrams;

        for (auto &word : strs) {
            string sorted = word;
            sort(sorted.begin(), sorted.end());

            if (anagrams.find(sorted) != anagrams.end()) { 
                anagrams[sorted].push_back(word);
            }
            else {
                vector<string> newList = { word };
                anagrams[sorted] = newList;
            }
        }

        vector<vector<string>> result;
        for (auto &entry : anagrams) {
            result.push_back(entry.second);
        }
        return result;
    }
};

