package Hot100;

import java.util.ArrayList;
import java.util.List;

public class L61 {

    public  List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), res);
        return res;
    }

    private  void backtrack(String s, int start, List<String> path, List<List<String>> res) {
        if (start>=s.length()){
            // 开始位置已经超过字符串长度了，说明已经找到一个结果了
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String substring = s.substring(start, i + 1);
            if (isPalindrome(substring)){
                // 当前子串是回文字符串，可以在该位置剪切
                path.add(substring);
                backtrack(s,i+1,path,res);
                // 不在当前位置剪切
                path.remove(path.size()-1);
            }
        }
    }

    private  boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}
