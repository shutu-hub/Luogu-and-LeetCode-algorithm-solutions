package Hot100;

/**
 * 最长回文子串
 * 解题思路：采用暴力搜索的思想，我们需要枚举左端点和右端点，时间复杂度为O（n2）,而内层还需要检验是否为回文子串，
 * 时间复杂度为O（n），题目数据量为1e3，那需要思考怎么将检验回文子串的时间从O（n）将为O（1）
 * 使用动态规划的思想：dp[i][j]代表子串s[i]...s[j]为回文子串，那么判断dp[s][j]的条件为：s[i]==s[j]且dp[i+1][j-1]为true
 * 动态规划枚举时需要从字符串长度小的开始枚举，这样较长长度的字符串在使用时，任意一个较小长度的序列都是被推理过的
 */
public class L93 {

    public String longestPalindrome(String s) {
        int length = s.length();
        if (length<2){
            return s;
        }
        // i...j回文条件->s[i]==s[j]且dp[i+1][j-1]为true
        boolean[][] dp = new boolean[length][length];
        // 每个长度为1的字串都是回文子串
        for (int i = 0; i < length; i++) {
            dp[i][i]=true;
        }
        char[] chars = s.toCharArray();
        int maxLen=1;
        int begin=0;
        // 枚举字符串长度
        for (int len = 2; len <= length; len++) {
            // 枚举左端点
            for (int i = 0; i < length; i++) {
                // 计算右端点
                int j = i+len-1;
                if (j>=length){
                    break;
                }
                if (chars[i]==chars[j]) {
                    if (len<3){
                        dp[i][j]=true;
                    }else{
                        dp[i][j]=dp[i+1][j-1];
                    }
                }
                if (dp[i][j] && len>maxLen){
                    maxLen=j-i+1;
                    begin=i;
                }
            }
        }
        return s.substring(begin,begin+maxLen);
    }
}
