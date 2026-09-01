import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequency of each number using a HashMap
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int number : nums) {
            frequencyMap.put(number, frequencyMap.getOrDefault(number, 0) + 1);
        }

        // Step 2: Create buckets where index = frequency count
        // An array of size (nums.length + 1) because frequency can be from 0 to N
        @SuppressWarnings("unchecked")
        List<Integer>[] buckets = new List[nums.length + 1];

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int number = entry.getKey();
            int count = entry.getValue();

            // If no list exists at this bucket index yet, create a new one
            if (buckets[count] == null) {
                buckets[count] = new ArrayList<>();
            }
            buckets[count].add(number);
        }

        // Step 3: Collect top K elements by iterating backwards from highest frequency
        int[] topKResult = new int[k];
        int resultIndex = 0;

        for (int count = buckets.length - 1; count >= 0 && resultIndex < k; count--) {
            if (buckets[count] != null) {
                for (int number : buckets[count]) {
                    topKResult[resultIndex] = number;
                    resultIndex++;

                    // If we have collected all K elements, return immediately
                    if (resultIndex == k) {
                        return topKResult;
                    }
                }
            }
        }

        return topKResult;
    }
}