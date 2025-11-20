package Hot100;

import java.util.Stack;

public class L72 {

    public static void main(String[] args) {
        dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        // 当该天气温大于栈顶元素气温时，栈顶出栈，用下标计算插值
        // 当该天气温小于栈顶元素时，元素入栈，等待后边的元素大于它
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int[] answer = new int[temperatures.length];
        for (int i = 1; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]) {
                // 注意这里的判断条件需要加上 temperatures[i]>temperatures[stack.peek()] 而不是在循环内加上if判断，否则会出现死循环
                // 气温升高
                Integer prevIndex = stack.pop();
                answer[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return answer;
    }
}
