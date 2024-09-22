import java.util.PriorityQueue;
import java.util.Comparator;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Create a priority queue (min-heap) to store points based on their distance to the origin
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                // Calculate the squared distances for both points
                int distance1 = point1[0] * point1[0] + point1[1] * point1[1];
                int distance2 = point2[0] * point2[0] + point2[1] * point2[1];
                // Compare distances: a smaller distance comes first in the min-heap
                return Integer.compare(distance1, distance2);
            }
        });

        // Add all points to the priority queue
        for (int[] point : points) {
            minHeap.offer(point);
        }

        // Prepare the result array
        int[][] result = new int[k][2];

        // Extract the k closest points from the min-heap
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }

        return result;
    }
}
