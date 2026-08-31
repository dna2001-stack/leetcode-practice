class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Guard Clause: Handle null or empty input array
        if (strs == null || strs.length == 0) {
            return Collections.emptyList();
        }

        // Map to store: Canonical Sorted Key -> List of original anagram words
        Map<String, List<String>> anagramGroupsMap = new HashMap<>();

        for (String currentWord : strs) {
            // Guard against null elements inside the array
            if (currentWord == null) {
                continue;
            }

            // Step 1: Convert word to character array and sort it
            char[] characterArray = currentWord.toCharArray();
            Arrays.sort(characterArray);

            // Step 2: Create canonical key from the sorted characters
            String canonicalKey = new String(characterArray);

            // Step 3: Insert into map using Java 8+ computeIfAbsent
            anagramGroupsMap
                    .computeIfAbsent(canonicalKey, key -> new ArrayList<>())
                    .add(currentWord);
        }

        // Step 4: Return all grouped lists as a new ArrayList
        return new ArrayList<>(anagramGroupsMap.values());
    }
}