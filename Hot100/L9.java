package Hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * HOT100-9:找到字符串中所有字母异位词
 */
public class L9 {

    public static void main(String[] args) {
        List<Integer> res = findAnagrams("cbaebabacd", "abc");
        for (Integer ele : res) {
            System.out.print(ele+" ");
        }
    }

    public static List<Integer> findAnagrams(String s, String p) {
       // 在 s 中找到 p 字母异位词
        if (s.length()<p.length()){
            return new ArrayList<>();
        }
        int[] count = new int[26];
        int[] targerCount = new int[26];
        for (int i = 0; i < p.length(); i++) {
            targerCount[p.charAt(i)-'a']++;
        }
        int left = 0;
        char[] chars = s.toCharArray();
        List<Integer> res = new ArrayList<>();
        for (int right = 0; right < chars.length; right++) {
            count[chars[right]-'a']++;
            if (right-left+1==p.length()){
                // 判断数组是否相等
                if (Arrays.equals(count,targerCount)){
                    res.add(left);
                }
                count[chars[left]-'a']--;
                left++;
            }
        }
        return res;
    }
}
