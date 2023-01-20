package HashTable;

import java.util.*;

public class duplicateValuesInAnArray {
    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i]))
                arr.add(nums[i]);
        }
        return arr;
    }
}
