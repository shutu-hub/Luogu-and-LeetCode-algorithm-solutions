package Hot100;

import java.util.HashSet;
import java.util.List;

public class L86 {

    public static void main(String[] args) {
        System.out.println(wordBreak("leetcode", List.of("leet", "code")));
    }

    // leetcode
    public static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0]=true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                // s[0...i] = s[0...j]+s[j...i] 这样就枚举了一个单词所有的组成情况  ; 0<=j<=i-1
                if (dp[j] && set.contains(s.substring(j,i))){
                    // 可以组成  s[0...i]
                    dp[i]=true;
                }
            }
        }
        return dp[s.length()];
    }
}
