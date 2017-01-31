import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Yuzhang on 1/30/17.
 */
public class KthSum {
    class Cell {
        int a;
        int b;
        public Cell(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
    public int findKthSmallest(int[] A, int[] B, int k) {
        if (A == null || B == null || A.length == 0 || B.length == 0 || A.length * B.length < k) {
            return 0;
        }
        PriorityQueue<Cell> heap = new PriorityQueue<>(1, new Comparator<Cell>() {
            @Override
            public int compare(Cell o1, Cell o2) {
                int sum1 = A[o1.a] + B[o1.b];
                int sum2 = A[o2.a] + B[o2.b];
                if (sum1 == sum2) {
                    return 0;
                }
                return sum1 < sum2 ? -1 : 1;
            }
        });
        boolean[][] visited = new boolean[A.length][B.length];
        heap.offer(new Cell(0, 0));
        visited[0][0] = true;
        for (int i = 0; i < k; i++) {
            Cell temp = heap.poll();
            if (temp.a + 1 < A.length && !visited[temp.a + 1][temp.b]) {
                heap.offer(new Cell(temp.a + 1, temp.b));
                visited[temp.a + 1][temp.b] = true;
            }
            if (temp.b + 1 < B.length && !visited[temp.a][temp.b + 1]) {
                heap.offer(new Cell(temp.a, temp.b + 1));
                visited[temp.a][temp.b + 1] = true;
            }
        }
        Cell result = heap.poll();
        return A[result.a] + B[result.b];
    }

    public static void main(String args[]) {
        KthSum solution = new KthSum();
        int[] A = {1,2,3,4,5,6,7};
        int[] B = {2,3,4,5,6,7,8};
        int result = solution.findKthSmallest(A, B, 0);
        System.out.println(result);
    }
}