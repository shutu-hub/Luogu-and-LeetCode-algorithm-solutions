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
        int maxRight = 0;
        List<Integer> res = new ArrayList<>();
        int lastIndex = 0;
        for (int i = 0; i < chars.length; i++) {
            if (i>maxRight){
                res.add(i-lastIndex);
                lastIndex=i;
            }
            if (i==chars.length-1){
                res.add(i-lastIndex+1);
                lastIndex=i;
            }
            Integer indexMax = map.get(chars[i]);// 该元素最大下标
            maxRight=Math.max(maxRight,indexMax);
        }
        return res;
    }
}
