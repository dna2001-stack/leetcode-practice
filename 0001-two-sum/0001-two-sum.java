class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Map to store: Number -> Index
        Map<Integer, Integer> seenNumbers = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            // Check if the required complement was already seen
            if (seenNumbers.containsKey(complement)) {
                return new int[] { seenNumbers.get(complement), i };
            }
            // Otherwise, remember this number and its index
            seenNumbers.put(nums[i], i);
        }
        // Return empty array if no pair found
        return new int[] {};
    }
}