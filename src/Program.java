import java.util.*;

class Program {
    public static void main(String[] args) {
        System.out.println(levenshteinDistance("abc", "yabd"));
    }
    public static int levenshteinDistance(String str1, String str2) {
        int[][] dpDistance = new int[str1.length() + 1][str2.length() +1];

        for (int i = 0; i < str2.length() + 1; i++)
            dpDistance[0][i] = i;
        for (int i = 0; i < str1.length() + 1; i++)
            dpDistance[i][0] = i;

        for (int i = 1; i < str1.length() + 1; i++) {
            for (int j = 1; j < str2.length() + 1; j++) {
                if (str2.charAt(j-1) == str1.charAt(i-1)) {
                    dpDistance[i][j] = dpDistance[i-1][j-1];
                } else {
                    dpDistance[i][j] = 1 + Math.min(dpDistance[i-1][j-1], Math.min(dpDistance[i][j-1], Math.min(dpDistance[i][j-1], dpDistance[i-1][j])));
                }
            }
        }
        return dpDistance[str1.length()][str2.length()];
    }
    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, n+1);
        dp[0] = 0;
        for (int denom : denoms) {
            for (int amount = 1; amount < dp.length; amount++) {
                if (denom <= amount) {
                    dp[amount] = Math.min(1 + dp[amount-denom], dp[amount]);
                }
            }
        }
        if (dp[n] > n) {
            return -1;
        }
        return  dp[n];
    }
}
