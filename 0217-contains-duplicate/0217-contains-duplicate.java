class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> duplicate = new HashSet<Integer>();
        
        for (int next : nums) {
            if(duplicate.contains(next)) {
                return true;
            }
            duplicate.add(next);
        }
        
        return false;
    }
}