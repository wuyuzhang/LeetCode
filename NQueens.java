/**
 * Created by Yuzhang on 1/30/17.
 */
import java.util.*;
public class NQueens {
    public List<List<Integer>> nqueens(int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }
        List<Integer> cur = new ArrayList<>();
        helper(result, cur, n);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> cur, int n) {
        if (cur.size() == n) {
            result.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (valid(cur, i)) {
                cur.add(i);
                helper(result, cur, n);
                cur.remove(cur.size() - 1);
            }
        }
    }

    private boolean valid(List<Integer> cur, int col) {
        int row = cur.size();
        for (int i = 0; i < row; i++) {
            if (cur.get(i) == col || Math.abs(cur.get(i) - col) == Math.abs(row - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        NQueens solution = new NQueens();
        List<List<Integer>> result = new ArrayList<>();
        result = solution.nqueens(4);
        System.out.println(result);
    }
}
