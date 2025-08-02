package Hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L9 {
    public static void main(String[] args) {
        findAnagrams("cbaebabacd","abc");
    }

    public static List<Integer> findAnagrams(String s, String p) {
        // s串长度小于p，不会出现异位词的子串
        if (s.length()<p.length()){
            return new ArrayList<>();
        }
        // 统计两个字符串对应字符的数量
        int[]countP=new int[26];
        int[]countS=new int[26];
        // 先统计前p.length()个长度的个数
        for (int i = 0; i < p.length(); i++) {
            countP[p.charAt(i)-'a']++;
            countS[s.charAt(i)-'a']++;
        }
        ArrayList<Integer> lists = new ArrayList<>();
        if (Arrays.equals(countP,countS)){
            lists.add(0);
        }
        // 统计之后的个数，右边界元素个数++，旧的左边界个数--
        int left=1;
        for (int i = p.length(); i < s.length() ; i++,left++) {
            countS[s.charAt(i)-'a']++;
            countS[s.charAt(left-1)-'a']--;// left 是新的左边界，left -1 是旧的左边界
            if (Arrays.equals(countP,countS)){
                lists.add(left);
            }
        }
        return lists;
    }
}
