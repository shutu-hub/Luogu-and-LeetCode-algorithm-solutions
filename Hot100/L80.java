package Hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L80 {

    public static void main(String[] args) {
        List<Integer> list = partitionLabels("ababcbacadefegdehijhklij");
        for (Integer integer : list) {
            System.out.print(integer+" ");
        }
    }

    /**
     * ababcbaca defegde hijhklij
     * @param s
     * @return
     */
    public static List<Integer> partitionLabels(String s) {
        // 记录每个字母的最大索引，当前片段的最大边界，达到最大边界时记录片段长度
        Map<Character,Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
           map.put(chars[i],i);
        }
        List<Integer> res = new ArrayList<>();
        int start = 0, end =0;
        for (int i = 0; i < chars.length; i++) {
            Integer indexMax = map.get(chars[i]);// 该元素最大下标
            end=Math.max(end,indexMax);
            if (i==end){
                res.add(end-start+1);
                start=i+1;
            }
        }
        return res;
    }
}
