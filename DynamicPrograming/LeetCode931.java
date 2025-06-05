package DynamicPrograming;

public class LeetCode931 {
    public int minFallingPathSum(int[][] matrix) {
        // 状态转移 ：位于正上方或者沿对角线向左或者向右的第一个元素
        int[][]dp=new int[matrix.length][matrix[0].length];
        for (int j = 0; j < matrix.length; j++) {
            dp[0][j]=matrix[0][j];
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                // 正上方
                dp[i][j]=dp[i-1][j]+matrix[i][j];
                if (j>0){
                    // 左上角
                    dp[i][j]=Math.min(dp[i][j],dp[i-1][j-1]+matrix[i][j]);
                }
                if (j<matrix[i].length-1){
                    // 右上角
                    dp[i][j]=Math.min(dp[i][j],dp[i-1][j+1]+matrix[i][j]);
                }
            }
        }
        int min=Integer.MAX_VALUE;
        for (int j = 0; j < matrix[0].length; j++) {
            min=Math.min(min,dp[matrix.length-1][j]);
        }
        return min;
    }
}
