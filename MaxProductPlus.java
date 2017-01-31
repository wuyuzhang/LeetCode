/**
 * Created by Yuzhang on 1/26/17.
 */


public class MaxProductPlus {
    private static int maxProductPlus(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int n = array.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (i == j) {
                    dp[j][i] = array[i];
                } else {
                    dp[j][i] = Integer.MIN_VALUE;
                    for (int k = j; k < i; k++) {
                        dp[j][i] = Math.max(dp[j][i], Math.max((dp[j][k] + dp[k + 1][i]), (dp[j][k] * dp[k + 1][i])));
                    }
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main (String[] args) {
        int[] array = {1,2,3};
        int result = maxProductPlus(array);
        System.out.println(result);
    }
}
