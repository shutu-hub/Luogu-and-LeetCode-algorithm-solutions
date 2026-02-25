package Hot100;


/**
 * HOT100-8:无重复字符的最长子串
 * 解题思路：
 * 滑动窗口思想，我们假设一个区间，包含左边界和右边界，每次右边界向右移动一个字符后，该字符可能和已有区间中的某个字符重复，
 * 这时候需要移动左边界到该重复字符的右侧，这样就能排除掉之前的重复字符
 * 每次扩展右边界和收缩左边界之后，区间为无重复字符的区间，更新最大大小。
 */
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
        char[] chars = s.toCharArray();
        int[] count = new int[128];
        int left = 0;
        int maxLength=0;
        for (int right = 0; right < chars.length; right++) {
            // 扩展右边界,收缩左边界
            char rightChar = chars[right];
            count[rightChar]++;
            while (count[rightChar]>1){
                char leftChar = chars[left];
                count[leftChar]--;
                left++;
            }
            maxLength=Math.max(maxLength,right-left+1);
        }
        return maxLength;
    }
}
