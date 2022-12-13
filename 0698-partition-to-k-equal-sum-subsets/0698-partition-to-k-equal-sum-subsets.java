class Solution {
    private boolean dfs(
        int[] nums,
        int k, int target, int index, int currentSum,
        boolean[] visited
    ) {
        if (k == 1) {
            return true;
        }
        if (currentSum > target) {
            return false;
        }
        if (currentSum == target)  {
            return dfs(nums, k - 1, target, 0, 0, visited);
        }
        
        for (int i = index; i < nums.length; i++) {
            int tempSum = currentSum + nums[i];
            if (visited[i]) {
                continue;
            }
            if (tempSum > target) {
                break;
            }
            visited[i] = true;
            if (dfs(nums, k, target, i + 1, tempSum, visited)) {
                return true;
            }
            visited[i] = false;
        }
        return false;
    }
    
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) {
            return false;
        }
        
        int target = sum / k;
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        return dfs(nums, k, target, 0, 0, visited);
    }
}