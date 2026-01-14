package Hot100;

public class L94 {
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("bsbininm", "jmjkbkjkv"));
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        int[][]dp = new int[chars1.length+1][chars2.length+1];
        for (int i = 1; i <= chars1.length; i++) {
            for (int j = 1; j <= chars2.length; j++) {
                if (chars1[i-1]==chars2[j-1]){
                    // 应该从dp[i-1][j-1]转移，避免某个字符计算多次
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[chars1.length][chars2.length];
    }
}
