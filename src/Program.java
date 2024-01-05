import java.util.*;

class Program {
    public static void main(String[] args) {
        Program p = new Program();
        int[] nums = {1, -1};
        System.out.println(p.zeroSumSubarray(nums));
    }

    public boolean zeroSumSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        set.add(0);
        int currentSum = 0;
        for (int num : nums) {
            currentSum += num;
            if (set.contains(currentSum)) return true;
            set.add(currentSum);
        }
        return false;
    }


    public int bestSeat(int[] seats) {
        int bestSeat = -1;
        int maxSpace = 0;
        for (int left = 0; left < seats.length; left++) {
            if (seats[left] == 1) {
                int right = left + 1;
                while (right < seats.length && seats[right] != 1) {
                    right++;
                }
                int currentSpace = right - left - 1;
                if (currentSpace > maxSpace) {
                    maxSpace = currentSpace;
                    bestSeat = (left + right) / 2;
                }
            }
        }
        return bestSeat;
    }

    public static int levenshteinDistance(String str1, String str2) {
        int[][] dpDistance = new int[str1.length() + 1][str2.length() + 1];

        for (int row = 0; row < str2.length() + 1; row++)
            dpDistance[0][row] = row;
        for (int col = 0; col < str1.length() + 1; col++)
            dpDistance[col][0] = col;

        for (int row = 1; row < str1.length() + 1; row++) {
            for (int col = 1; col < str2.length() + 1; col++) {
                char prevCol = str2.charAt(col - 1);
                char prevRow = str1.charAt(row - 1);
                if (prevCol == prevRow) {
                    dpDistance[row][col] = dpDistance[row - 1][col - 1];
                } else {
                    //take smallest from previous upper, lower, or diagonal value and add 1.
                    int upperVal = dpDistance[row - 1][col];
                    int leftVal = dpDistance[row][col - 1];
                    int diagonalVal = dpDistance[row - 1][col - 1];
                    dpDistance[row][col] = 1 + Math.min(diagonalVal, Math.min(leftVal, Math.min(leftVal, upperVal)));
                }
            }
        }
        return dpDistance[str1.length()][str2.length()];
    }

    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;
        for (int denom : denoms) {
            for (int amount = 1; amount < dp.length; amount++) {
                if (denom <= amount) {
                    dp[amount] = Math.min(1 + dp[amount - denom], dp[amount]);
                }
            }
        }
        if (dp[n] > n) {
            return -1;
        }
        return dp[n];
    }
}
