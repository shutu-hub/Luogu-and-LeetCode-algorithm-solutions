package Hot100;

public class L12 {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    public static String minWindow(String s, String t) {
       // 找到 s 字符中覆盖 t 字符的最小子串
       // 解题思路：滑动窗口策略，定义左边界和右边界，当该区间满足要求，则尝试收缩左边界，更新最小值
       if(s.length()<t.length()){
           return "";
       }
       int minLength=Integer.MAX_VALUE;
       int minStart=0;
       int left = 0;
       char[] chars = s.toCharArray();
       int[] targetCount = new int[128];
       int[] count = new int[128];
        for (int i = 0; i < t.length(); i++) {
            targetCount[t.charAt(i)]++;
        }
       for (int rihgt = 0; rihgt < chars.length; rihgt++) {
           count[chars[rihgt]]++;
           // 当区间合法时，不但收缩左边界 while 而不是 if，这样能在一个合法区间时，将左侧所有不满足的元素剔除，从而得到最小区间
           while (check(count,targetCount)){
               // 记录合法区间的值
               int curLength=rihgt-left+1;
               if (curLength<minLength){
                   minStart=left;
                   minLength=curLength;
               }
               // 收缩左边界
               count[chars[left]]--;
               left++;
           }
       }
       if (minLength==Integer.MAX_VALUE){
           return "";
       }
       return s.substring(minStart,minStart+minLength);
    }

    public static boolean check(int[] count,int[] targetCount){
        // 判断当前区间是否可以覆盖目标元素
        for (int i = 0; i < targetCount.length; i++) {
            if (count[i]<targetCount[i]){
                return false;
            }
        }
        return true;
    }
}
