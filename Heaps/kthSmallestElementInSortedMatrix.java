package Heaps;
import java.util.PriorityQueue;

public class kthSmallestElementInSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                maxHeap.add(matrix[i][j]);
            }
        } 
        for(int i = 0; i < matrix.length * matrix.length - k; i++){
            maxHeap.poll();
        }
        return maxHeap.poll();   
    }    
}
