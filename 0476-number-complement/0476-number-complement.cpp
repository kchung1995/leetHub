class Solution {
public:
    string decimalToBinary(int &num) {
        string result = "";
        
        while(num >= 2) {
            result = to_string(num % 2) + result;
            num /= 2;
        }
        
        result = to_string(num) + result;
        return result;
    }
    
    int binaryComplementToDecimal(string input) {
        int result = 0;
        
        for (int i = 0; i < input.size(); i++) {
            if (input[input.size() - 1 - i] == '0') {
                result += (pow(2, i));
            }
        }
        
        return result;
    }
    
    int findComplement(int num) {
        return binaryComplementToDecimal(decimalToBinary(num));
    }
};