package SlidingWindow;
import java.util.HashSet;

public class LongestSubarrayWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        /*
        Sliding Window Technique 
        Two Pointer Mechanism
        */        
        int a_ptr = 0, b_ptr = 0, max = 0;
        HashSet<Character> hash_set = new HashSet<>();
        while(b_ptr < s.length()){
            if(!hash_set.contains(s.charAt(b_ptr))){
                hash_set.add(s.charAt(b_ptr));
                b_ptr++;
                max = Math.max(hash_set.size(), max);
            }
            else{
                hash_set.remove(s.charAt(a_ptr));
                a_ptr++;
            }
        }
        return max;
    }
}
