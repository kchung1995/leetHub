class Solution {
    public String licenseKeyFormatting(String s, int k) {
        s = s.toUpperCase();
        
        StringBuilder sb = new StringBuilder("");
        int i = s.length() - 1;
        int j = 0;        
        while (i >= 0) {
            char c = s.charAt(i);
            if (c == '-') {
                i--;
                continue;
            }
            sb.insert(0, c);
            j++;
            if (j == k) {
                sb.insert(0, '-');
                j = 0;
            }
            i--;
        }
        if (sb.length() > 0 && sb.charAt(0) == '-') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}