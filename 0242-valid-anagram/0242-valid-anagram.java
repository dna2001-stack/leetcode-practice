class Solution {
    public boolean isAnagram(String s, String t) {
        // Step 1: If lengths don't match, they cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // Step 2: Create a frequency array for 26 letters ('a' to 'z')
        int[] letterCounts = new int[26];

        // Step 3: Count letters in 's' (+1) and 't' (-1)
        for (int i = 0; i < s.length(); i++) {
            letterCounts[s.charAt(i) - 'a']++;
            letterCounts[t.charAt(i) - 'a']--;
        }

        // Step 4: Verify all counts balanced back to 0
        for (int count : letterCounts) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}