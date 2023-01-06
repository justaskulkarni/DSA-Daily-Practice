package Heaps;

import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentElementsBruteForce {
    public int[] topKFrequent(int[] nums, int k) {
        // Make a frequency map
        Map<Integer, Integer> map = new HashMap<>();
        // Fill the map with given elements and update frequency for each insertion
        for(int i: nums)
            map.put(i, map.getOrDefault(i, 0) + 1);

        // Now make a max heap & fill it with keys
        // On the peek of the heap will be the most frequent elements

        /*  (a,b) -> map.get(b)-map.get(a) is a lambda function
           One of the PriorityQueue constructors takes a Comparator as an argument:
           Creates a PriorityQueue with the default initial capacity and whose elements are ordered according to the specified comparator.*/
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

        for(int key: map.keySet()) 
            maxHeap.add(key);

        int[] res = new int[k];
        for(int i = 0; i < k; i++)
            res[i] = maxHeap.poll();
        return res;   
    }
}