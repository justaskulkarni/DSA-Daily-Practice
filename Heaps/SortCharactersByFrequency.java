package Heaps;
import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++)
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for(char key: map.keySet()) 
            maxHeap.add(key);
        String ans = "";
        while(!maxHeap.isEmpty()){
            char key = maxHeap.poll();
            int val = map.get(key);
            ans += (key + "").repeat(val);
        }
        return ans;        
    }
}
