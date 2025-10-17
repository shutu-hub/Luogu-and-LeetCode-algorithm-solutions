package Hot100;

import java.util.ArrayList;
import java.util.List;

public class L59 {

    static List<String> res;

    public static void main(String[] args) {
        List<String> list = generateParenthesis(1);
        for (String s : list) {
            System.out.println(s);
        }
    }
    public static List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        // 深度为 2n,放右括号的时候，要使左括号的个数--
        digui(n,0,1,new StringBuilder(),n);
        return res;
    }

    private static void digui(int n, int left, int index, StringBuilder sb,int leftNum) {
       if (index>2*n){
           res.add(new String(sb));
           return;
       }
       // 放置左括号，判断是否还可以放置
        if (leftNum>0){
            sb.append("(");
            digui(n,left+1,index+1,sb,leftNum-1);
            sb.deleteCharAt(index-1);
        }
        // 放置右括号
        if (left>0){
            // 左边存在左括号，可放置
            sb.append(")");
            digui(n,left-1,index+1,sb,leftNum);
            sb.deleteCharAt(index-1);
        }
    }
}
