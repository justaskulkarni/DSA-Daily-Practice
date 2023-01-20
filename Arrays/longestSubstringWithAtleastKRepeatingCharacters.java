package Arrays;

public  class longestSubstringWithAtleastKRepeatingCharacters{
    public int longestSubstring(String s, int k) {
        return helper(s.toCharArray(), 0, s.length(), k);
    }

    public int helper(char[] ch, int start, int end, int k) {
        // If k is larger than length of string then no need of performing algorithm,
        // directly return 0
        if (end - start < k)
            return 0;

        // Count the frequency of each character occuring in the string
        int[] count = new int[26];
        for (int i = start; i < end; i++)
            count[ch[i] - 'a']++;

        // Traverse the string, if character visited has a frequency more than or equal
        // to k increment end pointer
        for (int i = start; i < end; i++) {
            if (count[ch[i] - 'a'] < k) {
                int j = i + 1;
                // Find next invalid character
                while (j < end && count[ch[j] - 'a'] < k)
                    j++;
                return Math.max(helper(ch, start, i, k), helper(ch, j, end, k));
            }
        }
        return end - start;
    }
}