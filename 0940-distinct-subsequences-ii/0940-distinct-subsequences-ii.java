class Solution {
    public int distinctSubseqII(String s) {
        int mod = 1_000_000_007;

        // endsWith[i] track karega character ('a' + i) pe khatam hone wale subsequences
        int[] endsWith = new int[26];
        int total = 0;

        for (char ch : s.toCharArray()) {
            int idx = ch - 'a';

            // Naya count = empty string (1) + ab tak ke saare bane huye subsequences
            int newCount = (1 + total) % mod;

            // Purana count minus kiya taaki duplicate add na ho
            // +mod isliye kyunki Java me negative modulo aa sakta hai
            int diff = (newCount - endsWith[idx] + mod) % mod;

            // Total update karo aur current char ka latest count save kar lo
            total = (total + diff) % mod;
            endsWith[idx] = newCount;
        }

        return total;
    }
}