package Arrays;
import java.util.*;

public class subarraySumsDivisibleByk {
    public int subarraysDivByK(int[] nums, int k) {
        int ans = 0;

        // Hashmap stores remainder and it's corresponding frequency
        // If remainder is negative make it positive by adding k to it
        // If map contains a certain remainder, increase the frequency of the remainder
        // Add the remainder to answer variable

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, rem = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            rem = sum % k;
            if (rem < 0)
                rem += k;
            if (map.containsKey(rem)) {
                ans += map.get(rem);
                map.put(rem, map.get(rem) + 1);
            } else {
                map.put(rem, 1);
            }
        }
        return ans;
    }
}
