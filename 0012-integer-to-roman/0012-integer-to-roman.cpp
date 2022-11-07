class Solution {
private:
    const int vals = 13;
    int intVal[13] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    string romanVal[13] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    
public:
    string intToRoman(int num) {
        string result = "";

        for (int i = 0; i < vals; i++) {
            int currentNum = num / intVal[i];
            for (int j = 0; j < currentNum; j++) {
                result += romanVal[i];
                num -= intVal[i];
            }
        }
        
        return result;
    }
    
};