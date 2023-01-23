package HashTable;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        for (int i : map.keySet()) {
            if (map.get(i) > nums.length / 3)
                list.add(i);
        }
        return list;
    }    
}
