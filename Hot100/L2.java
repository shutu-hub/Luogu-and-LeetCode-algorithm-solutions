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
        List<List<String>> lists = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            // String string = chars.toString(); string:[C@119d7047 chars 数组没有重写toString方法，无法直接用来比较
            String key = Arrays.toString(chars);//  String key = new String(chars);
            if (map.containsKey(key)){
                List<String> list = map.get(key);
                list.add(str);
            }else{
                ArrayList<String> values = new ArrayList<>();
                values.add(str);
                map.put(key,values);
            }
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            lists.add(entry.getValue());
        }
        return lists;
    }
}
