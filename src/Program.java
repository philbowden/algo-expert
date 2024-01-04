import java.util.*;

class Program {
    public static void main(String[] args) {
        int[] denoms = {1, 5, 10};
        System.out.println(minNumberOfCoinsForChange(7, denoms));
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
