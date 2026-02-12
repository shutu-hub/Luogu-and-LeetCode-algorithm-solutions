package Hot100;

public class L12 {
    public static void main(String[] args) {
        System.out.println(minWindow("cabwefgewcwaefgcf", "cae"));
    }

    public static String minWindow(String s, String t) {
        if (s.length()<t.length()){
            return "";
        }
        // 找到一个包含 t 字符的最小窗口
        int[] target = new int[128];
        for (int i = 0; i < t.length(); i++) {
            target[t.charAt(i)]++;
        }

        int[] window = new int[128];
        char[] chars = s.toCharArray();
        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int minLeft = 0;

        for (int right = 0; right < chars.length; right++) {
            window[chars[right]]++;
            // 判断窗口是否满足要求
            while(check(target,window)){
               if (right-left+1 <minLength){
                   minLength=right-left+1;
                   minLeft=left;
               }
                // 不管这个左边界的字符个数是否大于对应 target 的元素的个数，都需要收缩左边界
                if (window[chars[left]]>0){
                    window[chars[left]]--;
                }
                left++;
            }
        }
        if (minLength==Integer.MAX_VALUE){
            return "";
        }
        return s.substring(minLeft,minLeft+minLength);
    }

    public static boolean check(int[] target,int[] window){
        for (int i = 0; i < target.length; i++) {
            if (target[i]>window[i]){
                return false;
            }
        }
        return true;
    }
}
