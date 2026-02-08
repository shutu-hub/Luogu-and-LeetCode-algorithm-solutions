package Hot100;

public class L8 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("tmmzuxt"));
    }

    /**
     * 无重复字符的最长子串
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
       int[] count = new int[128];
       int left = 0;
       int maxLength = 0;
        for (int right = 0; right < s.length(); right++) {
            char index = s.charAt(right);
            count[index]++;
            // 如果count[index]>1，则说明left-right之间，index字符存在重复
            while (count[index]>1){
                // 收缩左边界
                char leftChar = s.charAt(left);
                count[leftChar]--;
                left++;
            }
            maxLength=Math.max(maxLength,right-left+1);
        }
        return maxLength;
    }
}
