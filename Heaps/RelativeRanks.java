package Heaps;
import java.util.PriorityQueue;
public class RelativeRanks {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] res = new String[n];
        // Add indexes to the priority queue rather than the scores
        // Used lambda function to make a priority queue with the property of ordering indexes according to their corresponding values in the score array. 
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> score[b] - score[a]);
        for(int i = 0; i < n; i++)
            maxHeap.add(i);
        // Initialise counter variable. It indicates rank of each element.
        int count = 1;
        while(!maxHeap.isEmpty()){
            int idx = maxHeap.poll();
            if(count > 3)
                res[idx] = Integer.toString(count);
            if(count == 3)
                res[idx] = "Bronze Medal";
            if(count == 2)
                res[idx] = "Silver Medal";
            if(count == 1)
                res[idx] = "Gold Medal";
            ++count;
        }
        return res;
    }
    
}