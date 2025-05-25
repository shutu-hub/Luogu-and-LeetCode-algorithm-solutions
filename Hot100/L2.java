package Hot100;

import java.util.*;

public class L2 {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    /**
     * 本题目时间复杂度分析
     * 外层for循环，执行n次；每个字符串排序，对长度为k的字符数组排序，时间复杂度是 klogk；map查询元素的时间复杂度为 O(1)
     * 总的时间复杂度为 O(n*klogk)
     * n<=1e4 k<=1e2
     * 1e4*1e2log100=1e6*7
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        // key存储排序后的字符串 value存储异位的字符串
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            // 对字符串排序 这样异位的字符串将相等
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for (String key : map.keySet()) {
            ans.add(map.get(key));
        }
        return ans;
    }
}
