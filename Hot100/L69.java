package Hot100;

import java.util.Stack;

public class L69 {

    public static void main(String[] args) {
        L69 l69 = new L69();
        System.out.println(l69.isValid("()"));
        System.out.println(l69.isValid("()[]{}"));
        System.out.println(l69.isValid("(]"));
        System.out.println(l69.isValid("([)]"));
        System.out.println(l69.isValid("{[]}"));
    }

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char ele : chars) {
            if (ele=='('){
                stack.push('(');
            }else if (ele=='['){
                stack.push('[');
            }else if (ele=='{'){
                stack.push('{');
            }else if (ele==')'){
                // 需要先判断是否有元素，比如']',此时栈里应该有'[',栈为空则不合法
                if (stack.isEmpty()){
                    return false;
                }
                Character popped = stack.pop();
                if (popped!='('){
                    return false;
                }
            }else if (ele==']'){
                if (stack.isEmpty()){
                    return false;
                }
                Character popped = stack.pop();
                if (popped!='['){
                    return false;
                }
            }else {
                if (stack.isEmpty()){
                    return false;
                }
                Character popped = stack.pop();
                if (popped!='{'){
                    return false;
                }
            }
        }
        // 如果栈里存在元素，则说明有多余的左括号没有匹配
        return stack.isEmpty();
    }
}
