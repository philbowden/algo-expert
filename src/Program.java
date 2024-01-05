import java.util.*;

class Program {
    public static void main(String[] args) {
        System.out.println(levenshteinDistance("abc", "yabd"));
    }
    public static int levenshteinDistance(String str1, String str2) {
        int[][] dpDistance = new int[str1.length() + 1][str2.length() +1];

        for (int row = 0; row < str2.length() + 1; row++)
            dpDistance[0][row] = row;
        for (int col = 0; col < str1.length() + 1; col++)
            dpDistance[col][0] = col;

        for (int row = 1; row < str1.length() + 1; row++) {
            for (int col = 1; col < str2.length() + 1; col++) {
                char prevCol = str2.charAt(col-1);
                char prevRow = str1.charAt(row-1);
                if (prevCol == prevRow) {
                    dpDistance[row][col] = dpDistance[row-1][col-1];
                } else {
                    //take smallest from previous upper, lower, or diagonal value and add 1.
                    int upperVal = dpDistance[row-1][col];
                    int leftVal = dpDistance[row][col-1];
                    int diagonalVal = dpDistance[row-1][col-1];
                    dpDistance[row][col] = 1 + Math.min(diagonalVal, Math.min(leftVal, Math.min(leftVal, upperVal)));
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
