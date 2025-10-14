package Hot100;

import java.util.ArrayList;
import java.util.List;

public class L57 {

    List<String> list ;
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()){
            return new ArrayList<>();
        }
        list = new ArrayList<>();
        String[] strs = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        digui(digits,strs,0,new StringBuilder());
        return list;
    }

    public void digui(String digit,String[] strs,int index,StringBuilder sb){
        if (sb.length()>=digit.length()){
            list.add(new String(sb));
            return;
        }
        int c = digit.charAt(index)-'0';// 第一个字符
        char[] chars = strs[c-2].toCharArray();
        for (char aChar : chars) {
            sb.append(aChar);
            digui(digit, strs, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
