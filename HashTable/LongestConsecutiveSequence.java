package HashTable;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums)
            set.add(num);

        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int currentLength = 1;
            if (!set.contains(current - 1)) {
                while (set.contains(current + 1)) {
                    currentLength++;
                    current++;
                }
            }
            maxLength = Math.max(currentLength, maxLength);
        }

        return maxLength;

    }    
}
